package com.kenji.wms.stock.repository;

import com.kenji.wms.model.frontend.TransferLocationQty;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.domain.BatchStockMove;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryBatchMoveRepository implements BatchMoveRepository{

    private Map<String, List<BatchStockMove>> cache = new ConcurrentHashMap<>();
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public InMemoryBatchMoveRepository() {
    }

    @Override
    public void saveTransferItem(String username, BatchStockMove batchStockMove) {
        logger.debug("Add one more batch move {} for user {}", batchStockMove, username);
        List<BatchStockMove> currentMoves = this.cache.getOrDefault(username, new LinkedList<>());
        currentMoves.add(batchStockMove);
        cache.put(username, currentMoves);
    }

    @Override
    public void removeAllTransferItems(String username) {
        logger.debug("remove stock move record for username {}", username);
        cache.remove(username);
    }

    @Override
    public void addOneTransferItem(String username, TransferLocationQty transferLocationQty) {
        List<BatchStockMove> currentMoves = this.cache.getOrDefault(username, new LinkedList<>());
        String key = transferLocationQty.getFromLocation().toString() + "-" + transferLocationQty.getToLocation().toString();
        for (BatchStockMove batchStockMove: currentMoves) {
            if (batchStockMove.getTransferKey().equals(key)) {
                batchStockMove.getTransferItems().add(transferLocationQty);
                return;
            }
        }
        WarehouseIdMap fromLocation = WarehouseIdMap.fromLocationId(transferLocationQty.getFromLocation());
        WarehouseIdMap toLocation = WarehouseIdMap.fromLocationId(transferLocationQty.getToLocation());
        List<TransferLocationQty> list = new LinkedList<>();
        list.add(transferLocationQty);
        BatchStockMove batchStockMove = new BatchStockMove(fromLocation, toLocation, list);
        saveTransferItem(username, batchStockMove);
    }

    @Override
    public Map<Pair<Integer, Integer>, List<TransferLocationQty>> getAllMoveByUsername(String username) {
        if (cache.containsKey(username) )  {
            Map<Pair<Integer, Integer>, List<TransferLocationQty>> userMoveMap = new HashMap<>();
            List<BatchStockMove> batchStockMoves = cache.get(username);
            for (BatchStockMove batchStockMove: batchStockMoves) {
                Pair<Integer, Integer> key = Pair.of(batchStockMove.getFromLocationId(), batchStockMove.getToLocationId());
                List<TransferLocationQty> currentMoves = userMoveMap.getOrDefault(key, new LinkedList<>());
                currentMoves.addAll(batchStockMove.getTransferItems());
                userMoveMap.put(key, currentMoves);
            }
            return userMoveMap;
        } else {
            return Collections.emptyMap();
        }
    }


}
