package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

public interface ProductQueryService {
    Product getProductByBarcode(String barcode) throws FailQueryProductException;
}
