package com.kenji.wms.model.domainobject.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Supplier {
    @JsonProperty("ID")
    private long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("Town")
    private String town;
    @JsonProperty("County")
    private String county;
    @JsonProperty("ContactNumber")
    private String contactNumber;
    @JsonProperty("ContactNumber2")
    private String contactNumber2;
    @JsonProperty("EmailAddress")
    private String emailAddress;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("ReferenceCode")
    private String referenceCode;
    public Supplier(long id, String name, String description, String addressLine1, String addressLine2, String town, String county, String contactNumber, String contactNumber2, String emailAddress, String type, String referenceCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town;
        this.county = county;
        this.contactNumber = contactNumber;
        this.contactNumber2 = contactNumber2;
        this.emailAddress = emailAddress;
        this.type = type;
        this.referenceCode = referenceCode;
    }

    public Supplier() {
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

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactNumber2() {
        return contactNumber2;
    }

    public void setContactNumber2(String contactNumber2) {
        this.contactNumber2 = contactNumber2;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(description, supplier.description) &&
                Objects.equals(addressLine1, supplier.addressLine1) &&
                Objects.equals(addressLine2, supplier.addressLine2) &&
                Objects.equals(town, supplier.town) &&
                Objects.equals(county, supplier.county) &&
                Objects.equals(contactNumber, supplier.contactNumber) &&
                Objects.equals(contactNumber2, supplier.contactNumber2) &&
                Objects.equals(emailAddress, supplier.emailAddress) &&
                Objects.equals(type, supplier.type) &&
                Objects.equals(referenceCode, supplier.referenceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, addressLine1, addressLine2, town, county, contactNumber, contactNumber2, emailAddress, type, referenceCode);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", town='" + town + '\'' +
                ", county='" + county + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactNumber2='" + contactNumber2 + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", type='" + type + '\'' +
                ", referenceCode='" + referenceCode + '\'' +
                '}';
    }
}
