package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.service.RestStockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarcodeQueryController {
    private final RestStockQueryService restStockQueryService;

    @Autowired
    public BarcodeQueryController(RestStockQueryService restStockQueryService) {
        this.restStockQueryService = restStockQueryService;
    }

    @GetMapping(path="/query/stock/{barcode}")
    public ResponseEntity<List<ProductStock>> getProductStockByBarcode(@PathVariable("barcode") String barcode) {
        return ResponseEntity.ok(restStockQueryService.getStocksByBarcode(barcode));
    }
}
