package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

public interface ProductQueryService {
    Product getProductByBarcode(String barcode) throws FailQueryProductException;
}
