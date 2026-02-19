package com.gevernova.product.service;

import com.gevernova.product.entity.Product;
import com.gevernova.product.exception.ProductNotFoundException;
import com.gevernova.product.exception.InsufficientStockException;
import com.gevernova.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Product service implementation
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    // Add a new product
    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    // Retrieve all products
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Retrieve a product by its ID
    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    // Update product details by ID
    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        return repository.save(existing);
    }

    // Delete a product by ID
    @Override
    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        repository.delete(existing);
    }

    // Reduce quantity of a product (e.g., after purchase)
    @Override
    public void reduceQuantity(Long id, int quantity) {
        Product product = getProductById(id);
        if (product.getQuantity() < quantity)
            throw new InsufficientStockException("Insufficient stock available");
        product.setQuantity(product.getQuantity() - quantity);
        repository.save(product);
    }
}
