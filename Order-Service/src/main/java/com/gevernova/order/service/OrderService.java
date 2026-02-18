package com.gevernova.order.service;

import com.gevernova.order.entity.Order;

/**
 * Service interface for order operations
 */
public interface OrderService {

    Order placeOrder(Long productId, int quantity, double totalAmount);
}
