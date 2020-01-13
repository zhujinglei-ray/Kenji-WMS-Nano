package com.kenji.wms.stock.service;

import com.kenji.wms.stock.exceptions.FailQueryProductException;

import java.math.BigInteger;

public interface StockSynchronizer {
    BigInteger syncAllProductWithStock() throws FailQueryProductException;
}
