package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.Product;
import java.util.List;

public interface StockRepository {
    void updateBatchProducts(List<Product> products);
    long getProductIdByBarcode(String barcode);
}
