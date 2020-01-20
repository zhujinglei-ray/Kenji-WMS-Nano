package com.kenji.wms.model.domainobject.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TaxRate {
    @JsonProperty("TaxGroupId")
    private long taxGroupId;
    @JsonProperty("TaxRateId")
    private long taxRateId;
    @JsonProperty("LocationId")
    private long locationId;
    @JsonProperty("Priority")
    private long priority;
    @JsonProperty("Percentage")
    private double percentage;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("TaxCode")
    private String taxCode;

    public TaxRate(long taxGroupId, long taxRateId, long locationId, long priority, double percentage, String name, String description, String taxCode) {
        this.taxGroupId = taxGroupId;
        this.taxRateId = taxRateId;
        this.locationId = locationId;
        this.priority = priority;
        this.percentage = percentage;
        this.name = name;
        this.description = description;
        this.taxCode = taxCode;
    }

    public TaxRate() {
    }

    public long getTaxGroupId() {
        return taxGroupId;
    }

    public void setTaxGroupId(long taxGroupId) {
        this.taxGroupId = taxGroupId;
    }

    public long getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(long taxRateId) {
        this.taxRateId = taxRateId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
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

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxRate taxRate = (TaxRate) o;
        return taxGroupId == taxRate.taxGroupId &&
                taxRateId == taxRate.taxRateId &&
                locationId == taxRate.locationId &&
                priority == taxRate.priority &&
                Double.compare(taxRate.percentage, percentage) == 0 &&
                Objects.equals(name, taxRate.name) &&
                Objects.equals(description, taxRate.description) &&
                Objects.equals(taxCode, taxRate.taxCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxGroupId, taxRateId, locationId, priority, percentage, name, description, taxCode);
    }

    @Override
    public String toString() {
        return "TaxRate{" +
                "taxGroupId=" + taxGroupId +
                ", taxRateId=" + taxRateId +
                ", locationId=" + locationId +
                ", priority=" + priority +
                ", percentage=" + percentage +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", taxCode='" + taxCode + '\'' +
                '}';
    }
}
