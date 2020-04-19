package com.kenji.wms.stock.exceptions;

public class FailQueryStockException extends RuntimeException {

    public FailQueryStockException() {
    }

    public FailQueryStockException(String message) {
        super(message);
    }

    public FailQueryStockException(String message, Throwable cause) {
        super(message, cause);
    }
}
