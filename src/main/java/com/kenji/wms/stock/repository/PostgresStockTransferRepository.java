package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.domainobject.stockmove.StockTransfer;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PostgresStockTransferRepository implements  StockTransferRepository{

    private JdbcTemplate jdbcTemplate;
    private Gson gson;

    @Override
    public void updateBatchStockTransfers(List<StockTransfer> transfers) {
        String sql = "INSERT INTO stockTransfer(stock_transfer_id, stock_transfer_number, stock_transfer_json) VALUES(?, ?, ?::json) " +
                "ON CONFLICT(stock_transfer_id) DO update set stock_transfer_number=?, stock_transfer_json=?::json;";
        jdbcTemplate.batchUpdate(sql, new batchProductStockUpdateSetter(transfers));
    }

    @Override
    public long getTotalTransfersCount() {
        String sql =  "select count(*) from stockTransfer";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        return count;
    }

    private class batchProductStockUpdateSetter implements BatchPreparedStatementSetter {

        private List<StockTransfer> transfers;

        public batchProductStockUpdateSetter(List<StockTransfer> stocks) {
            this.transfers = transfers;
        }

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
            String stockJson = gson.toJson(transfers.get(i));
            int j = 1;
            ps.setLong(j++, transfers.get(i).getStockTransferID());
            ps.setLong(j++,  transfers.get(i).getTransNo());
            ps.setString(j++, stockJson);
            ps.setLong(j++, transfers.get(i).getTransNo());
            ps.setString(j, stockJson);
        }

        @Override
        public int getBatchSize() {
            return transfers.size();
        }
    }
}
