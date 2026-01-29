package com.example.demo.dto;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String name;
    private double price;
    private Long categoryId;

}
