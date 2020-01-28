package com.kenji.wms.controller;

import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.queryservice.StockMovementTransferAllService;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StockMovementAllController {
    private StockMovementTransferAllService stockMovementTransferAllService;
    private final RestProductQueryService restProductQueryService;

    @Autowired
    public StockMovementAllController(StockMovementTransferAllService stockMovementTransferAllService, RestProductQueryService restProductQueryService) {
        this.stockMovementTransferAllService = stockMovementTransferAllService;
        this.restProductQueryService = restProductQueryService;
    }


    @RequestMapping(path ="/stockmove/all/{qtyBury}/{qtyPreston}/{qtyWarrinton}/{qtyArndale}/{barcode}", method = RequestMethod.GET)
    public String moveAllStocks(
                                                @PathVariable("qtyBury") int qtyBury,
                                                @PathVariable("qtyPreston") int qtyPreston,
                                                @PathVariable("qtyWarrinton") int qtyWarrinton,
                                                @PathVariable("qtyArndale") int qtyArndale,
                                                @PathVariable("barcode") int barcode){
        Long productId;
        try {
            productId = restProductQueryService.getProductByBarcode(String.valueOf(barcode)).getId();
        } catch (FailQueryProductException e) {
            return  "/tables";
        }

        List<TransferLocationQty> transferLocationQties = new ArrayList<>();
        TransferLocationQty transferToBury = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.BURY,qtyBury,productId);
        TransferLocationQty transferToPreston = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.PRESTON,qtyPreston,productId);
        TransferLocationQty transferToWarrinton = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.WARRINTON, qtyWarrinton,productId);
        TransferLocationQty transferToArndale = stockMovementTransferAllService.resolveQtyForLocation(WarehouseIdMap.ARNDALE,qtyArndale,productId);
        transferLocationQties.add(transferToBury);
        transferLocationQties.add(transferToPreston);
        transferLocationQties.add(transferToWarrinton);
        transferLocationQties.add(transferToArndale);
        String result = stockMovementTransferAllService.transferAll(transferLocationQties);
        System.out.println("Wow!!!!");
        return  "/tables";
    }
}
