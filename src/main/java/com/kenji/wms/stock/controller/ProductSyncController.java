package com.kenji.wms.stock.controller;

import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.service.SynchronizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class ProductSyncController {
    private final SynchronizeService synchronizeService;

    @Autowired
    public ProductSyncController(SynchronizeService synchronizeService) {
        this.synchronizeService = synchronizeService;
    }

    @GetMapping(path="/sync/product/{pageNumber}")
    public ResponseEntity<String> syncProductsByPageNumber(@PathVariable("pageNumber") int pageNumber) throws FailQueryProductException {
        System.out.println("prepared to sync with page number" + pageNumber);
        long totalCount = synchronizeService.syncProductsByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" products for page " + pageNumber);
    }

    @GetMapping(path="/sync/product/all")
    public ResponseEntity<String> syncAllProducts() throws FailQueryProductException {
        BigInteger bigInteger = synchronizeService.syncAllProductWithEposnow();
        return ResponseEntity.ok("Sync with all products with size " + bigInteger);
    }

    @GetMapping(path="/sync/stock/{pageNumber}")
    public ResponseEntity<String> syncStockByPageNumber(@PathVariable("pageNumber") int pageNumber) throws FailQueryStockException {
        System.out.println("prepared to sync with page number" + pageNumber);
        long totalCount = synchronizeService.syncStocksByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" stock records for page " + pageNumber);
    }

    @GetMapping(path="/sync/stock/all")
    public ResponseEntity<String> syncAllStocks() throws FailQueryStockException {
        BigInteger bigInteger = synchronizeService.syncAllProductStockWithEposnow();
        return ResponseEntity.ok("Sync with all product stocks with size: " + bigInteger);
    }

    @GetMapping(path="/sync/stocktransfer/{pageNumber}")
    public ResponseEntity<String> syncStockTransferByPageNumber(@PathVariable("pageNumber") int pageNumber) throws FailQueryStockException {
        System.out.println("prepared to sync with page number" + pageNumber);
        long totalCount = synchronizeService.syncStockTransferByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" stock transfer records for page " + pageNumber);
    }

    @GetMapping(path="/sync/stocktransfer/all")
    public ResponseEntity<String> syncAllStockTransfers() throws FailQueryStockException {
        BigInteger bigInteger = synchronizeService.syncAllStockTransferWithEposnow();
        return ResponseEntity.ok("Sync with all stock transfers with size: " + bigInteger);
    }
}
