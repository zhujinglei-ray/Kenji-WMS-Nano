package com.kenji.wms.stock.domain;

import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class BatchStockMove {
    private final WarehouseIdMap fromLocation;
    private final WarehouseIdMap toLocation;
    private final List<TransferLocationQty> transferItems;

    public BatchStockMove(WarehouseIdMap fromLocation, WarehouseIdMap toLocation, List<TransferLocationQty> transferItems) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.transferItems = transferItems;
    }

    public String getTransferKey(){
        return fromLocation.getLocationId().toString() + "-" +toLocation.getLocationId().toString();
    }

    public List<TransferLocationQty> getTransferItems() {
        return transferItems;
    }

    public Integer getFromLocationId(){
        return fromLocation.getLocationId();
    }

    public Integer getToLocationId() {
        return toLocation.getLocationId();
    }

}
