package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.domainobject.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

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
    public void updateBatchProducts(List<Product> products) {
        String sql = "INSERT INTO products(uuid, product_id, barcode, product_json) VALUES(?, ?, ?::json) " +
                "ON CONFLICT set product_id=?, barcode=?, product_json=?;";
        jdbcTemplate.batchUpdate(sql, new batchProductUpdateSetter(products));
    }

    @Override
    public long getProductIdByBarcode(long barcode) {
        String sql = "select product_id from products where barcode=?";
        Long[] args = new Long[1];
        args[0] = barcode;
        Long productId = jdbcTemplate.queryForObject(sql, args, Long.class);
        return productId;
    }

    private class batchProductUpdateSetter implements BatchPreparedStatementSetter {

        private List<Product> products;

        public batchProductUpdateSetter(List<Product> products) {
            this.products = products;
        }

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
            String productJson = gson.toJson(products.get(i)).toString();
            ps.setString(1, UUID.randomUUID().toString());
            ps.setLong(2, products.get(i).getProductID());
            ps.setString(3, productJson);
            ps.setLong(4,  Long.parseLong(products.get(i).getBarcode()));
            ps.setLong(5, products.get(i).getProductID());
            ps.setLong(6, Long.parseLong(products.get(i).getBarcode()));
            ps.setString(7, productJson);
        }

        @Override
        public int getBatchSize() {
            return products.size();
        }
    }
}
