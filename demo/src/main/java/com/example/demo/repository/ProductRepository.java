package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByPriceLessThan(double price);
    List<Product> findByNameContaining(String name);
    Page<Product> findAll(Pageable pageable);
}
