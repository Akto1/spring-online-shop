package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @GetMapping("/id")
    public Category getById(@PathVariable Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
