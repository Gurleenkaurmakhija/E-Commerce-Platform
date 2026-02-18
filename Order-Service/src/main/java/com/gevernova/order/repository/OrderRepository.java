package com.gevernova.order.repository;

import com.gevernova.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Order CRUD operations
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
