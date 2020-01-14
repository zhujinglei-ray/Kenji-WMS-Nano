package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

import java.util.Collection;
import java.util.List;

public interface StockQueryClient {
    List<Product> getStocksByPageNumber(int pageNumber) throws FailQueryProductException;
}
