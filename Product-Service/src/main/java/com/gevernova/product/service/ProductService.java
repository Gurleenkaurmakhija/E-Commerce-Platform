package com.gevernova.product.service;

import com.gevernova.product.entity.Product;
import java.util.List;

/**
 * Service interface for product operations
 */
public interface ProductService {

    Product addProduct(Product product); // Create

    List<Product> getAllProducts(); // Read all

    Product getProductById(Long id); // Read by ID

    Product updateProduct(Long id, Product product); // Update by ID

    void deleteProduct(Long id); // Delete by ID

    void reduceQuantity(Long id, int quantity); // Reduce stock
}
