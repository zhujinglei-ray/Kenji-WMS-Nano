package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.service.StockTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockMovementController {
    private StockTransferService stockTransferService;

    @Autowired
    public StockMovementController(StockTransferService stockTransferService) {
        this.stockTransferService = stockTransferService;
    }

    @GetMapping("/stockmove/{fromLocation}/{toLocation}/{productId}/{qty}")
    public ResponseEntity<StockTransferItem> moveStocks(
            @PathVariable("fromLocation") Long fromLocation,
            @PathVariable("toLocation") Long toLocation,
            @PathVariable("productId") Long productId,
            @PathVariable("qty") Long qty) throws FailQueryStockException {
        StockTransfer stockTransfer = stockTransferService.createStockTransfer(fromLocation, toLocation);
//        return ResponseEntity.ok(stockTransfer);
        StockTransferItem stockTransferItem = stockTransferService.createStockTransferItem(stockTransfer, productId, qty);
        return  ResponseEntity.ok(stockTransferItem);
    }
}
