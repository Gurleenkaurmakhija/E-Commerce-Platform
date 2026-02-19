package com.gevernova.order.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.gevernova.orderservice.dto.ProductResponse;
import org.gevernova.orderservice.entity.Order;
import org.gevernova.orderservice.exception.OrderNotFoundException;
import org.gevernova.orderservice.external.service.ProductClient;
import org.gevernova.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;   // Repository to manage orders
    private final ProductClient productClient;  // Feign client to communicate with Product Service

    // Explicit constructor for dependency injection (replaces @RequiredArgsConstructor)
    public OrderServiceImpl(OrderRepository repository, ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    /**
     * Place an order by fetching product details and reducing stock
     * Uses CircuitBreaker to handle Product Service failures
     */
    @Override
    @CircuitBreaker(name = "productService", fallbackMethod = "fallback")
    public Order place(Long productId, int quantity) {

        // Fetch product details from Product Service
        ProductResponse product = productClient.getProduct(productId);

        // Reduce stock in Product Service
        productClient.reduce(productId, quantity);

        // Calculate total order amount
        double total = product.getPrice() * quantity;

        // Create and save order
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalAmount(total);

        return repository.save(order);
    }

    // Fallback method executed when ProductService is unavailable
    public Order fallback(Long productId, int quantity, Exception ex) {
        return new Order(null, productId, quantity, 0);
    }

    /**
     * Retrieve an order by its ID
     * Throws OrderNotFoundException if not found
     */
    @Override
    public Order getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }
}
