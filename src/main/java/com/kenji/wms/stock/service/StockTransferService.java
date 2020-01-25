package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.stock.exceptions.FailQueryStockException;

public interface StockTransferService {
    StockTransfer createStockTransfer(Long fromLocation, Long toLocation) throws FailQueryStockException;
    StockTransferItem createStockTransferItem(StockTransfer stockTransfer, Long productId, Long qty) throws FailQueryStockException;
}
