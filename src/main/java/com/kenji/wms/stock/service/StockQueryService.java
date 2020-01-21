package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.ProductStock;

import java.util.List;

public interface StockQueryService {
    List<ProductStock> getStocksByBarcode(String barcode);
}
