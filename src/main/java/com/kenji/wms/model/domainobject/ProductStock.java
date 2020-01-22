package com.kenji.wms.model.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductStock {
    @JsonProperty("Id")
    private long stockID;
    @JsonProperty("LocationId")
    private long locationID;
    @JsonProperty("ProductId")
    private long productID;
    @JsonProperty("MinStock")
    private int minStock;
    @JsonProperty("MaxStock")
    private int maxStock;
    @JsonProperty("MinimumOrderAmount")
    private int minimumOrderAmount;
    @JsonProperty("MultipleOrderAmount")
    private int multipleOrderAmount;
    @JsonProperty("ProductStockBatches")
    private List<ProductStockBatches> productStockBatches = new LinkedList<>();

    public ProductStock(long stockID, long locationID, long productID, int minStock, int maxStock, int minimumOrderAmount, int multipleOrderAmount,List<ProductStockBatches> productStockBatches) {
        this.stockID = stockID;
        this.locationID = locationID;
        this.productID = productID;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.minimumOrderAmount = minimumOrderAmount;
        this.multipleOrderAmount = multipleOrderAmount;
        this.productStockBatches=productStockBatches;
    }

    public ProductStock() {
    }

    public List<ProductStockBatches> getProductStockBatches() {
        return productStockBatches;
    }

    public int getCurrentStock(){
        int num = 0;
        for(ProductStockBatches batch : productStockBatches){
            num += batch.getCurrentStock();
        }
        return num;
    }

    public void setProductStockBatches(List<ProductStockBatches> productStockBatches) {
        this.productStockBatches = productStockBatches;
    }

    public long getStockID() {
        return stockID;
    }

    public void setStockID(long stockID) {
        this.stockID = stockID;
    }

    public long getLocationID() {
        return locationID;
    }

    public void setLocationID(long locationID) {
        this.locationID = locationID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getMinimumOrderAmount() {
        return minimumOrderAmount;
    }

    public void setMinimumOrderAmount(int minimumOrderAmount) {
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public int getMultipleOrderAmount() {
        return multipleOrderAmount;
    }

    public void setMultipleOrderAmount(int multipleOrderAmount) {
        this.multipleOrderAmount = multipleOrderAmount;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStock that = (ProductStock) o;
        return stockID == that.stockID &&
                locationID == that.locationID &&
                productID == that.productID &&
                minStock == that.minStock &&
                maxStock == that.maxStock &&
                minimumOrderAmount == that.minimumOrderAmount &&
                multipleOrderAmount == that.multipleOrderAmount &&
                Objects.equals(productStockBatches, that.productStockBatches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockID, locationID, productID, minStock, maxStock, minimumOrderAmount, multipleOrderAmount, productStockBatches);
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "stockID=" + stockID +
                ", locationID=" + locationID +
                ", productID=" + productID +
                ", minStock=" + minStock +
                ", maxStock=" + maxStock +
                ", minimumOrderAmount=" + minimumOrderAmount +
                ", MultipleOrderAmount=" + multipleOrderAmount +
                ", productStockBatches=" + productStockBatches +
                '}';
    }
}
