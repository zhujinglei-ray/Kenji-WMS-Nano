package com.kenji.wms.model.domainobject;

import java.util.Objects;

public class Product {
    private long productID;
    private String name;
    private String description;
    private float costPrice;
    private float salePrice;
    private float eatOutPrice;
    private long categoryID;
    private String barcode;
    private long taxRateID;
    private long eatOutTaxRateID;
    private long brandID;
    private long supplierID;
    private long popupNoteID;
    private int unitOfSale;
    private int volumeOfSale;
    private long multiChoiceID;
    private long colourID;
    private long variantGroupID;
    private Size size;
    private Sku sku;
    private boolean sellOnWeb;
    private boolean sellOnTill;
    private long orderCode;
    private long buttonColourID;
    private String sortPosition;
    private long magentoAttributeSetID;
    private float rRPrice;
    private long costPriceTaxRateID;
    private String productType;
    private float tareWeight;
    private String articleCode;

    public Product(long productID, String name, String description, float costPrice, float salePrice, float eatOutPrice, long categoryID, String barcode, long taxRateID, long eatOutTaxRateID, long brandID, long supplierID, long popupNoteID, int unitOfSale, int volumeOfSale, long multiChoiceID, long colourID, long variantGroupID, Size size, Sku sku, boolean sellOnWeb, boolean sellOnTill, long orderCode, long buttonColourID, String sortPosition, long magentoAttributeSetID, float rRPrice, long costPriceTaxRateID, String productType, float tareWeight, String articleCode) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.eatOutPrice = eatOutPrice;
        this.categoryID = categoryID;
        this.barcode = barcode;
        this.taxRateID = taxRateID;
        this.eatOutTaxRateID = eatOutTaxRateID;
        this.brandID = brandID;
        this.supplierID = supplierID;
        this.popupNoteID = popupNoteID;
        this.unitOfSale = unitOfSale;
        this.volumeOfSale = volumeOfSale;
        this.multiChoiceID = multiChoiceID;
        this.colourID = colourID;
        this.variantGroupID = variantGroupID;
        this.size = size;
        this.sku = sku;
        this.sellOnWeb = sellOnWeb;
        this.sellOnTill = sellOnTill;
        this.orderCode = orderCode;
        this.buttonColourID = buttonColourID;
        this.sortPosition = sortPosition;
        this.magentoAttributeSetID = magentoAttributeSetID;
        this.rRPrice = rRPrice;
        this.costPriceTaxRateID = costPriceTaxRateID;
        this.productType = productType;
        this.tareWeight = tareWeight;
        this.articleCode = articleCode;
    }

    public Product() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public float getEatOutPrice() {
        return eatOutPrice;
    }

    public void setEatOutPrice(float eatOutPrice) {
        this.eatOutPrice = eatOutPrice;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public long getTaxRateID() {
        return taxRateID;
    }

    public void setTaxRateID(long taxRateID) {
        this.taxRateID = taxRateID;
    }

    public long getEatOutTaxRateID() {
        return eatOutTaxRateID;
    }

    public void setEatOutTaxRateID(long eatOutTaxRateID) {
        this.eatOutTaxRateID = eatOutTaxRateID;
    }

    public long getBrandID() {
        return brandID;
    }

    public void setBrandID(long brandID) {
        this.brandID = brandID;
    }

    public long getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(long supplierID) {
        this.supplierID = supplierID;
    }

    public long getPopupNoteID() {
        return popupNoteID;
    }

    public void setPopupNoteID(long popupNoteID) {
        this.popupNoteID = popupNoteID;
    }

    public int getUnitOfSale() {
        return unitOfSale;
    }

    public void setUnitOfSale(int unitOfSale) {
        this.unitOfSale = unitOfSale;
    }

    public int getVolumeOfSale() {
        return volumeOfSale;
    }

    public void setVolumeOfSale(int volumeOfSale) {
        this.volumeOfSale = volumeOfSale;
    }

    public long getMultiChoiceID() {
        return multiChoiceID;
    }

    public void setMultiChoiceID(long multiChoiceID) {
        this.multiChoiceID = multiChoiceID;
    }

    public long getColourID() {
        return colourID;
    }

    public void setColourID(long colourID) {
        this.colourID = colourID;
    }

    public long getVariantGroupID() {
        return variantGroupID;
    }

    public void setVariantGroupID(long variantGroupID) {
        this.variantGroupID = variantGroupID;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public boolean isSellOnWeb() {
        return sellOnWeb;
    }

    public void setSellOnWeb(boolean sellOnWeb) {
        this.sellOnWeb = sellOnWeb;
    }

    public boolean isSellOnTill() {
        return sellOnTill;
    }

    public void setSellOnTill(boolean sellOnTill) {
        this.sellOnTill = sellOnTill;
    }

    public long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(long orderCode) {
        this.orderCode = orderCode;
    }

    public long getButtonColourID() {
        return buttonColourID;
    }

    public void setButtonColourID(long buttonColourID) {
        this.buttonColourID = buttonColourID;
    }

    public String getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(String sortPosition) {
        this.sortPosition = sortPosition;
    }

    public long getMagentoAttributeSetID() {
        return magentoAttributeSetID;
    }

    public void setMagentoAttributeSetID(long magentoAttributeSetID) {
        this.magentoAttributeSetID = magentoAttributeSetID;
    }

    public float getrRPrice() {
        return rRPrice;
    }

    public void setrRPrice(float rRPrice) {
        this.rRPrice = rRPrice;
    }

    public long getCostPriceTaxRateID() {
        return costPriceTaxRateID;
    }

    public void setCostPriceTaxRateID(long costPriceTaxRateID) {
        this.costPriceTaxRateID = costPriceTaxRateID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public float getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(float tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productID == product.productID &&
                Float.compare(product.costPrice, costPrice) == 0 &&
                Float.compare(product.salePrice, salePrice) == 0 &&
                Float.compare(product.eatOutPrice, eatOutPrice) == 0 &&
                categoryID == product.categoryID &&
                taxRateID == product.taxRateID &&
                eatOutTaxRateID == product.eatOutTaxRateID &&
                brandID == product.brandID &&
                supplierID == product.supplierID &&
                popupNoteID == product.popupNoteID &&
                unitOfSale == product.unitOfSale &&
                volumeOfSale == product.volumeOfSale &&
                multiChoiceID == product.multiChoiceID &&
                colourID == product.colourID &&
                variantGroupID == product.variantGroupID &&
                sellOnWeb == product.sellOnWeb &&
                sellOnTill == product.sellOnTill &&
                orderCode == product.orderCode &&
                buttonColourID == product.buttonColourID &&
                magentoAttributeSetID == product.magentoAttributeSetID &&
                Float.compare(product.rRPrice, rRPrice) == 0 &&
                costPriceTaxRateID == product.costPriceTaxRateID &&
                Float.compare(product.tareWeight, tareWeight) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(barcode, product.barcode) &&
                Objects.equals(size, product.size) &&
                Objects.equals(sku, product.sku) &&
                Objects.equals(sortPosition, product.sortPosition) &&
                Objects.equals(productType, product.productType) &&
                Objects.equals(articleCode, product.articleCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID, name, description, costPrice, salePrice, eatOutPrice, categoryID, barcode, taxRateID, eatOutTaxRateID, brandID, supplierID, popupNoteID, unitOfSale, volumeOfSale, multiChoiceID, colourID, variantGroupID, size, sku, sellOnWeb, sellOnTill, orderCode, buttonColourID, sortPosition, magentoAttributeSetID, rRPrice, costPriceTaxRateID, productType, tareWeight, articleCode);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", eatOutPrice=" + eatOutPrice +
                ", categoryID=" + categoryID +
                ", barcode='" + barcode + '\'' +
                ", taxRateID=" + taxRateID +
                ", eatOutTaxRateID=" + eatOutTaxRateID +
                ", brandID=" + brandID +
                ", supplierID=" + supplierID +
                ", popupNoteID=" + popupNoteID +
                ", unitOfSale=" + unitOfSale +
                ", volumeOfSale=" + volumeOfSale +
                ", multiChoiceID=" + multiChoiceID +
                ", colourID=" + colourID +
                ", variantGroupID=" + variantGroupID +
                ", size=" + size +
                ", sku=" + sku +
                ", sellOnWeb=" + sellOnWeb +
                ", sellOnTill=" + sellOnTill +
                ", orderCode=" + orderCode +
                ", buttonColourID=" + buttonColourID +
                ", sortPosition='" + sortPosition + '\'' +
                ", magentoAttributeSetID=" + magentoAttributeSetID +
                ", rRPrice=" + rRPrice +
                ", costPriceTaxRateID=" + costPriceTaxRateID +
                ", productType='" + productType + '\'' +
                ", tareWeight=" + tareWeight +
                ", articleCode='" + articleCode + '\'' +
                '}';
    }
}
