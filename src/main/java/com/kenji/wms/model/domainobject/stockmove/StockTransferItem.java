package com.kenji.wms.model.domainobject.stockmove;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;

public class StockTransferItem {
    @JsonProperty("StockTransferItemID")
    private Long stockTransferItemID;
    @JsonProperty("StockTransferID")
    private Long stockTransferID;
    @JsonProperty("ProductID")
    private Long productID;
    @JsonProperty("QtySent")
    private Long qtySent;
    @JsonProperty("QtyReceived")
    private Long qtyReceived;
    @JsonProperty("ItemReasonID")
    private Long itemReasonID;
    @JsonProperty("QtyNewFrom")
    private Long qtyNewFrom;
    @JsonProperty("QtyNewTo")
    private Long qtyNewTo;
    @JsonProperty("CostPrice")
    private BigDecimal costPrice;

    public StockTransferItem(Long stockTransferItemID, Long stockTransferID, Long productID, Long qtySent, Long qtyReceived, Long itemReasonID, Long qtyNewFrom, Long qtyNewTo, BigDecimal costPrice) {
        this.stockTransferItemID = stockTransferItemID;
        this.stockTransferID = stockTransferID;
        this.productID = productID;
        this.qtySent = qtySent;
        this.qtyReceived = qtyReceived;
        this.itemReasonID = itemReasonID;
        this.qtyNewFrom = qtyNewFrom;
        this.qtyNewTo = qtyNewTo;
        this.costPrice = costPrice;
    }

    public StockTransferItem() {
    }

    public Long getStockTransferItemID() {
        return stockTransferItemID;
    }

    public void setStockTransferItemID(Long stockTransferItemID) {
        this.stockTransferItemID = stockTransferItemID;
    }

    public Long getStockTransferID() {
        return stockTransferID;
    }

    public void setStockTransferID(Long stockTransferID) {
        this.stockTransferID = stockTransferID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getQtySent() {
        return qtySent;
    }

    public void setQtySent(Long qtySent) {
        this.qtySent = qtySent;
    }

    public Long getQtyReceived() {
        return qtyReceived;
    }

    public void setQtyReceived(Long qtyReceived) {
        this.qtyReceived = qtyReceived;
    }

    public Long getItemReasonID() {
        return itemReasonID;
    }

    public void setItemReasonID(Long itemReasonID) {
        this.itemReasonID = itemReasonID;
    }

    public Long getQtyNewFrom() {
        return qtyNewFrom;
    }

    public void setQtyNewFrom(Long qtyNewFrom) {
        this.qtyNewFrom = qtyNewFrom;
    }

    public Long getQtyNewTo() {
        return qtyNewTo;
    }

    public void setQtyNewTo(Long qtyNewTo) {
        this.qtyNewTo = qtyNewTo;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockTransferItem that = (StockTransferItem) o;
        return Objects.equals(stockTransferItemID, that.stockTransferItemID) &&
                Objects.equals(stockTransferID, that.stockTransferID) &&
                Objects.equals(productID, that.productID) &&
                Objects.equals(qtySent, that.qtySent) &&
                Objects.equals(qtyReceived, that.qtyReceived) &&
                Objects.equals(itemReasonID, that.itemReasonID) &&
                Objects.equals(qtyNewFrom, that.qtyNewFrom) &&
                Objects.equals(qtyNewTo, that.qtyNewTo) &&
                Objects.equals(costPrice, that.costPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockTransferItemID, stockTransferID, productID, qtySent, qtyReceived, itemReasonID, qtyNewFrom, qtyNewTo, costPrice);
    }

    @Override
    public String toString() {
        return "StockTransferItem{" +
                "stockTransferItemID=" + stockTransferItemID +
                ", stockTransferID=" + stockTransferID +
                ", productID=" + productID +
                ", qtySent=" + qtySent +
                ", qtyReceived=" + qtyReceived +
                ", itemReasonID=" + itemReasonID +
                ", qtyNewFrom=" + qtyNewFrom +
                ", qtyNewTo=" + qtyNewTo +
                ", costPrice=" + costPrice +
                '}';
    }
}

