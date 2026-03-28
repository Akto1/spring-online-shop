package com.example.demo.dto;

import com.example.demo.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderCreateDTO {
    private List<Long> productIds;
}
