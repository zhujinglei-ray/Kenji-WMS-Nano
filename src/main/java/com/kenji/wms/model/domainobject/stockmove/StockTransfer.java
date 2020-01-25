package com.kenji.wms.model.domainobject.stockmove;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.Objects;

public class StockTransfer {
    @JsonProperty("StockTransferID")
    private Long stockTransferID;
    @JsonProperty("TransNo")
    private Long transNo;
    @JsonProperty("FromLocation")
    private Long fromLocation;
    @JsonProperty("ToLocation")
    private Long toLocation;
    @JsonProperty("StaffSent")
    private Long staffSent;
    @JsonProperty("StaffReceived")
    private Long staffReceived;
    @JsonProperty("DateSent")
    private ZonedDateTime dateSent;
    @JsonProperty("DateReceived")
    private ZonedDateTime dateReceived;
    @JsonProperty("Status")
    private StockTransferStatus status;
    @JsonProperty("ReasonID")
    private Long reasonID;
    @JsonProperty("Note")
    private Long note;

    public StockTransfer(Long stockTransferID, Long transNo, Long fromLocation, Long toLocation, Long staffSent, Long staffReceived, ZonedDateTime dateSent, ZonedDateTime dateReceived, StockTransferStatus status, Long reasonID, Long note) {
        this.stockTransferID = stockTransferID;
        this.transNo = transNo;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.staffSent = staffSent;
        this.staffReceived = staffReceived;
        this.dateSent = dateSent;
        this.dateReceived = dateReceived;
        this.status = status;
        this.reasonID = reasonID;
        this.note = note;
    }

    public StockTransfer() {
    }

    public Long getStockTransferID() {
        return stockTransferID;
    }

    public void setStockTransferID(Long stockTransferID) {
        this.stockTransferID = stockTransferID;
    }

    public Long getTransNo() {
        return transNo;
    }

    public void setTransNo(Long transNo) {
        this.transNo = transNo;
    }

    public Long getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Long fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Long getToLocation() {
        return toLocation;
    }

    public void setToLocation(Long toLocation) {
        this.toLocation = toLocation;
    }

    public Long getStaffSent() {
        return staffSent;
    }

    public void setStaffSent(Long staffSent) {
        this.staffSent = staffSent;
    }

    public Long getStaffReceived() {
        return staffReceived;
    }

    public void setStaffReceived(Long staffReceived) {
        this.staffReceived = staffReceived;
    }

    public ZonedDateTime getDateSent() {
        return dateSent;
    }

    public void setDateSent(ZonedDateTime dateSent) {
        this.dateSent = dateSent;
    }

    public ZonedDateTime getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(ZonedDateTime dateReceived) {
        this.dateReceived = dateReceived;
    }

    public StockTransferStatus getStatus() {
        return status;
    }

    public void setStatus(StockTransferStatus status) {
        this.status = status;
    }

    public Long getReasonID() {
        return reasonID;
    }

    public void setReasonID(Long reasonID) {
        this.reasonID = reasonID;
    }

    public Long getNote() {
        return note;
    }

    public void setNote(Long note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockTransfer that = (StockTransfer) o;
        return Objects.equals(stockTransferID, that.stockTransferID) &&
                Objects.equals(transNo, that.transNo) &&
                Objects.equals(fromLocation, that.fromLocation) &&
                Objects.equals(toLocation, that.toLocation) &&
                Objects.equals(staffSent, that.staffSent) &&
                Objects.equals(staffReceived, that.staffReceived) &&
                Objects.equals(dateSent, that.dateSent) &&
                Objects.equals(dateReceived, that.dateReceived) &&
                status == that.status &&
                Objects.equals(reasonID, that.reasonID) &&
                Objects.equals(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockTransferID, transNo, fromLocation, toLocation, staffSent, staffReceived, dateSent, dateReceived, status, reasonID, note);
    }

    @Override
    public String toString() {
        return "StockTransfer{" +
                "stockTransferID=" + stockTransferID +
                ", transNo=" + transNo +
                ", fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                ", staffSent=" + staffSent +
                ", staffReceived=" + staffReceived +
                ", dateSent=" + dateSent +
                ", dateReceived=" + dateReceived +
                ", status=" + status +
                ", reasonID=" + reasonID +
                ", note=" + note +
                '}';
    }
}
