package com.kenji.wms.controller;

import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.queryservice.StockMovementTransferAllService;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.StockTransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StockMovementAllController {
    private StockMovementTransferAllService stockMovementTransferAllService;
    private final RestProductQueryService restProductQueryService;
    private StockTransferService stockTransferService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    public StockMovementAllController(StockMovementTransferAllService stockMovementTransferAllService, RestProductQueryService restProductQueryService) {
        this.stockMovementTransferAllService = stockMovementTransferAllService;
        this.restProductQueryService = restProductQueryService;
    }


    @RequestMapping(path ="/stockmove/all/{qtyBury}/{qtyPreston}/{qtyWarrinton}/{qtyArndale}/{barcode}", method = RequestMethod.GET)
    public String moveAllStocks(Authentication authentication,
                                                @PathVariable("qtyBury") int qtyBury,
                                                @PathVariable("qtyPreston") int qtyPreston,
                                                @PathVariable("qtyWarrinton") int qtyWarrinton,
                                                @PathVariable("qtyArndale") int qtyArndale,
                                                @PathVariable("barcode") int barcode){
        Long productId;
        try {
            logger.debug("Prepared to move stock for barcode {}", barcode);
            productId = restProductQueryService.getProductByBarcode(String.valueOf(barcode)).getId();
        } catch (FailQueryProductException e) {
            return  "tables";
        }
        String name = authentication.getName();
        List<TransferLocationQty> transferLocationQties = new ArrayList<>();
        TransferLocationQty transferToBury = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.BURY,qtyBury,productId);
        TransferLocationQty transferToPreston = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.PRESTON,qtyPreston,productId);
        TransferLocationQty transferToWarrinton = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.WARRINTON, qtyWarrinton,productId);
        TransferLocationQty transferToArndale = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.ARNDALE,qtyArndale,productId);
        stockTransferService.saveMoveForUsername(name, transferToBury);
        stockTransferService.saveMoveForUsername(name, transferToPreston);
        stockTransferService.saveMoveForUsername(name, transferToWarrinton);
        stockTransferService.saveMoveForUsername(name, transferToArndale);
        System.out.println("Wow!!!! All saved");
        return  "tables";
    }

    @RequestMapping(path ="/stockmove/check", method = RequestMethod.GET)
    public Map<Pair<Integer, Integer>, List<TransferLocationQty>> checkMoveCache(Authentication authentication){
        return stockTransferService.getTransferMapForUser(authentication.getName());
    }
}
