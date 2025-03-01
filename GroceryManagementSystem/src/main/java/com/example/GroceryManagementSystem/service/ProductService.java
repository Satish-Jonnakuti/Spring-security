package com.example.GroceryManagementSystem.service;

import com.example.GroceryManagementSystem.model.Product;
import com.example.GroceryManagementSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository; // Injecting ProductRepository

    // Get all products, returning an empty list if none are found
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.isEmpty() ? Collections.emptyList() : products; // Return an empty list if products are not found
    }

    // Get product by ID, returning null if not found
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null); // Return null if not found
    }

    // Add a new product
    public Product addProduct(Product product) {
        return productRepository.save(product); // Assuming product is always valid
    }
    public List<Product> findByType(String type){
        return productRepository.findByType(type);
    }

    // Update product by ID
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id); // Set the ID to update the existing record
            return productRepository.save(product); // Save and return the updated product
        }
        return null; // Return null if not found
    }

    // Delete product by ID
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true; // Return true if deleted
        }
        return false; // Return false if not found
    }
}
