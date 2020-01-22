package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.clients.StockQueryClient;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.repository.ProductRepository;
import com.kenji.wms.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestStockQueryService implements StockQueryService {
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final StockQueryClient stockQueryClient;

    @Autowired
    public RestStockQueryService(
            ProductRepository productRepository,
            StockRepository stockRepository,
            StockQueryClient stockQueryClient) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.stockQueryClient = stockQueryClient;
    }

    @Override
    public List<ProductStock> getStocksByBarcode(String barcode) {
        long productId = productRepository.getProductIdByBarcode(barcode);
        List<String> stockIdsForProduct = stockRepository.getStockIdsByProductId(productId);
        String productOnlyId = stockIdsForProduct.get(0);
        return getOneProductsByProductId(productId);

    }

    private ProductStock getOneProductStockById(String stockId) {
        try {
            return stockQueryClient.getStockByStockId(Long.parseLong(stockId));
        } catch (FailQueryStockException e) {
            e.printStackTrace();
        }
        return new ProductStock();
    }

    private List<ProductStock> getOneProductsByProductId(long productId) {
        try {
            return stockQueryClient.getStocksByProductId(productId);
        } catch (FailQueryStockException e) {
            e.printStackTrace();
        }
        return new LinkedList<>();
    }
}
