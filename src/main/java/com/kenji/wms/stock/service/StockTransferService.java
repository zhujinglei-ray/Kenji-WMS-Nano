package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import javafx.util.Pair;

import java.util.List;
import java.util.Map;

public interface StockTransferService {
    StockTransfer createStockTransfer(Long fromLocation, Long toLocation) throws FailQueryStockException;
    StockTransferItem createStockTransferItem(StockTransfer stockTransfer, Long productId, Long qty) throws FailQueryStockException;
    void saveMoveForUsername(String username, Long fromLocation, Long toLocation, Long productId, int qty);
    Map<Pair<Integer, Integer>, List<TransferLocationQty>> getTransferMapForUser(String username);
}
