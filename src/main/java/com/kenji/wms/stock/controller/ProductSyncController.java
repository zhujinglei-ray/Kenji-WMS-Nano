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

    @GetMapping(path="/sync/{pageNumber}")
    public ResponseEntity<String> syncProductsByPageNumber(@PathVariable("pageNumber") Integer pageNumber) throws FailQueryProductException {
        long totalCount = synchronizer.syncProductsByPage(pageNumber);
        return ResponseEntity.ok("Sync with " + totalCount +" products");
    }
}
