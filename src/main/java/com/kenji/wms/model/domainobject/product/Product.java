package com.kenji.wms.model.domainobject.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class Product {
    @JsonProperty("Id")
    private long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("CostPrice")
    private float costPrice;
    @JsonProperty("IsCostPriceIncTax")
    private boolean costPriceIncTax;
    @JsonProperty("SalePrice")
    private float salePrice;
    @JsonProperty("IsSalePriceIncTax")
    private boolean salePriceIncTax;
    @JsonProperty("EatOutPrice")
    private float eatOutPrice;
    @JsonProperty("IsEatOutPriceIncTax")
    private boolean eatOutPriceIncTax;
    @JsonProperty("CategoryID")
    private long categoryID;
    @JsonProperty("Barcode")
    private String barcode;
    @JsonProperty("SalePriceTaxGroupId")
    private String salePriceTaxGroupId;
    @JsonProperty("EatOutPriceTaxGroupId")
    private String eatOutPriceTaxGroupId;
    @JsonProperty("CostPriceTaxGroupId")
    private String costPriceTaxGroupId;
    @JsonProperty("BrandID")
    private long brandID;
    @JsonProperty("SupplierID")
    private long supplierID;
    @JsonProperty("PopupNoteID")
    private long popupNoteID;
    @JsonProperty("UnitOfSale")
    private int unitOfSale;
    @JsonProperty("VolumeOfSale")
    private int volumeOfSale;
    @JsonProperty("VariantGroupID")
    private long variantGroupID;
    @JsonProperty("MultipleChoiceNoteId")
    private long multipleChoiceNoteId;
    @JsonProperty("Size")
    private String size;
    @JsonProperty("Sku")
    private String sku;
    @JsonProperty("SellOnWeb")
    private boolean sellOnWeb;
    @JsonProperty("SellOnTill")
    private boolean sellOnTill;
    @JsonProperty("OrderCode")
    private String orderCode;
    @JsonProperty("SortPosition")
    private String sortPosition;
    @JsonProperty("RrPrice")
    private float rrPrice;
    @JsonProperty("ProductType")
    private long productType;
    @JsonProperty("TareWeight")
    private float tareWeight;
    @JsonProperty("ArticleCode")
    private String articleCode;
    @JsonProperty("IsTaxExemptable")
    private boolean taxExemptable;
    @JsonProperty("ReferenceCode")
    private String referenceCode;
    @JsonProperty("IsVariablePrice")
    private boolean variablePrice;
    @JsonProperty("IsArchived")
    private boolean archived;
    @JsonProperty("ColourId")
    private Long colourId;
    @JsonProperty("MeasurementDetails")
    private String measurementDetails;
    @JsonProperty("Supplier")
    private Supplier supplier;
    @JsonProperty("ProductTags")
    private List<ProductTags> productTags;
    @JsonProperty("ProductUdfs")
    private List<String> productUdfs;
    @JsonProperty("ProductLocationAreaPrices")
    private List<String> productLocationAreaPrices;
    @JsonProperty("SalePriceTaxGroup")
    private SalePriceTaxGroup salePriceTaxGroup;
    @JsonProperty("EatOutPriceTaxGroup")
    private EatOutPriceTaxGroup eatOutPriceTaxGroup;
    @JsonProperty("CostPriceTaxGroup")
    private CostPriceTaxGroup costPriceTaxGroup;
    public Product(long id, String name, String description, float costPrice, boolean costPriceIncTax, float salePrice, boolean salePriceIncTax, float eatOutPrice, boolean eatOutPriceIncTax, long categoryID, String barcode, String salePriceTaxGroupId, String eatOutPriceTaxGroupId, String costPriceTaxGroupId, long brandID, long supplierID, long popupNoteID, int unitOfSale, int volumeOfSale, long variantGroupID, long multipleChoiceNoteId, String size, String sku, boolean sellOnWeb, boolean sellOnTill, String orderCode, String sortPosition, float rrPrice, long productType, float tareWeight, String articleCode, boolean taxExemptable, String referenceCode, boolean variablePrice, boolean archived, Long colourId, String measurementDetails, Supplier supplier, List<ProductTags> productTags, List<String> productUdfs, List<String> productLocationAreaPrices, SalePriceTaxGroup salePriceTaxGroup, EatOutPriceTaxGroup eatOutPriceTaxGroup, CostPriceTaxGroup costPriceTaxGroup) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.costPrice = costPrice;
        this.costPriceIncTax = costPriceIncTax;
        this.salePrice = salePrice;
        this.salePriceIncTax = salePriceIncTax;
        this.eatOutPrice = eatOutPrice;
        this.eatOutPriceIncTax = eatOutPriceIncTax;
        this.categoryID = categoryID;
        this.barcode = barcode;
        this.salePriceTaxGroupId = salePriceTaxGroupId;
        this.eatOutPriceTaxGroupId = eatOutPriceTaxGroupId;
        this.costPriceTaxGroupId = costPriceTaxGroupId;
        this.brandID = brandID;
        this.supplierID = supplierID;
        this.popupNoteID = popupNoteID;
        this.unitOfSale = unitOfSale;
        this.volumeOfSale = volumeOfSale;
        this.variantGroupID = variantGroupID;
        this.multipleChoiceNoteId = multipleChoiceNoteId;
        this.size = size;
        this.sku = sku;
        this.sellOnWeb = sellOnWeb;
        this.sellOnTill = sellOnTill;
        this.orderCode = orderCode;
        this.sortPosition = sortPosition;
        this.rrPrice = rrPrice;
        this.productType = productType;
        this.tareWeight = tareWeight;
        this.articleCode = articleCode;
        this.taxExemptable = taxExemptable;
        this.referenceCode = referenceCode;
        this.variablePrice = variablePrice;
        this.archived = archived;
        this.colourId = colourId;
        this.measurementDetails = measurementDetails;
        this.supplier = supplier;
        this.productTags = productTags;
        this.productUdfs = productUdfs;
        this.productLocationAreaPrices = productLocationAreaPrices;
        this.salePriceTaxGroup = salePriceTaxGroup;
        this.eatOutPriceTaxGroup = eatOutPriceTaxGroup;
        this.costPriceTaxGroup = costPriceTaxGroup;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isCostPriceIncTax() {
        return costPriceIncTax;
    }

    public void setCostPriceIncTax(boolean costPriceIncTax) {
        this.costPriceIncTax = costPriceIncTax;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public boolean isSalePriceIncTax() {
        return salePriceIncTax;
    }

    public void setSalePriceIncTax(boolean salePriceIncTax) {
        this.salePriceIncTax = salePriceIncTax;
    }

    public float getEatOutPrice() {
        return eatOutPrice;
    }

    public void setEatOutPrice(float eatOutPrice) {
        this.eatOutPrice = eatOutPrice;
    }

    public boolean isEatOutPriceIncTax() {
        return eatOutPriceIncTax;
    }

    public void setEatOutPriceIncTax(boolean eatOutPriceIncTax) {
        this.eatOutPriceIncTax = eatOutPriceIncTax;
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

    public String getSalePriceTaxGroupId() {
        return salePriceTaxGroupId;
    }

    public void setSalePriceTaxGroupId(String salePriceTaxGroupId) {
        this.salePriceTaxGroupId = salePriceTaxGroupId;
    }

    public String getEatOutPriceTaxGroupId() {
        return eatOutPriceTaxGroupId;
    }

    public void setEatOutPriceTaxGroupId(String eatOutPriceTaxGroupId) {
        this.eatOutPriceTaxGroupId = eatOutPriceTaxGroupId;
    }

    public String getCostPriceTaxGroupId() {
        return costPriceTaxGroupId;
    }

    public void setCostPriceTaxGroupId(String costPriceTaxGroupId) {
        this.costPriceTaxGroupId = costPriceTaxGroupId;
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

    public long getVariantGroupID() {
        return variantGroupID;
    }

    public void setVariantGroupID(long variantGroupID) {
        this.variantGroupID = variantGroupID;
    }

    public long getMultipleChoiceNoteId() {
        return multipleChoiceNoteId;
    }

    public void setMultipleChoiceNoteId(long multipleChoiceNoteId) {
        this.multipleChoiceNoteId = multipleChoiceNoteId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getSortPosition() {
        return sortPosition;
    }

    public void setSortPosition(String sortPosition) {
        this.sortPosition = sortPosition;
    }

    public float getRrPrice() {
        return rrPrice;
    }

    public void setRrPrice(float rrPrice) {
        this.rrPrice = rrPrice;
    }

    public long getProductType() {
        return productType;
    }

    public void setProductType(long productType) {
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

    public boolean isTaxExemptable() {
        return taxExemptable;
    }

    public void setTaxExemptable(boolean taxExemptable) {
        this.taxExemptable = taxExemptable;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public boolean isVariablePrice() {
        return variablePrice;
    }

    public void setVariablePrice(boolean variablePrice) {
        this.variablePrice = variablePrice;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Long getColourId() {
        return colourId;
    }

    public void setColourId(Long colourId) {
        this.colourId = colourId;
    }

    public String getMeasurementDetails() {
        return measurementDetails;
    }

    public void setMeasurementDetails(String measurementDetails) {
        this.measurementDetails = measurementDetails;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<ProductTags> getProductTags() {
        return productTags;
    }

    public void setProductTags(List<ProductTags> productTags) {
        this.productTags = productTags;
    }

    public List<String> getProductUdfs() {
        return productUdfs;
    }

    public void setProductUdfs(List<String> productUdfs) {
        this.productUdfs = productUdfs;
    }

    public List<String> getProductLocationAreaPrices() {
        return productLocationAreaPrices;
    }

    public void setProductLocationAreaPrices(List<String> productLocationAreaPrices) {
        this.productLocationAreaPrices = productLocationAreaPrices;
    }

    public SalePriceTaxGroup getSalePriceTaxGroup() {
        return salePriceTaxGroup;
    }

    public void setSalePriceTaxGroup(SalePriceTaxGroup salePriceTaxGroup) {
        this.salePriceTaxGroup = salePriceTaxGroup;
    }

    public EatOutPriceTaxGroup getEatOutPriceTaxGroup() {
        return eatOutPriceTaxGroup;
    }

    public void setEatOutPriceTaxGroup(EatOutPriceTaxGroup eatOutPriceTaxGroup) {
        this.eatOutPriceTaxGroup = eatOutPriceTaxGroup;
    }

    public CostPriceTaxGroup getCostPriceTaxGroup() {
        return costPriceTaxGroup;
    }

    public void setCostPriceTaxGroup(CostPriceTaxGroup costPriceTaxGroup) {
        this.costPriceTaxGroup = costPriceTaxGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Float.compare(product.costPrice, costPrice) == 0 &&
                costPriceIncTax == product.costPriceIncTax &&
                Float.compare(product.salePrice, salePrice) == 0 &&
                salePriceIncTax == product.salePriceIncTax &&
                Float.compare(product.eatOutPrice, eatOutPrice) == 0 &&
                eatOutPriceIncTax == product.eatOutPriceIncTax &&
                categoryID == product.categoryID &&
                brandID == product.brandID &&
                supplierID == product.supplierID &&
                popupNoteID == product.popupNoteID &&
                unitOfSale == product.unitOfSale &&
                volumeOfSale == product.volumeOfSale &&
                variantGroupID == product.variantGroupID &&
                multipleChoiceNoteId == product.multipleChoiceNoteId &&
                sellOnWeb == product.sellOnWeb &&
                sellOnTill == product.sellOnTill &&
                orderCode == product.orderCode &&
                Float.compare(product.rrPrice, rrPrice) == 0 &&
                productType == product.productType &&
                Float.compare(product.tareWeight, tareWeight) == 0 &&
                taxExemptable == product.taxExemptable &&
                variablePrice == product.variablePrice &&
                archived == product.archived &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(barcode, product.barcode) &&
                Objects.equals(salePriceTaxGroupId, product.salePriceTaxGroupId) &&
                Objects.equals(eatOutPriceTaxGroupId, product.eatOutPriceTaxGroupId) &&
                Objects.equals(costPriceTaxGroupId, product.costPriceTaxGroupId) &&
                Objects.equals(size, product.size) &&
                Objects.equals(sku, product.sku) &&
                Objects.equals(sortPosition, product.sortPosition) &&
                Objects.equals(articleCode, product.articleCode) &&
                Objects.equals(referenceCode, product.referenceCode) &&
                Objects.equals(colourId, product.colourId) &&
                Objects.equals(measurementDetails, product.measurementDetails) &&
                Objects.equals(supplier, product.supplier) &&
                Objects.equals(productTags, product.productTags) &&
                Objects.equals(productUdfs, product.productUdfs) &&
                Objects.equals(productLocationAreaPrices, product.productLocationAreaPrices) &&
                Objects.equals(salePriceTaxGroup, product.salePriceTaxGroup) &&
                Objects.equals(eatOutPriceTaxGroup, product.eatOutPriceTaxGroup) &&
                Objects.equals(costPriceTaxGroup, product.costPriceTaxGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, costPrice, costPriceIncTax, salePrice, salePriceIncTax, eatOutPrice, eatOutPriceIncTax, categoryID, barcode, salePriceTaxGroupId, eatOutPriceTaxGroupId, costPriceTaxGroupId, brandID, supplierID, popupNoteID, unitOfSale, volumeOfSale, variantGroupID, multipleChoiceNoteId, size, sku, sellOnWeb, sellOnTill, orderCode, sortPosition, rrPrice, productType, tareWeight, articleCode, taxExemptable, referenceCode, variablePrice, archived, colourId, measurementDetails, supplier, productTags, productUdfs, productLocationAreaPrices, salePriceTaxGroup, eatOutPriceTaxGroup, costPriceTaxGroup);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", costPriceIncTax=" + costPriceIncTax +
                ", salePrice=" + salePrice +
                ", salePriceIncTax=" + salePriceIncTax +
                ", eatOutPrice=" + eatOutPrice +
                ", eatOutPriceIncTax=" + eatOutPriceIncTax +
                ", categoryID=" + categoryID +
                ", barcode='" + barcode + '\'' +
                ", salePriceTaxGroupId='" + salePriceTaxGroupId + '\'' +
                ", eatOutPriceTaxGroupId='" + eatOutPriceTaxGroupId + '\'' +
                ", costPriceTaxGroupId='" + costPriceTaxGroupId + '\'' +
                ", brandID=" + brandID +
                ", supplierID=" + supplierID +
                ", popupNoteID=" + popupNoteID +
                ", unitOfSale=" + unitOfSale +
                ", volumeOfSale=" + volumeOfSale +
                ", variantGroupID=" + variantGroupID +
                ", multipleChoiceNoteId=" + multipleChoiceNoteId +
                ", size='" + size + '\'' +
                ", sku='" + sku + '\'' +
                ", sellOnWeb=" + sellOnWeb +
                ", sellOnTill=" + sellOnTill +
                ", orderCode=" + orderCode +
                ", sortPosition='" + sortPosition + '\'' +
                ", rrPrice=" + rrPrice +
                ", productType=" + productType +
                ", tareWeight=" + tareWeight +
                ", articleCode='" + articleCode + '\'' +
                ", taxExemptable=" + taxExemptable +
                ", referenceCode='" + referenceCode + '\'' +
                ", variablePrice=" + variablePrice +
                ", archived=" + archived +
                ", colourId=" + colourId +
                ", measurementDetails='" + measurementDetails + '\'' +
                ", supplier=" + supplier +
                ", productTags=" + productTags +
                ", productUdfs=" + productUdfs +
                ", productLocationAreaPrices=" + productLocationAreaPrices +
                ", salePriceTaxGroup=" + salePriceTaxGroup +
                ", eatOutPriceTaxGroup=" + eatOutPriceTaxGroup +
                ", costPriceTaxGroup=" + costPriceTaxGroup +
                '}';
    }
}
