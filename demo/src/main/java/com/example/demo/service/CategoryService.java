package com.example.demo.service;

import com.example.demo.dto.CategoryCreateDTO;
import com.example.demo.dto.CategoryResponseDTO;
import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryResponseDTO create(CategoryCreateDTO createDTO) {
        Category category = new Category();
        category.setName(createDTO.getName());
        Category saved = categoryRepository.save(category);
        return new CategoryResponseDTO(
                saved.getName(),
                saved.getId());
    }


    public List<CategoryResponseDTO> getCategories() {
        return categoryRepository.findAll().stream().map(CategoryResponseDTO::new).toList();
    }


    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category with id " + id + " Not found"));
        return new CategoryResponseDTO(category);
    }

    public CategoryResponseDTO deleteCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with id " + id + " Not found"));
        categoryRepository.delete(category);
        return new CategoryResponseDTO(category);
    }
}



