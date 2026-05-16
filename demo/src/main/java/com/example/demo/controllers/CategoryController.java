package com.example.demo.controllers;

import com.example.demo.dto.CategoryCreateDTO;
import com.example.demo.dto.CategoryResponseDTO;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping("/create")
    public CategoryResponseDTO create(@RequestBody CategoryCreateDTO category){
        return categoryService.create(category);
    }

    @GetMapping("/get")
    public List<CategoryResponseDTO> getAllCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/get/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);

    }

}
