package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.clients.ProductQueryClient;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.repository.ProductRepository;
import com.kenji.wms.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class RestSynchronizeService implements SynchronizeService {
    private final StockQueryClient stockQueryClient;
    private final ProductQueryClient productQueryClient;
    private final Integer stockPageSize;
    private final Integer productPageSize;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    public RestSynchronizeService(
            StockQueryClient stockQueryClient,
            ProductQueryClient productQueryClient,
            @Value("${eposnow.stock.page.query.size}") Integer stockPageSize,
            @Value("${eposnow.product.page.query.size}")Integer productPageSize,
            StockRepository stockRepository,
            ProductRepository productRepository) {
        this.stockQueryClient = stockQueryClient;
        this.productQueryClient = productQueryClient;
        this.stockPageSize = stockPageSize;
        this.productPageSize = productPageSize;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    @Override
    public BigInteger syncAllProductWithEposnow() throws FailQueryProductException {
        List<Product> products = new LinkedList<>();
        int pageCount = 1;
        while (true) {
            Collection<Product> batch = productQueryClient.getProductsByPageNumber(pageCount);
            products.addAll(batch);
            pageCount++;
            if (batch.size() < productPageSize) break;
        }
        productRepository.updateBatchProducts(products);
        return BigInteger.valueOf(products.size());
    }

    @Override
    public BigInteger syncAllProductStockWithEposnow() throws FailQueryStockException {
        List<ProductStock> products = new LinkedList<>();
        int pageCount = 1;
        while (true) {
            Collection<ProductStock> batch = stockQueryClient.getStocksByPageNumber(pageCount);
            products.addAll(batch);
            pageCount++;
            if (batch.size() < stockPageSize) break;
        }
        stockRepository.updateBatchProductStocks(products);
        return BigInteger.valueOf(products.size());
    }

    @Override
    public long syncProductsByPage(Integer pageNumber) throws FailQueryProductException {
        System.out.println("Get product list from client for page " + pageNumber);
        List<Product> batch = productQueryClient.getProductsByPageNumber(pageNumber);
        System.out.println("Get products with size " + batch.size());
        productRepository.updateBatchProducts(batch);
        return batch.size();
    }

    @Override
    public long syncStocksByPage(Integer pageNumber) throws FailQueryStockException {
        System.out.println("Get stock list from client for page " + pageNumber);
        List<ProductStock> batch = stockQueryClient.getStocksByPageNumber(pageNumber);
        System.out.println("Get products with size " + batch.size());
        stockRepository.updateBatchProductStocks(batch);
        return batch.size();
    }
}
