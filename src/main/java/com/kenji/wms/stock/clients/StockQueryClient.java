package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

import java.util.List;

public interface StockQueryClient {
    List<Product> getProductsByPageNumber(int pageNumber) throws FailQueryProductException;
    List<ProductStock> getStocksByPageNumber(int pageNumber) throws FailQueryProductException;
    Product getProductInfoByProductId(long productId) throws  FailQueryProductException;
}
