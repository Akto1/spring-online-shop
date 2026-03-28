package com.example.demo.dto;

import com.example.demo.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDTO {
    private String name;
    private Long id;
    private Long category_Id;
    private BigDecimal price;


    public ProductResponseDTO(Product product) {
        this.name = product.getName();
        this.id = product.getId();
        this.price = product.getPrice();
        this.category_Id = product.getCategory().getId();
    }
}
