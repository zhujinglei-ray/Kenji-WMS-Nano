package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;

import java.util.List;

public interface StockQueryClient {
    List<ProductStock> getStocksByPageNumber(int pageNumber) throws FailQueryStockException;
    ProductStock getStockByStockId(long stockId) throws  FailQueryStockException;
}
