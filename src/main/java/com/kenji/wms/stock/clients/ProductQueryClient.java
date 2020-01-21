package com.kenji.wms.stock.clients;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;

import java.util.List;

public interface ProductQueryClient {
    List<Product> getProductsByPageNumber(int pageNumber) throws FailQueryProductException;
    Product getProductInfoByProductId(long productId) throws  FailQueryProductException;
}
