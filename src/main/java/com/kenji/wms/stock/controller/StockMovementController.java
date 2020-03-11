package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import com.kenji.wms.model.domainobject.stockmove.StockTransferItem;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.stock.exceptions.FailQueryStockException;
import com.kenji.wms.stock.service.StockTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StockMovementController {
    private StockTransferService stockTransferService;

    @Autowired
    public StockMovementController(StockTransferService stockTransferService) {
        this.stockTransferService = stockTransferService;
    }

    @GetMapping("/stockmove/{productId}{fromLocation}/{toLocation}/{productId}/{qty}")
    public ResponseEntity<StockTransferItem> moveStocks(
            @PathVariable("fromLocation") Long fromLocation,
            @PathVariable("toLocation") Long toLocation,
            @PathVariable("productId") Long productId,
            @PathVariable("qty") Long qty) throws FailQueryStockException {
        StockTransfer stockTransfer = stockTransferService.createStockTransfer(fromLocation, toLocation);
        StockTransferItem stockTransferItem = stockTransferService.createStockTransferItem(stockTransfer, productId, qty);
        return  ResponseEntity.ok(stockTransferItem);
    }

    @PostMapping("/stockmove/cache/{productId}{fromLocation}/{toLocation}/{productId}/{qty}")
    public ResponseEntity<String> addMoveStocks(
            Authentication authentication,
            @PathVariable("fromLocation") Long fromLocation,
            @PathVariable("toLocation") Long toLocation,
            @PathVariable("productId") Long productId,
            @PathVariable("qty") int qty) {
        stockTransferService.saveMoveForUsername(authentication.getName(),
                fromLocation,
                toLocation,
                productId,
                qty);
        return  ResponseEntity.ok("OK");
    }

    @GetMapping("/stockmove/cache/")
    public ResponseEntity<Map<Pair<Integer, Integer>, List<TransferLocationQty>>> checkCurrentMap(
            Authentication authentication) {
        Map<Pair<Integer, Integer>, List<TransferLocationQty>> transferMapForUser = stockTransferService.getTransferMapForUser(authentication.getName());
        return  ResponseEntity.ok(transferMapForUser);
    }
}
