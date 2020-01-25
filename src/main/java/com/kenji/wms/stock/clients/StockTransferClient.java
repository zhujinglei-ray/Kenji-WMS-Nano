package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.exceptions.FailQueryStockException;

import java.util.List;

public interface StockTransferClient {
    StockTransfer createStockTransfer(WarehouseIdMap fromLocation, WarehouseIdMap toLocation);
    StockTransferItem createStockTransferItem(StockTransfer transfer, int qty);
    List<StockTransfer> getStockTransfersByPageNumber(int pageNumber) throws FailQueryStockException;
}
