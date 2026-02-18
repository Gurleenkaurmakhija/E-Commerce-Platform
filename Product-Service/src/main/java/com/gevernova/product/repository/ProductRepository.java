package com.gevernova.product.repository;

import com.gevernova.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for Product CRUD operations
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
