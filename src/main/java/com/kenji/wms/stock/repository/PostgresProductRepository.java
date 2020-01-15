package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.domainobject.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Component
public class PostgresProductRepository implements ProductRepository {

    private JdbcTemplate jdbcTemplate;
    private Gson gson;

    @Autowired
    public PostgresProductRepository(JdbcTemplate jdbcTemplate, Gson gson) {
        this.jdbcTemplate = jdbcTemplate;
        this.gson = gson;
    }

    @Override
    public void updateBatchProducts(List<Product> products) {
        products = refineProductList(products);
        String sql = "INSERT INTO products(product_id, barcode, product_json) VALUES(?, ?, ?::json) " +
                "ON CONFLICT(product_id, barcode) DO update set product_id=?, barcode=?, product_json=?::json;";
        jdbcTemplate.batchUpdate(sql, new batchProductUpdateSetter(products));
    }

    @Override
    public long getProductIdByBarcode(String barcode) {
        String sql = "select product_id from products where barcode=?";
        Long[] args = new Long[1];
        args[0] = Long.parseLong(barcode);
        Long productId = jdbcTemplate.queryForObject(sql, args, Long.class);
        return productId;
    }

    private List<Product> refineProductList(List<Product> products) {
        List<Product> newList = new LinkedList<>();
        products.forEach(product -> {
            if (product.getBarcode().contains(",")) {
                String[] barcodes = product.getBarcode().split(",");
                for (String barcode : barcodes) {
                    Product newProdcut = gson.fromJson(gson.toJson(product), Product.class);
                    newProdcut.setBarcode(barcode);
                    newList.add(newProdcut);
                }
            } else {
                newList.add(product);
            }
        });
        return newList;
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
            ps.setLong(j++, getProductBarcodeAsLong(products.get(i)));
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
}
