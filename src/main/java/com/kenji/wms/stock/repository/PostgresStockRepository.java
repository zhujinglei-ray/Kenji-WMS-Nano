package com.kenji.wms.stock.repository;

import com.kenji.wms.model.domainobject.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

public class PostgresStockRepository implements StockRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresStockRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void updateBatchProducts(Collection<Product> products) {
        String sql = "INSERT INTO products(uuid, product_id, product_json) VALUES(?, ?, ?) " +
                "ON CONFLICT set product_id=?, product_json=?;";
        jdbcTemplate.batchUpdate()
    }
}
