package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestProductQueryService implements ProductQueryService {
    private final StockRepository repository;
    private final StockQueryClient queryClient;

    @Autowired
    public RestProductQueryService(StockRepository repository, StockQueryClient queryClient) {
        this.repository = repository;
        this.queryClient = queryClient;
    }

    @Override
    public Product getProductByBarcode(String barcode) throws FailQueryProductException {
        long productId = repository.getProductIdByBarcode(barcode);
        Product product = queryClient.getProductInfoByProductId(productId);
        return product;
    }

    public List<ProductStock> getStocksByBarcode(String barcode) {
        long productId = repository.getProductIdByBarcode(barcode);
        List<ProductStock> stocksByProductId = repository.getStocksByProductId(productId);
        return stocksByProductId;
    }
}
