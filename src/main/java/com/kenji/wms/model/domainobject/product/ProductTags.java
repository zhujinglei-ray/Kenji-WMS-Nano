package com.kenji.wms.model.domainobject.product;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ProductTags {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Name")
    private String name;

    public ProductTags(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductTags() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTags that = (ProductTags) o;
        return id == that.id &&
                name == that.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
