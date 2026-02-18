package com.gevernova.product.controller;

import com.gevernova.product.entity.Product;
import com.gevernova.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST APIs for Product
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    // Add new product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // Get all products
    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    // Update product by ID
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // Delete product by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    // Reduce stock (used by Order Service)
    @PutMapping("/reduce/{id}")
    public void reduce(@PathVariable Long id,
                       @RequestParam int quantity) {
        service.reduceQuantity(id, quantity);
    }
}
