package com.example.demo.models;

import com.example.demo.dto.ProductDTO;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "orders")
@Entity
@Setter
@Getter
public class Order {
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Product> productList;

    private BigDecimal totalPrice;
}
