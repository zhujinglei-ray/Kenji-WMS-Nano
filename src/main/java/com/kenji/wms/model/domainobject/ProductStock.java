package com.kenji.wms.model.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductStock {
    @JsonProperty("StockID")
    private long stockID;
    @JsonProperty("LocationID")
    private long locationID;
    @JsonProperty("ProductID")
    private long productID;
    @JsonProperty("CurrentStock")
    private int currentStock;
    @JsonProperty("MinStock")
    private int minStock;
    @JsonProperty("MaxStock")
    private int maxStock;
    @JsonProperty("CurrentVolume")
    private int currentVolume;
    @JsonProperty("OnOrder")
    private int onOrder;
    @JsonProperty("Alerts")
    private boolean alert;
    @JsonProperty("CostPrice")
    private float costPrice;

    public ProductStock(long stockID, long locationID, long productID, int currentStock, int minStock, int maxStock, int currentVolume, int onOrder, boolean alert, float costPrice) {
        this.stockID = stockID;
        this.locationID = locationID;
        this.productID = productID;
        this.currentStock = currentStock;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.currentVolume = currentVolume;
        this.onOrder = onOrder;
        this.alert = alert;
        this.costPrice = costPrice;
    }

    public ProductStock() {
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

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
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

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public int getOnOrder() {
        return onOrder;
    }

    public void setOnOrder(int onOrder) {
        this.onOrder = onOrder;
    }

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStock that = (ProductStock) o;
        return stockID == that.stockID &&
                locationID == that.locationID &&
                productID == that.productID &&
                currentStock == that.currentStock &&
                minStock == that.minStock &&
                maxStock == that.maxStock &&
                currentVolume == that.currentVolume &&
                onOrder == that.onOrder &&
                alert == that.alert &&
                Float.compare(that.costPrice, costPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockID, locationID, productID, currentStock, minStock, maxStock, currentVolume, onOrder, alert, costPrice);
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "stockID=" + stockID +
                ", locationID=" + locationID +
                ", productID=" + productID +
                ", currentStock=" + currentStock +
                ", minStock=" + minStock +
                ", maxStock=" + maxStock +
                ", currentVolume=" + currentVolume +
                ", onOrder=" + onOrder +
                ", alert=" + alert +
                ", costPrice=" + costPrice +
                '}';
    }
}
