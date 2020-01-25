package com.kenji.wms.model.frontend;

public enum WarehouseIdMap {
    WARRINTON (14969),
    WAREHOUSE (3371),
    PRESTON (13908),
    BURY (13951),
    ARNDALE (17595);

    private final long locationId;

    private WarehouseIdMap(long locationId) {
        this.locationId = locationId;
    }
    public long getLocationId() {
        return locationId;
    }
}
