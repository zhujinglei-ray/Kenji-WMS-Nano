package com.kenji.wms.queryservice;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.service.StockTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMovementTransferAllService {
    private StockTransferService stockTransferService;

    @Autowired
    public StockMovementTransferAllService(StockTransferService stockTransferService) {
        this.stockTransferService = stockTransferService;
    }

    public String transferAll(List<TransferLocationQty> locationQties){
//        StockTransfer stockTransfer = stockTransferService.createStockTransfer(transferLocationQty.getFromLocation(), transferLocationQty.getToLocation());
        locationQties.forEach(
                this::sendRequest
        );
        return "OK";
    }

    public TransferLocationQty resolveQtyForLocation(WarehouseIdMap map, int qty, Long productId){
        TransferLocationQty transferLocationQty = new TransferLocationQty();
        transferLocationQty.setFromLocation((long) WarehouseIdMap.WAREHOUSE.getLocationId());
        transferLocationQty.setToLocation((long)map.getLocationId());
        transferLocationQty.setQty(qty);
        transferLocationQty.setProductId(productId);
        return transferLocationQty;
    }

    private String sendRequest(TransferLocationQty transferLocationQty) {
        try{
        StockTransfer stockTransfer = stockTransferService.createStockTransfer(transferLocationQty.getFromLocation(), transferLocationQty.getToLocation());
        StockTransferItem stockTransferItem = stockTransferService.createStockTransferItem(stockTransfer, transferLocationQty.getProductId(), transferLocationQty.getQty());
        return stockTransferItem.toString();}
        catch (Exception e){
            System.out.println("Something happened and quit for this relocation");
            return "";
        }
    }
}
