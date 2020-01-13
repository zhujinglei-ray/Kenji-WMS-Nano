package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.Product;

import java.util.Collection;

public interface StockRepository {
    void updateBatchProducts(Collection<Product> products);
}
