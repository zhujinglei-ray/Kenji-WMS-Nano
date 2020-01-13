package com.kenji.wms.stock.exceptions;

public class FailQueryProductException extends Exception {

    public FailQueryProductException() {
    }

    public FailQueryProductException(String message) {
        super(message);
    }

    public FailQueryProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
