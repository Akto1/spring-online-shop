//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Table(name = "order_items")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//
//
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    private Integer quantity;
//
//    private Double price;
//
//
//}
