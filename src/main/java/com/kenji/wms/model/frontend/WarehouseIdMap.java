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
    public static WarehouseIdMap fromLocationId(long locationId) {
        switch ((int) locationId) {
            case 14969:
                return WARRINTON;
            case 3371:
                return WAREHOUSE;
            case 13908:
                return PRESTON;
            case 13951:
                return BURY;
            case 17595:
                return ARNDALE;
            default:
                throw new RuntimeException("Boy you should not be here");
        }
    }
    public Integer getLocationId() {
        return locationId;
    }
}
