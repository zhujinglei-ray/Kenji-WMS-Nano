package com.kenji.wms.stock.domain;

import java.util.Objects;

public class StockMoveSummaryRecord {
    String productName;
    String fromLocation;
    String toLocation;
    Long qty;

    public StockMoveSummaryRecord(String productName, String fromLocation, String toLocation, Long qty) {
        this.productName = productName;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockMoveSummaryRecord that = (StockMoveSummaryRecord) o;
        return Objects.equals(productName, that.productName) &&
                Objects.equals(fromLocation, that.fromLocation) &&
                Objects.equals(toLocation, that.toLocation) &&
                Objects.equals(qty, that.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, fromLocation, toLocation, qty);
    }

    @Override
    public String toString() {
        return "StockMoveSummaryRecord{" +
                "productName='" + productName + '\'' +
                ", fromLocation='" + fromLocation + '\'' +
                ", toLocation='" + toLocation + '\'' +
                ", qty=" + qty +
                '}';
    }
}
