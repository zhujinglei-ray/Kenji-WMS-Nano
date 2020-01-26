package com.kenji.wms.stock.controller;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.frontend.ProductStockAtLocations;
import com.kenji.wms.stock.repository.LocationQtyRepository;
import com.kenji.wms.stock.service.ProductStockLocationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ProductStockLocationController {

    private ProductStockLocationQueryService service;
    private LocationQtyRepository locationQtyRepository;

    @Autowired
    public ProductStockLocationController(ProductStockLocationQueryService service, LocationQtyRepository locationQtyRepository) {
        this.service = service;
        this.locationQtyRepository = locationQtyRepository;
    }

    @GetMapping("/product/ids")
    public Set<String> getAllProductIdsFromStockTable(){
        return service.getAllProductIdsAvailableInStockTable();
    }

    @GetMapping("/stockbyid/{id}")
    public List<ProductStock> getStocksByProductId(@PathVariable("id") String productId){
        return service.getAllStocksByProductId(productId);
    }

    @GetMapping("/stockbyloaction/{id}")
    public ProductStockAtLocations getASearchedProductById(@PathVariable("id") String productId){
        return service.getProductAtAllLocation(productId);
    }
    @GetMapping("/stock/updateone")
    public void updateOne(){
        locationQtyRepository.updateOneInLocation();
    }

    @GetMapping("/stocklocation/update/all")
    public void updateAll(){
        locationQtyRepository.updateAllQtyInLocation();
    }
}
