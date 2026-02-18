package com.gevernova.order.service;

import com.gevernova.order.entity.Order;
import com.gevernova.order.external.ProductClient;
import com.gevernova.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

/**
 * Business logic for placing orders
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;

    public OrderServiceImpl(ProductClient productClient,
                            OrderRepository orderRepository) {
        this.productClient = productClient;
        this.orderRepository = orderRepository;
    }

    /**
     * Places order:
     * 1. Calls Product Service via Feign to reduce stock
     * 2. Saves order in database
     */
    @Override
    public Order placeOrder(Long productId, int quantity, double totalAmount) {

        // Call Product Service
        productClient.reduceQuantity(productId, quantity);

        // Create Order
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalAmount(totalAmount);

        // Save Order
        return orderRepository.save(order);
    }
}
