package com.kenji.wms.stock.exceptions;

public class FailQueryStockException extends Exception {

    public FailQueryStockException() {
    }

    public FailQueryStockException(String message) {
        super(message);
    }

    public FailQueryStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
