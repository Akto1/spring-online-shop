//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "orders")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//    LocalDateTime createdAt;
//    private double total;
//
//    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Builder.Default
//    private List<OrderItem> items = new ArrayList<>();
//
//    public void addItem(OrderItem item) {
//        item.setOrder(this);
//        this.items.add(item);
//    }
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;
//
//
//}
