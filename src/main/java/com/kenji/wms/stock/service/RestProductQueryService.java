package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.clients.ProductQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestProductQueryService implements ProductQueryService {
    private final ProductRepository repository;
    private final ProductQueryClient queryClient;

    @Autowired
    public RestProductQueryService(
            ProductRepository repository,
            ProductQueryClient queryClient) {
        this.repository = repository;
        this.queryClient = queryClient;
    }

    @Override
    public Product getProductByBarcode(String barcode) throws FailQueryProductException {
        long productId = repository.getProductIdByBarcode(barcode);
        Product product = queryClient.getProductInfoByProductId(productId);
        return product;
    }
}
