package com.gevernova.order.exception;

// Thrown when an order with the given ID is not found
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
