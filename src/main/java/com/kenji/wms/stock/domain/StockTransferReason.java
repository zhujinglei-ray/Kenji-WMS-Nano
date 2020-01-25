package com.kenji.wms.stock.domain;

public enum StockTransferReason {
    Internal_Movement(25466),
    New_Stock(25468),
    Wastage(25470),
    Stock_take(25473),
    Shopify(130402);
    private final int reasonId;
    private StockTransferReason(int reasonId) {
        this.reasonId = reasonId;
    }
    public int getReasonId(){return this.reasonId;}
}
