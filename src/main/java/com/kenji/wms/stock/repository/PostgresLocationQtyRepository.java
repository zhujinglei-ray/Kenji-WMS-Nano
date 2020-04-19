package com.kenji.wms.stock.repository;

import com.google.gson.Gson;
import com.kenji.wms.model.frontend.ProductStockAtLocations;
import com.kenji.wms.model.frontend.WarehouseIdMap;
import com.kenji.wms.stock.service.ProductStockLocationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
public class PostgresLocationQtyRepository implements LocationQtyRepository {
    private JdbcTemplate jdbcTemplate;
    private ProductStockLocationQueryService productStockLocationQueryService;

    @Autowired
    public PostgresLocationQtyRepository(JdbcTemplate jdbcTemplate, ProductStockLocationQueryService productStockLocationQueryService) {
        this.jdbcTemplate = jdbcTemplate;
        this.productStockLocationQueryService = productStockLocationQueryService;
    }

    @Override
    public void updateAllQtyInLocation() {
        Set<String> retrieveAllProductIds = productStockLocationQueryService.getAllProductIdsAvailableInStockTable();
        retrieveAllProductIds.iterator().forEachRemaining(
                this::updateOneProductById
        );
    }

    public int updateOneInLocation() {
        Set<String> retrieveAllProductIds = productStockLocationQueryService.getAllProductIdsAvailableInStockTable();
        return updateOneProductById(retrieveAllProductIds.iterator().next());
    }

    private int updateOneProductById(String productId) {
        ProductStockAtLocations productStockAtLocations = productStockLocationQueryService.getProductAtAllLocation(productId);
        if (productStockAtLocations.getBarcode() == null) {
            return 0;
        }
        if (getProductBarcodeAsLong(productStockAtLocations.getBarcode()) == -1L) {
            return 0;
        }

        String sql = "INSERT INTO product_location_stocks(" +
                "barcode, product_name, total_qty,qty_warehouse,qty_bury,qty_preston,qty_warrinton,qty_arndale) " +
                "VALUES(?,?,?,?,?,?,?,?);";
//                "ON CONFLICT(barcode) DO UPDATE SET" +
//                " barcode=?, product_name=?, total_qty=?, qty_warehouse=?, qty_bury=?, qty_preston=?, qty_warrinton=?, qty_arndale=?;";
        try {
            return jdbcTemplate.update(sql,Long.parseLong(productStockAtLocations.getBarcode()),
                    productStockAtLocations.getName(),
                    productStockAtLocations.getTotalQty(),
                    productStockAtLocations.getQtyInWarehouse(),
                    productStockAtLocations.getQtyInBury(),
                    productStockAtLocations.getQtyInWarrinton(),
                    productStockAtLocations.getQtyInPreston(),
                    productStockAtLocations.getQtyInArndale());
        } catch (DuplicateKeyException de) {
            return 0;
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<String> getLowQtyInLocation(WarehouseIdMap warehouseIdMap) {
        return null;
    }

    private class productStockLocationParamSetter implements PreparedStatementSetter {

        private ProductStockAtLocations productStockAtLocations;

        private productStockLocationParamSetter(ProductStockAtLocations productStockAtLocations) {
            this.productStockAtLocations = productStockAtLocations;
        }

        @Override
        public void setValues(PreparedStatement ps) throws SQLException {
            ps.setLong(1, Long.parseLong(productStockAtLocations.getBarcode()));
            ps.setString(2, productStockAtLocations.getName());
            ps.setInt(3, productStockAtLocations.getTotalQty());
            ps.setInt(4, productStockAtLocations.getQtyInWarehouse());
            ps.setInt(5, productStockAtLocations.getQtyInBury());
            ps.setInt(6, productStockAtLocations.getQtyInWarrinton());
            ps.setInt(7, productStockAtLocations.getQtyInPreston());
            ps.setInt(8, productStockAtLocations.getQtyInArndale());
            ps.close();
        }
    }

    private Long getProductBarcodeAsLong(String barcode) {
        String productBarcode = barcode.replaceAll("\\s+", "");
        try {
            return Long.parseLong(productBarcode);
        } catch (Exception e) {
            return -1L;
        }
    }
}
