package com.example.demo.dto;

import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    public ProductDTO(Long id,String name,BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
