package com.kenji.wms.stock.controller;

import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.StockSynchronizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductSyncController {
    private final StockSynchronizer synchronizer;

    @Autowired
    public ProductSyncController(StockSynchronizer synchronizer) {
        this.synchronizer = synchronizer;
    }

    @GetMapping(path="/sync/product/{pageNumber}")
    public ResponseEntity<String> syncProductsByPageNumber(@PathVariable("pageNumber") int pageNumber) throws FailQueryProductException {
        System.out.println("prepared to sync with page number" + pageNumber);
        long totalCount = synchronizer.syncProductsByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" products");
    }

    @GetMapping(path="/sync/stock/{pageNumber}")
    public ResponseEntity<String> syncStockByPageNumber(@PathVariable("pageNumber") int pageNumber) throws FailQueryProductException {
        System.out.println("prepared to sync with page number" + pageNumber);
        long totalCount = synchronizer.syncStocksByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" products");
    }
}
