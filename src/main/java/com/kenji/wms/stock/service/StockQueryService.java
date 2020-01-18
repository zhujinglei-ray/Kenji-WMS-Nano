package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

import java.util.List;

public interface StockQueryService {
    List<ProductStock> getStocksByBarcode(String barcode);
}
