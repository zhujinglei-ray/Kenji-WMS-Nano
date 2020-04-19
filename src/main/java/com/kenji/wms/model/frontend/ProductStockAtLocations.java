package com.kenji.wms.model.frontend;

import java.util.Objects;

public class ProductStockAtLocations {
    private String name;
    private int qtyInWarehouse;
    private int qtyInArndale;
    private int qtyInPreston;
    private int qtyInBury;
    private int qtyInWarrinton;
    private String barcode;
    private int totalQty;

    public ProductStockAtLocations(String name, int qtyInWarehouse, int qtyInArndale, int qtyInPreston, int qtyInBury, int qtyInWarrinton, String barcode, int totalQty) {
        this.name = name;
        this.qtyInWarehouse = qtyInWarehouse;
        this.qtyInArndale = qtyInArndale;
        this.qtyInPreston = qtyInPreston;
        this.qtyInBury = qtyInBury;
        this.qtyInWarrinton = qtyInWarrinton;
        this.barcode = barcode;
        this.totalQty = totalQty;
    }

    public ProductStockAtLocations() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getQtyInWarrinton() {
        return qtyInWarrinton;
    }

    public void setQtyInWarrinton(int qtyInWarrinton) {
        this.qtyInWarrinton = qtyInWarrinton;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    @Override
    public String toString() {
        return "ProductStockAtLocations{" +
                "name='" + name + '\'' +
                ", qtyInWarehouse=" + qtyInWarehouse +
                ", qtyInArndale=" + qtyInArndale +
                ", qtyInPreston=" + qtyInPreston +
                ", qtyInBury=" + qtyInBury +
                ", qtyInWarrinton=" + qtyInWarrinton +
                ", barcode='" + barcode + '\'' +
                ", totalQty=" + totalQty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStockAtLocations that = (ProductStockAtLocations) o;
        return qtyInWarehouse == that.qtyInWarehouse &&
                qtyInArndale == that.qtyInArndale &&
                qtyInPreston == that.qtyInPreston &&
                qtyInBury == that.qtyInBury &&
                qtyInWarrinton == that.qtyInWarrinton &&
                totalQty == that.totalQty &&
                Objects.equals(name, that.name) &&
                Objects.equals(barcode, that.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, qtyInWarehouse, qtyInArndale, qtyInPreston, qtyInBury, qtyInWarrinton, barcode, totalQty);
    }
}
