package com.gevernova.product.exception;

// Exception thrown when requested product quantity exceeds available stock
public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
