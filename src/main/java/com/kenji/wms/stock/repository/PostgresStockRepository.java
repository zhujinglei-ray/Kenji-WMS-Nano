package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.domainobject.ProductStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostgresStockRepository implements StockRepository {

    private JdbcTemplate jdbcTemplate;
    private Gson gson;

    @Autowired
    public PostgresStockRepository(JdbcTemplate jdbcTemplate, Gson gson) {
        this.jdbcTemplate = jdbcTemplate;
        this.gson = gson;
    }

    @Override
    public void updateBatchProductStocks(List<ProductStock> stocks) {
        String sql = "INSERT INTO productStock(stock_id, product_id, stock_json) VALUES(?, ?, ?::json) " +
                "ON CONFLICT(stock_id) DO update set product_id=?, stock_json=?::json;";
        jdbcTemplate.batchUpdate(sql, new batchProductStockUpdateSetter(stocks));
    }

    @Override
    public List<String> getStockIdsByProductId(Long productID) {
        String sql = "select stock_id from productstock where product_id=?";
        List<String> stockIds = jdbcTemplate.queryForList(sql, String.class, productID);
        return stockIds;
    }

    private class batchProductStockUpdateSetter implements BatchPreparedStatementSetter {

        private List<ProductStock> stocks;

        public batchProductStockUpdateSetter(List<ProductStock> stocks) {
            this.stocks = stocks;
        }

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
            String stockJson = gson.toJson(stocks.get(i)).toString();
            int j = 1;
            ps.setLong(j++, stocks.get(i).getStockID());
            ps.setLong(j++,  stocks.get(i).getProductID());
            ps.setString(j++, stockJson);
            ps.setLong(j++, stocks.get(i).getProductID());
            ps.setString(j, stockJson);
        }

        @Override
        public int getBatchSize() {
            return stocks.size();
        }
    }
}
