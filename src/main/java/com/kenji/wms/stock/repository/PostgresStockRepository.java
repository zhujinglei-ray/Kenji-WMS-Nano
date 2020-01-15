package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.domainobject.Product;
import com.kenji.wms.model.domainobject.ProductStock;
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
        String sql = "INSERT INTO products(product_id, barcode, product_json) VALUES(?, ?, ?, ?::json) " +
                "ON CONFLICT(product_id, barcode) DO update set product_id=?, barcode=?, product_json=?::json;";
        jdbcTemplate.batchUpdate(sql, new batchProductUpdateSetter(products));
    }

    @Override
    public void updateBatchProductStocks(List<ProductStock> stocks) {
        String sql = "INSERT INTO products(stock_id, product_id, stock_json) VALUES(?, ?, ?, ?::json) " +
                "ON CONFLICT(stock_id) DO update set product_id=?, product_json=?::json;";
        jdbcTemplate.batchUpdate(sql, new batchProductStockUpdateSetter(stocks));
    }

    @Override
    public long getProductIdByBarcode(String barcode) {
        String sql = "select product_id from products where barcode=?";
        String[] args = new String[1];
        args[0] = barcode;
        Long productId = jdbcTemplate.queryForObject(sql, args, Long.class);
        return productId;
    }

    @Override
    public List<ProductStock> getStocksByProductId(Long productID) {
        String sql = "select stock_json from productstock where product=?";
        List<ProductStock> productStocks = jdbcTemplate.queryForList(sql, ProductStock.class, productID);
        return productStocks;
    }

    private class batchProductUpdateSetter implements BatchPreparedStatementSetter {

        private List<Product> products;

        public batchProductUpdateSetter(List<Product> products) {
            this.products = products;
        }

        @Override
        public void setValues(PreparedStatement ps, int i) throws SQLException {
            String productJson = gson.toJson(products.get(i)).toString();
            int j = 1;
            ps.setLong(j++, products.get(i).getProductID());
            ps.setLong(j++,  getProductBarcodeAsLong(products.get(i)));
            ps.setString(j++, productJson);
            ps.setLong(j++, products.get(i).getProductID());
            ps.setLong(j++, getProductBarcodeAsLong(products.get(i)));
            ps.setString(j, productJson);
        }

        @Override
        public int getBatchSize() {
            return products.size();
        }

        private Long getProductBarcodeAsLong(Product product) {
            String productBarcode = product.getBarcode();
            if (productBarcode == null) {
                return -1L;
            } else {
                return Long.parseLong(productBarcode);
            }
        }
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