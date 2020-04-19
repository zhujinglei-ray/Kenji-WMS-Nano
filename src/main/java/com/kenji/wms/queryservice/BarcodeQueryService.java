package com.kenji.wms.queryservice;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.ProductStockBatches;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.service.RestProductQueryService;
import com.kenji.wms.stock.service.RestStockQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarcodeQueryService {

    private final RestStockQueryService restStockQueryService;
    private final RestProductQueryService restProductQueryService;



    @Autowired
    public BarcodeQueryService(RestStockQueryService restStockQueryService, RestProductQueryService restProductQueryService) {
        this.restStockQueryService = restStockQueryService;
        this.restProductQueryService = restProductQueryService;
    }

    public SearchedProduct getStockReturnToFront(String barcodeInput) {
        SearchedProduct searchedProduct = new SearchedProduct();
        List<ProductStock> stocksByBarcode = restStockQueryService.getStocksByBarcode(barcodeInput);
        searchedProduct.setQtyInWarehouse(retrieveQtyInLocation(stocksByBarcode,WarehouseIdMap.WAREHOUSE.getLocationId()));
        searchedProduct.setQtyInBury(retrieveQtyInLocation(stocksByBarcode,WarehouseIdMap.BURY.getLocationId()));
        searchedProduct.setQtyInWarrinton(retrieveQtyInLocation(stocksByBarcode,WarehouseIdMap.WARRINTON.getLocationId()));
        searchedProduct.setQtyInPreston(retrieveQtyInLocation(stocksByBarcode,WarehouseIdMap.PRESTON.getLocationId()));
        searchedProduct.setQtyInArndale(retrieveQtyInLocation(stocksByBarcode,WarehouseIdMap.ARNDALE.getLocationId()));
        searchedProduct.setName(retrieveName(barcodeInput));
        searchedProduct.setBarcode(barcodeInput);
        return searchedProduct;
    }


    private int retrieveQtyInLocation(List<ProductStock> stocksByBarcode, int warehouseId) {
        try {
            return stocksByBarcode.stream().filter(productStock ->
                    productStock.getLocationID() == Long.valueOf(warehouseId))
                    .map(ProductStock::getCurrentStock).findAny().get();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private String retrieveName(String barcodeInput){
        try {
            Product foundProduct = restProductQueryService.getProductByBarcode(barcodeInput);
            return foundProduct.getName();
        } catch (FailQueryProductException e) {
            return "NA";
        }
    }

    public String retrieveName(Integer barcodeInput){
        try {
            Product foundProduct = restProductQueryService.getProductByBarcode(barcodeInput.toString());
            return foundProduct.getName();
        } catch (FailQueryProductException e) {
            return "NA";
        }
    }
}
