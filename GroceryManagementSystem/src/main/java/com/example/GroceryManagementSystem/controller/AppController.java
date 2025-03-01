package com.example.GroceryManagementSystem.controller;

import com.example.GroceryManagementSystem.model.Product; // Ensure the path is correct
import com.example.GroceryManagementSystem.service.ProductService; // Ensure the path is correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/")
public class AppController {

    @Autowired
    private ProductService productService; // Inject the ProductService

    // Endpoint to add a new product
    @PostMapping("addProduct")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product); // Call the service to save the product
        if (savedProduct != null) {
            return new ResponseEntity<>("Product added successfully with ID: " + savedProduct.getId(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to add product.", HttpStatus.BAD_REQUEST); // Return bad request if save fails
        }
    }


    // Endpoint to retrieve all products
    @GetMapping("getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
    @GetMapping("productsByType{type}")
    public ResponseEntity<List<Product>> findByType(@PathVariable String type){
        List<Product> products =productService.findByType(type);
        System.out.println(products);
        System.out.println(products);
     if(products!=null){
         return ResponseEntity.ok(products);
     }else{
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
    }

    // Endpoint to retrieve a product by ID
    @GetMapping("/getProductById{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
      Product product = productService.getProductById(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if not found
        }
    }

    // Endpoint to update a product
    @PutMapping("/updateProductById{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok("Product updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found."); // Return 404 if not found
        }
    }

    // Endpoint to delete a product
    @DeleteMapping("/deleteById{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.ok("Product deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found."); // Return 404 if not found
        }
    }
}
