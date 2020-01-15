package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import java.util.List;

public interface StockRepository {
    void updateBatchProductStocks(List<ProductStock> stocks);
    List<String> getStockIdsByProductId(Long productID);
}
