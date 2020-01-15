package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.stock.service.RestProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarcodeQueryController {
    private final RestProductQueryService restProductQueryService;

    @Autowired
    public BarcodeQueryController(RestProductQueryService restProductQueryService) {
        this.restProductQueryService = restProductQueryService;
    }

    @GetMapping(path="/query/stock/{barcode}")
    public ResponseEntity<List<ProductStock>> getProductStockByBarcode(@PathVariable("barcode") String barcode) {
        return ResponseEntity.ok(restProductQueryService.getStocksByBarcode(barcode));
    }
}
