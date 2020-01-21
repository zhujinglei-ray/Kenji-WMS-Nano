package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.product.Product;

import java.util.List;

public interface ProductRepository {
    void updateBatchProducts(List<Product> products);
    long getProductIdByBarcode(String barcode);
}
