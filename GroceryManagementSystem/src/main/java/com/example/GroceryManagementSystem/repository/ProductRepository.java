package com.example.GroceryManagementSystem.repository;

import com.example.GroceryManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long > {

    List<Product> findByType(String type);
}
