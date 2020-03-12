package com.kenji.wms.controller;

import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.queryservice.StockMovementTransferAllService;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.StockTransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StockMovementAllController {
    private StockMovementTransferAllService stockMovementTransferAllService;
    private final RestProductQueryService restProductQueryService;
    private StockTransferService stockTransferService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public StockMovementAllController(StockMovementTransferAllService stockMovementTransferAllService, RestProductQueryService restProductQueryService, StockTransferService stockTransferService) {
        this.stockMovementTransferAllService = stockMovementTransferAllService;
        this.restProductQueryService = restProductQueryService;
        this.stockTransferService = stockTransferService;
    }

    @RequestMapping(path ="/stockmove/all/{qtyBury}/{qtyPreston}/{qtyWarrinton}/{qtyArndale}/{barcode}", method = RequestMethod.GET)
    public String moveAllStocks(Authentication authentication,
                                                @PathVariable("qtyBury") int qtyBury,
                                                @PathVariable("qtyPreston") int qtyPreston,
                                                @PathVariable("qtyWarrinton") int qtyWarrinton,
                                                @PathVariable("qtyArndale") int qtyArndale,
                                                @PathVariable("barcode") int barcode){
        Long productId;
        String productName;
        try {
            logger.debug("Prepared to move stock for barcode {}", barcode);
            Product productByBarcode = restProductQueryService.getProductByBarcode(String.valueOf(barcode));
            productId = productByBarcode.getId();
            productName = productByBarcode.getName();
        } catch (FailQueryProductException e) {
            return  "tables";
        }
        String name = authentication.getName();
        List<TransferLocationQty> transferLocationQties = new ArrayList<>();
        TransferLocationQty transferToBury = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.BURY,qtyBury,productId, productName);
        TransferLocationQty transferToPreston = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.PRESTON,qtyPreston,productId, productName);
        TransferLocationQty transferToWarrinton = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.WARRINTON, qtyWarrinton,productId, productName);
        TransferLocationQty transferToArndale = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.ARNDALE,qtyArndale,productId, productName);
        addOneCache(name, transferToBury);
        addOneCache(name, transferToPreston);
        addOneCache(name, transferToWarrinton);
        addOneCache(name, transferToArndale);
        System.out.println("Wow!!!! All saved");
        return  "tables";
    }

    @RequestMapping(path ="/stockmove/move/", method = RequestMethod.POST)
    public String moveAllCache(Authentication authentication){
        String username = authentication.getName();
        stockTransferService.moveForUser(username);
        stockTransferService.cleanMoveForUser(username);
        return "table-summary";
    }

    @RequestMapping(path ="/stockmove/clean/", method = RequestMethod.POST)
    public String clearAllCache(Authentication authentication){
        String username = authentication.getName();
        stockTransferService.cleanMoveForUser(username);
        return "table-summary";
    }
    private void addOneCache(String name, TransferLocationQty transferLocationQty) {
        if (transferLocationQty.getQty() > 0) {
            stockTransferService.saveMoveForUsername(name, transferLocationQty);
        }
    }
}
