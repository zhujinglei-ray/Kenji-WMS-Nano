package com.kenji.wms.stock.domain;

public enum StockTransferReason {
    Internal_Movement(25466),
    New_Stock(25468),
    Wastage(25470),
    Stock_take(25473),
    Shopify(130402);
    private final long reasonId;
    private StockTransferReason(long reasonId) {
        this.reasonId = reasonId;
    }
    public long getReasonId(){return this.reasonId;}
}
