package com.kenji.wms.model.domainobject.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class SalePriceTaxGroup {
    @JsonProperty("Id")
    private long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("TaxRates")
    private List<TaxRate> taxRates;

    public SalePriceTaxGroup(long id, String name, List<TaxRate> taxRates) {
        this.id = id;
        this.name = name;
        this.taxRates = taxRates;
    }

    public SalePriceTaxGroup() {
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

    public List<TaxRate> getTaxRates() {
        return taxRates;
    }

    public void setTaxRates(List<TaxRate> taxRates) {
        this.taxRates = taxRates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalePriceTaxGroup that = (SalePriceTaxGroup) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(taxRates, that.taxRates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taxRates);
    }

    @Override
    public String toString() {
        return "SalePriceTaxGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxRates=" + taxRates +
                '}';
    }
}
