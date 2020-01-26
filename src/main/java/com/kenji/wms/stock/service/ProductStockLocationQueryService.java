package com.kenji.wms.stock.service;

import com.kenji.wms.model.domainobject.ProductStock;
import com.kenji.wms.model.domainobject.product.Product;
import com.kenji.wms.model.frontend.ProductStockAtLocations;
import com.kenji.wms.model.frontend.SearchedProduct;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.repository.ProductRepository;
import com.kenji.wms.stock.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductStockLocationQueryService {
    private final ProductRepository repository;
    private final StockRepository stockRepository;

    @Autowired
    public ProductStockLocationQueryService(ProductRepository repository, StockRepository stockRepository) {
        this.repository = repository;
        this.stockRepository = stockRepository;
    }

    public Set<String> getAllProductIdsAvailableInStockTable(){
        return stockRepository.getAllProductId();
    }

    public List<ProductStock> getAllStocksByProductId(String id){
        return stockRepository.getAllProductStocksByProductId(id);
    }

    public ProductStockAtLocations getProductAtAllLocation(String id){
        List<ProductStock> stocks = stockRepository.getAllProductStocksByProductId(id);
        ProductStockAtLocations productStockAtLocations = new ProductStockAtLocations();
        Product product = repository.getProductByProductId(id);

        int qtyInBury = retrieveQtyInLocation(stocks,WarehouseIdMap.BURY.getLocationId());
        int qtyInPreston = retrieveQtyInLocation(stocks,WarehouseIdMap.PRESTON.getLocationId());
        int qtyInWarrionton = retrieveQtyInLocation(stocks,WarehouseIdMap.WARRINTON.getLocationId());
        int qtyInArndale = retrieveQtyInLocation(stocks,WarehouseIdMap.ARNDALE.getLocationId());
        int qtyInWarehouse= retrieveQtyInLocation(stocks,WarehouseIdMap.WAREHOUSE.getLocationId());
        int totalQty = qtyInBury + qtyInPreston + qtyInArndale + qtyInWarrionton + qtyInWarehouse;

        productStockAtLocations.setName(product.getName());
        productStockAtLocations.setBarcode(product.getBarcode());

        productStockAtLocations.setQtyInBury(qtyInBury);
        productStockAtLocations.setQtyInPreston(qtyInPreston);
        productStockAtLocations.setQtyInWarrinton(qtyInWarrionton);
        productStockAtLocations.setQtyInArndale(qtyInArndale);
        productStockAtLocations.setQtyInWarehouse(qtyInWarehouse);
        productStockAtLocations.setTotalQty(totalQty);

        return productStockAtLocations;
    }

    private int retrieveQtyInLocation(List<ProductStock> stocks, int warehouseId) {
        try {
            return stocks.stream().filter(productStock ->
                    productStock.getLocationID() == Long.valueOf(warehouseId))
                    .map(ProductStock::getCurrentStock).findAny().get();
        } catch (NullPointerException e) {
            return 0;
        }
    }
}
