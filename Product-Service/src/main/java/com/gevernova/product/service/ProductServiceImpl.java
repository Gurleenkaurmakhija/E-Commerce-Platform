package com.gevernova.product.service;

import com.gevernova.product.entity.Product;
import com.gevernova.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Business logic for Product Service
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    // Create product
    @Override
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // Get product by ID
    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    // Update product by ID
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);

        existing.setName(updatedProduct.getName());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantity(updatedProduct.getQuantity());

        return repository.save(existing);
    }

    // Delete product by ID
    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        repository.delete(product);
    }

    // Reduce stock quantity
    @Override
    public void reduceQuantity(Long id, int quantity) {

        Product product = getProductById(id);

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient Stock");
        }

        product.setQuantity(product.getQuantity() - quantity);
        repository.save(product);
    }
}
