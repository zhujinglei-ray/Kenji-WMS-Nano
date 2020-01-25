package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.stock.clients.ProductQueryClient;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.clients.StockTransferClient;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.repository.ProductRepository;
import com.kenji.wms.stock.repository.StockRepository;
import com.kenji.wms.stock.repository.StockTransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Service
public class RestSynchronizeService implements SynchronizeService {
    private final StockQueryClient stockQueryClient;
    private final StockTransferClient stockTransferClient;
    private final ProductQueryClient productQueryClient;
    private final Integer stockPageSize;
    private final Integer productPageSize;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final StockTransferRepository  stockTransferRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public RestSynchronizeService(
            StockQueryClient stockQueryClient,
            ProductQueryClient productQueryClient,
            @Value("${eposnow.stock.page.query.size}") Integer stockPageSize,
            @Value("${eposnow.product.page.query.size}")Integer productPageSize,
            StockRepository stockRepository,
            ProductRepository productRepository,
            StockTransferClient stockTransferClient,
            StockTransferRepository stockTransferRepository) {
        this.stockQueryClient = stockQueryClient;
        this.productQueryClient = productQueryClient;
        this.stockPageSize = stockPageSize;
        this.productPageSize = productPageSize;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.stockTransferClient = stockTransferClient;
        this.stockTransferRepository = stockTransferRepository;
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
    public BigInteger syncAllStockTransferWithEposnow() throws FailQueryStockException {
        logger.debug("Start sync all stock transfer records");
        List<StockTransfer> transfers = new LinkedList<>();
        int pageCount = 1;
        while (true) {
            Collection<StockTransfer> batch = stockTransferClient.getStockTransfersByPageNumber(pageCount);
            transfers.addAll(batch);
            logger.debug("Page {} of stocktransfer record has finished", pageCount);
            pageCount++;
            if (batch.size() < stockPageSize) break;
        }
        stockTransferRepository.updateBatchStockTransfers(transfers);
        return BigInteger.valueOf(transfers.size());
    }

    @Override
    public long syncProductsByPage(Integer pageNumber) throws FailQueryProductException {
        logger.debug("Get product list from client for page " + pageNumber);
        List<Product> batch = productQueryClient.getProductsByPageNumber(pageNumber);
        logger.debug("Get products with size " + batch.size());
        productRepository.updateBatchProducts(batch);
        return batch.size();
    }

    @Override
    public long syncStocksByPage(Integer pageNumber) throws FailQueryStockException {
        logger.debug("Get stock list from client for page " + pageNumber);
        List<ProductStock> batch = stockQueryClient.getStocksByPageNumber(pageNumber);
        logger.debug("Get products with size " + batch.size());
        stockRepository.updateBatchProductStocks(batch);
        return batch.size();
    }

    @Override
    public long syncStockTransferByPage(Integer pageNumber) throws FailQueryStockException {
        logger.debug("Get stock transfer list from client for page " + pageNumber);
        List<StockTransfer> batch = stockTransferClient.getStockTransfersByPageNumber(pageNumber);
        logger.debug("Get stock transfer with size " + batch.size());
        stockTransferRepository.updateBatchStockTransfers(batch);
        return batch.size();
    }
}
