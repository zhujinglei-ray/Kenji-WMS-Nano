package com.kenji.wms.model.frontend;

import java.util.Objects;

public class SearchedProduct {
    private long productID;
    private String name;
    private long stockID;
    private int qtyInWarehouse;
    private int qtyInArndale;
    private int qtyInPreston;
    private int qtyInBury;
    private int qtyInWarrinton;
    private String barcode;

    public SearchedProduct(long productID, String name, long stockID, int qtyInWarehouse, int qtyInArndale, int qtyInPreston, int qtyInBury, int qtyInWarrinton, String barcode) {
        this.productID = productID;
        this.name = name;
        this.stockID = stockID;
        this.qtyInWarehouse = qtyInWarehouse;
        this.qtyInArndale = qtyInArndale;
        this.qtyInPreston = qtyInPreston;
        this.qtyInBury = qtyInBury;
        this.qtyInWarrinton = qtyInWarrinton;
        this.barcode = barcode;
    }

    public SearchedProduct() {
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStockID() {
        return stockID;
    }

    public void setStockID(long stockID) {
        this.stockID = stockID;
    }

    public int getQtyInWarehouse() {
        return qtyInWarehouse;
    }

    public void setQtyInWarehouse(int qtyInWarehouse) {
        this.qtyInWarehouse = qtyInWarehouse;
    }

    public int getQtyInArndale() {
        return qtyInArndale;
    }

    public void setQtyInArndale(int qtyInArndale) {
        this.qtyInArndale = qtyInArndale;
    }

    public int getQtyInPreston() {
        return qtyInPreston;
    }

    public void setQtyInPreston(int qtyInPreston) {
        this.qtyInPreston = qtyInPreston;
    }

    public int getQtyInBury() {
        return qtyInBury;
    }

    public void setQtyInBury(int qtyInBury) {
        this.qtyInBury = qtyInBury;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getQtyInWarrinton() {
        return qtyInWarrinton;
    }

    public void setQtyInWarrinton(int qtyInWarrinton) {
        this.qtyInWarrinton = qtyInWarrinton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchedProduct that = (SearchedProduct) o;
        return productID == that.productID &&
                stockID == that.stockID &&
                qtyInWarehouse == that.qtyInWarehouse &&
                qtyInArndale == that.qtyInArndale &&
                qtyInPreston == that.qtyInPreston &&
                qtyInBury == that.qtyInBury &&
                qtyInWarrinton == that.qtyInWarrinton &&
                barcode == that.barcode &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, stockID, qtyInWarehouse, qtyInArndale, qtyInPreston, qtyInBury, qtyInWarrinton, barcode);
    }

    @Override
    public String toString() {
        return "SearchedProduct{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", stockID=" + stockID +
                ", qtyInWarehouse=" + qtyInWarehouse +
                ", qtyInArndale=" + qtyInArndale +
                ", qtyInPreston=" + qtyInPreston +
                ", qtyInBury=" + qtyInBury +
                ", qtyInWarrinton=" + qtyInWarrinton +
                ", barcode=" + barcode +
                '}';
    }
}
