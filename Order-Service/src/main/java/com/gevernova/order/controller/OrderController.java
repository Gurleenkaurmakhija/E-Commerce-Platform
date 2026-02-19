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

    // Create a new order for the given product and quantity
    @PostMapping
    public Order place(@RequestParam Long productId,
                       @RequestParam int quantity) {
        return service.place(productId, quantity);
    }

    // Retrieve order details by order ID
    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getById(id);
    }
}
