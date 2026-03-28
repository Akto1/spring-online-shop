package com.example.demo.dto;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponseDTO {
    private String name;
    private Long id;


    public CategoryResponseDTO(Category category){
        this.name = category.getName();
        this.id = category.getId();

    }


}
