package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.domainobject.stockmove.StockTransferStatus;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.stock.clients.StockTransferClient;
import com.kenji.wms.stock.domain.StockTransferReason;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.repository.BatchMoveRepository;
import com.kenji.wms.stock.repository.StockTransferRepository;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestStockTransferService implements StockTransferService {
    private final StockTransferRepository repository;
    private final BatchMoveRepository batchMoveRepository;
    private final StockTransferClient client;
    private final SynchronizeService synchronizeService;
    private final RestTemplate restTemplate;

    public RestStockTransferService(StockTransferRepository repository, BatchMoveRepository batchMoveRepository, StockTransferClient client, SynchronizeService synchronizeService, RestTemplate restTemplate) {
        this.repository = repository;
        this.batchMoveRepository = batchMoveRepository;
        this.client = client;
        this.synchronizeService = synchronizeService;
        this.restTemplate = restTemplate;
    }

    @Override
    public StockTransfer createStockTransfer(Long fromLocation, Long toLocation) throws FailQueryStockException {
        long nextStockTransferNumber = getNextStockTransferNumber();
        StockTransfer transfer = new StockTransfer();
        transfer.setTransNo(nextStockTransferNumber);
        transfer.setFromLocation(fromLocation);
        transfer.setToLocation(toLocation);
        transfer.setStaffSent(112223L);
        transfer.setStatus(StockTransferStatus.Sent);
        transfer.setReasonID(StockTransferReason.Internal_Movement.getReasonId());
        StockTransfer stockTransfer = client.createStockTransfer(transfer);
        return stockTransfer;
    }

    @Override
    public StockTransferItem createStockTransferItem(StockTransfer stockTransfer, Long productId, Long qty) throws FailQueryStockException {
        StockTransferItem item = new StockTransferItem();
        item.setQtyReceived(qty);
        item.setQtySent(qty);
        item.setProductID(productId);
        item.setStockTransferID(stockTransfer.getStockTransferID());
        StockTransferItem stockTransferItem = client.createStockTransferItem(item);
        return stockTransferItem;
    }

    @Override
    public void saveMoveForUsername(String username, Long fromLocation, Long toLocation, Long productId, int qty) {
        TransferLocationQty transferLocationQty = new TransferLocationQty();
        transferLocationQty.setFromLocation(fromLocation);
        transferLocationQty.setToLocation(toLocation);
        transferLocationQty.setProductId(productId);
        transferLocationQty.setQty(qty);
        batchMoveRepository.addOneTransferItem(username, transferLocationQty);
    }

    @Override
    public void saveMoveForUsername(String username, TransferLocationQty transferLocationQty) {
        batchMoveRepository.addOneTransferItem(username, transferLocationQty);
    }

    @Override
    public Map<Pair<Integer, Integer>, List<TransferLocationQty>> getTransferMapForUser(String username) {
        return batchMoveRepository.getAllMoveByUsername(username);
    }

    private long getNextStockTransferNumber() throws FailQueryStockException {
        long totalTransfersCount = repository.getTotalTransfersCount();
        long pageForUpdate = totalTransfersCount/200;
        List<StockTransfer> pagePrevious = client.getStockTransfersByPageNumber(pageForUpdate);
        repository.updateBatchStockTransfers(pagePrevious);
        List<StockTransfer> pageAfter = client.getStockTransfersByPageNumber(pageForUpdate + 1);
        repository.updateBatchStockTransfers(pageAfter);
        long maxPrevious = getMaxNumberFromStockTransferBatch(pagePrevious);
        long maxLast = getMaxNumberFromStockTransferBatch(pageAfter);
        return maxPrevious > maxLast ? maxPrevious + 1 : maxLast + 1;
    }

    private long getMaxNumberFromStockTransferBatch(List<StockTransfer> transfers) {
        long maxTransferNumber = 0;
        Optional<StockTransfer> transfer = transfers
                .stream()
                .reduce((first, last) -> {
            return first.getTransNo() > last.getTransNo() ? first : last; });
        if (transfer.isEmpty()) return 0;
        return transfer.get().getTransNo();
    }


}
