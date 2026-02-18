package com.gevernova.order.controller;

import com.gevernova.order.entity.Order;
import com.gevernova.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Order APIs
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * Endpoint to place an order
     */
    @PostMapping
    public Order placeOrder(@RequestParam Long productId,
                            @RequestParam int quantity,
                            @RequestParam double totalAmount) {

        return service.placeOrder(productId, quantity, totalAmount);
    }
}
