package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;

import java.util.List;

public interface ProductRepository {
    void updateBatchProducts(List<Product> products);
    long getProductIdByBarcode(String barcode);
}
