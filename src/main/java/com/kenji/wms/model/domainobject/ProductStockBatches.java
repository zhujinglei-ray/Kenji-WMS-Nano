package com.kenji.wms.model.domainobject;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductStockBatches {
    @JsonProperty("Id")
    private long id;
    //this is usually equals to the productStockID
    @JsonProperty("ProductStockId")
    private long productStockId;
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonProperty("CurrentStock")
    private int currentStock;
    @JsonProperty("CurrentVolume")
    private int currentVolume;
    @JsonProperty("CostPrice")
    private float costPrice;
    @JsonProperty("SupplierId")
    private long supplierId;
    @JsonProperty("CostPriceMeasurementSchemeItemId")
    private long costPriceMeasurementSchemeItemId;
    @JsonProperty("CostPriceMeasurementUnitVolume")
    private long costPriceMeasurementUnitVolume;
    @JsonProperty("CostPriceUnitFactor")
    private int costPriceUnitFactor;
    @JsonProperty("CostPriceUnit")
    private String costPriceUnit;
    @JsonProperty("StockMeasurementSchemeItemId")
    private int stockMeasurementSchemeItemId;
    @JsonProperty("StockUnit")
    private String stockUnit;
    @JsonProperty("StockFactor")
    private int stockFactor;

    public ProductStockBatches() {
    }

    public ProductStockBatches(long id, long productStockId, String createdDate, int currentStock, int currentVolume, float costPrice, long supplierId, long costPriceMeasurementSchemeItemId, long costPriceMeasurementUnitVolume, int costPriceUnitFactor, String costPriceUnit, int stockMeasurementSchemeItemId, String stockUnit, int stockFactor) {
        this.id = id;
        this.productStockId = productStockId;
        this.createdDate = createdDate;
        this.currentStock = currentStock;
        this.currentVolume = currentVolume;
        this.costPrice = costPrice;
        this.supplierId = supplierId;
        this.costPriceMeasurementSchemeItemId = costPriceMeasurementSchemeItemId;
        this.costPriceMeasurementUnitVolume = costPriceMeasurementUnitVolume;
        this.costPriceUnitFactor = costPriceUnitFactor;
        this.costPriceUnit = costPriceUnit;
        this.stockMeasurementSchemeItemId = stockMeasurementSchemeItemId;
        this.stockUnit = stockUnit;
        this.stockFactor = stockFactor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductStockId() {
        return productStockId;
    }

    public void setProductStockId(long productStockId) {
        this.productStockId = productStockId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getCostPriceMeasurementSchemeItemId() {
        return costPriceMeasurementSchemeItemId;
    }

    public void setCostPriceMeasurementSchemeItemId(long costPriceMeasurementSchemeItemId) {
        this.costPriceMeasurementSchemeItemId = costPriceMeasurementSchemeItemId;
    }

    public long getCostPriceMeasurementUnitVolume() {
        return costPriceMeasurementUnitVolume;
    }

    public void setCostPriceMeasurementUnitVolume(long costPriceMeasurementUnitVolume) {
        this.costPriceMeasurementUnitVolume = costPriceMeasurementUnitVolume;
    }

    public int getCostPriceUnitFactor() {
        return costPriceUnitFactor;
    }

    public void setCostPriceUnitFactor(int costPriceUnitFactor) {
        this.costPriceUnitFactor = costPriceUnitFactor;
    }

    public String getCostPriceUnit() {
        return costPriceUnit;
    }

    public void setCostPriceUnit(String costPriceUnit) {
        this.costPriceUnit = costPriceUnit;
    }

    public int getStockMeasurementSchemeItemId() {
        return stockMeasurementSchemeItemId;
    }

    public void setStockMeasurementSchemeItemId(int stockMeasurementSchemeItemId) {
        this.stockMeasurementSchemeItemId = stockMeasurementSchemeItemId;
    }

    public String getStockUnit() {
        return stockUnit;
    }

    public void setStockUnit(String stockUnit) {
        this.stockUnit = stockUnit;
    }

    public int getStockFactor() {
        return stockFactor;
    }

    public void setStockFactor(int stockFactor) {
        this.stockFactor = stockFactor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStockBatches that = (ProductStockBatches) o;
        return id == that.id &&
                productStockId == that.productStockId &&
                currentStock == that.currentStock &&
                currentVolume == that.currentVolume &&
                Float.compare(that.costPrice, costPrice) == 0 &&
                supplierId == that.supplierId &&
                costPriceMeasurementSchemeItemId == that.costPriceMeasurementSchemeItemId &&
                costPriceMeasurementUnitVolume == that.costPriceMeasurementUnitVolume &&
                costPriceUnitFactor == that.costPriceUnitFactor &&
                stockMeasurementSchemeItemId == that.stockMeasurementSchemeItemId &&
                stockFactor == that.stockFactor &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(costPriceUnit, that.costPriceUnit) &&
                Objects.equals(stockUnit, that.stockUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productStockId, createdDate, currentStock, currentVolume, costPrice, supplierId, costPriceMeasurementSchemeItemId, costPriceMeasurementUnitVolume, costPriceUnitFactor, costPriceUnit, stockMeasurementSchemeItemId, stockUnit, stockFactor);
    }

    @Override
    public String toString() {
        return "ProductStockBatches{" +
                "id=" + id +
                ", productStockId=" + productStockId +
                ", createdDate='" + createdDate + '\'' +
                ", currentStock=" + currentStock +
                ", currentVolume=" + currentVolume +
                ", costPrice=" + costPrice +
                ", supplierId=" + supplierId +
                ", costPriceMeasurementSchemeItemId=" + costPriceMeasurementSchemeItemId +
                ", costPriceMeasurementUnitVolume=" + costPriceMeasurementUnitVolume +
                ", costPriceUnitFactor=" + costPriceUnitFactor +
                ", costPriceUnit='" + costPriceUnit + '\'' +
                ", stockMeasurementSchemeItemId=" + stockMeasurementSchemeItemId +
                ", stockUnit='" + stockUnit + '\'' +
                ", stockFactor=" + stockFactor +
                '}';
    }
}
