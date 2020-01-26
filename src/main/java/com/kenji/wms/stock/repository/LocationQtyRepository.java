package com.kenji.wms.stock.repository;

import com.kenji.wms.model.frontend.WarehouseIdMap;

import java.util.List;

public interface LocationQtyRepository {
    void updateAllQtyInLocation();
    List<String> getLowQtyInLocation(WarehouseIdMap warehouseIdMap);
    int updateOneInLocation();
}
