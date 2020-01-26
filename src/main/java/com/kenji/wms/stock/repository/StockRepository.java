package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.ProductStock;
import java.util.List;
import java.util.Set;

public interface StockRepository {
    void updateBatchProductStocks(List<ProductStock> stocks);
    List<String> getStockIdsByProductId(Long productID);
    Set<String> getAllProductId();
    List<ProductStock> getAllProductStocksByProductId(String productId);
}
