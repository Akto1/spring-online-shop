package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @GetMapping
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        category.setName(category.getName());
        return categoryRepository.save(category);
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id){
        return categoryRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Category with id" + id + " not found!"));
    }




}
