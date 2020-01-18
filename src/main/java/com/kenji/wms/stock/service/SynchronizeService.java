package com.kenji.wms.stock.service;

import com.kenji.wms.stock.exceptions.FailQueryProductException;
import com.kenji.wms.stock.exceptions.FailQueryStockException;

import java.math.BigInteger;

public interface SynchronizeService {
    BigInteger syncAllProductWithEposnow() throws FailQueryProductException;
    BigInteger syncAllProductStockWithEposnow() throws FailQueryStockException;
    long syncProductsByPage(Integer pageNumber) throws FailQueryProductException;
    long syncStocksByPage(Integer pageNumber) throws FailQueryStockException;
}
