package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.ProductQueryService;
import com.kenji.wms.stock.service.RestStockQueryService;
import com.kenji.wms.stock.service.StockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BarcodeQueryController {
    private final StockQueryService stockQueryService;
    private final ProductQueryService productQueryService;

    @Autowired
    public BarcodeQueryController(StockQueryService stockQueryService, ProductQueryService productQueryService) {
        this.stockQueryService = stockQueryService;
        this.productQueryService = productQueryService;
    }

    @GetMapping(path="/query/stock/{barcode}")
    public ResponseEntity<List<ProductStock>> getProductStockByBarcode(@PathVariable("barcode") String barcode) {
        return ResponseEntity.ok(stockQueryService.getStocksByBarcode(barcode));
    }

    @GetMapping(path="/query/product/barcode/{barcode}")
    public ResponseEntity<Product> getProductByBarcode(@PathVariable("barcode") String barcode) throws FailQueryProductException {
        return ResponseEntity.ok(productQueryService.getProductByBarcode(barcode));
    }
}
