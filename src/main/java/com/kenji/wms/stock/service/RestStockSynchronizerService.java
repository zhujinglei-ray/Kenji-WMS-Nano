package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class RestStockSynchronizerService implements StockSynchronizer {
    private final StockQueryClient stockQueryClient;
    private final Integer pageSize;
    private final StockRepository repository;

    @Autowired
    public RestStockSynchronizerService(
            StockQueryClient stockQueryClient,
            @Value("${stock.page.query.size}") Integer pageSize,
            StockRepository repository) {
        this.stockQueryClient = stockQueryClient;
        this.pageSize = pageSize;
        this.repository = repository;
    }

    @Override
    public BigInteger syncAllProductWithStock() throws FailQueryProductException {
        List<Product> products = new LinkedList<>();
        int pageCount = 0;
        while (true) {
            Collection<Product> batch = stockQueryClient.getProductsByPageNumber(pageCount);
            products.addAll(batch);
            if (batch.size() < pageSize) break;
        }
        repository.updateBatchProducts(products);
        return BigInteger.valueOf(products.size());
    }

    @Override
    public long syncProductsByPage(Integer pageNumber) throws FailQueryProductException {
        System.out.println("Get product list from client for page " + pageNumber);
        List<Product> batch = stockQueryClient.getProductsByPageNumber(pageNumber);
        System.out.println("Get products with size " + batch.size());
        repository.updateBatchProducts(batch);
        return batch.size();
    }

    @Override
    public long syncStocksByPage(Integer pageNumber) throws FailQueryProductException {
        System.out.println("Get stock list from client for page " + pageNumber);
        List<ProductStock> batch = stockQueryClient.getStocksByPageNumber(pageNumber);
        System.out.println("Get products with size " + batch.size());
        repository.updateBatchProductStocks(batch);
        return batch.size();
    }
}
