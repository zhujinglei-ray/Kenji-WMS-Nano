package com.kenji.wms.stock.domain;

public class StockMoveSummaryRecord {
    String productName;
    String fromLocation;
    String toLocation;
    Long qty;

    public StockMoveSummaryRecord(String productName, String fromLocation, String toLocation, Long qty) {
        this.productName = productName;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.qty = qty;
    }
}
