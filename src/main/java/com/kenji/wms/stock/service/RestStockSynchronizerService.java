package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RestStockSynchronizerService implements StockSynchronizer {
    private final RestTemplate restTemplate;
    private final StockQueryClient stockQueryClient;
    private final Integer pageSize;

    @Autowired
    public RestStockSynchronizerService(
            RestTemplate restTemplate,
            StockQueryClient stockQueryClient,
            @Value("${stock.page.query.size}") Integer pageSize) {
        this.restTemplate = restTemplate;
        this.stockQueryClient = stockQueryClient;
        this.pageSize = pageSize;
    }

    @Override
    public BigInteger syncAllProductWithStock() throws FailQueryProductException {
        List<Product> products = new LinkedList<>();
        int pageCount = 0;
        while (true) {
            Collection<Product> batch = stockQueryClient.getStocksByPageNumber(pageCount);
            products.addAll(batch);
            if (batch.size() < pageSize) break;
        }
        return BigInteger.valueOf(products.size());
    }
}
