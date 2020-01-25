package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;

import java.util.List;

public interface StockTransferRepository {
    void updateBatchStockTransfers(List<StockTransfer> transfers);
    long getTotalTransfersCount();
}
