package com.kenji.wms.model.frontend;

import java.util.Objects;

public class SearchedProduct {
    private String name;
    private int qtyInWarehouse;
    private int qtyInArndale;
    private int qtyInPreston;
    private int qtyInBury;
    private int qtyInWarrinton;
    private String barcode;

    public SearchedProduct(String name, int qtyInWarehouse, int qtyInArndale, int qtyInPreston, int qtyInBury, int qtyInWarrinton, String barcode) {
        this.name = name;
        this.qtyInWarehouse = qtyInWarehouse;
        this.qtyInArndale = qtyInArndale;
        this.qtyInPreston = qtyInPreston;
        this.qtyInBury = qtyInBury;
        this.qtyInWarrinton = qtyInWarrinton;
        this.barcode = barcode;
    }

    public SearchedProduct() {
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
        return qtyInWarehouse == that.qtyInWarehouse &&
                qtyInArndale == that.qtyInArndale &&
                qtyInPreston == that.qtyInPreston &&
                qtyInBury == that.qtyInBury &&
                qtyInWarrinton == that.qtyInWarrinton &&
                barcode == that.barcode &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtyInWarehouse, qtyInArndale, qtyInPreston, qtyInBury, qtyInWarrinton, barcode);
    }

    @Override
    public String toString() {
        return "SearchedProduct{" +
                ", name='" + name + '\'' +
                ", qtyInWarehouse=" + qtyInWarehouse +
                ", qtyInArndale=" + qtyInArndale +
                ", qtyInPreston=" + qtyInPreston +
                ", qtyInBury=" + qtyInBury +
                ", qtyInWarrinton=" + qtyInWarrinton +
                ", barcode=" + barcode +
                '}';
    }
}
