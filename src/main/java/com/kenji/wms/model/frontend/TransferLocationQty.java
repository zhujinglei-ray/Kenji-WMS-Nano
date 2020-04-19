package com.kenji.wms.model.frontend;


import java.util.Objects;

public class TransferLocationQty {
    private Long fromLocation;
    private Long toLocation;
    private int qty;
    private Long productId;
    private String productName;

    public TransferLocationQty(Long fromLocation, Long toLocation, int qty, Long productId) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.qty = qty;
        this.productId = productId;
    }

    public TransferLocationQty(Long fromLocation, Long toLocation, int qty, Long productId, String productName) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.qty = qty;
        this.productId = productId;
        this.productName = productName;
    }

    public TransferLocationQty() {
    }

    public Long getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Long fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Long getToLocation() {
        return toLocation;
    }

    public void setToLocation(Long toLocation) {
        this.toLocation = toLocation;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferLocationQty that = (TransferLocationQty) o;
        return qty == that.qty &&
                Objects.equals(fromLocation, that.fromLocation) &&
                Objects.equals(toLocation, that.toLocation) &&
                Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromLocation, toLocation, qty, productId);
    }

    @Override
    public String toString() {
        return "TransferLocationQty{" +
                "fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                ", qty=" + qty +
                ", productId='" + productId + '\'' +
                '}';
    }
}
