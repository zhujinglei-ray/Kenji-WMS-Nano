package com.kenji.wms.model.frontend;

public enum WarehouseIdMap {
    WARRINTON (14969),
    WAREHOUSE (3371),
    PRESTON (13908),
    BURY (13951),
    ARNDALE (17595);

    private final int locationId;

    private WarehouseIdMap(int locationId) {
        this.locationId = locationId;
    }
    public int getLocationId() {
        return locationId;
    }
}
