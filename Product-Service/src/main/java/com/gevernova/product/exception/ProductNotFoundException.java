package com.gevernova.product.exception;

// Exception thrown when a product with a given ID is not found
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
