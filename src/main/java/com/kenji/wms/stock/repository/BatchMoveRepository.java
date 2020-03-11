package com.kenji.wms.stock.repository;

import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.domain.BatchStockMove;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;

public interface BatchMoveRepository {
     void saveTransferItem (String username, BatchStockMove batchStockMove);
     void removeAllTransferItems(String username);
     void addOneTransferItem(String username, TransferLocationQty transferLocationQty);
     Map<Pair<Integer, Integer>, List<TransferLocationQty>> getAllMoveByUsername(String username);
}
