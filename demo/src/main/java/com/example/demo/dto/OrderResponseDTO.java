package com.example.demo.dto;

import com.example.demo.models.Order;
import com.example.demo.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {
    private Long orderId;
    private List<ProductDTO> products;
    private BigDecimal totalPrice;
private OrderStatus status;


    public OrderResponseDTO(Order order) {
        this.orderId = order.getId();
        this.products = order.getProductList().stream().map(ProductDTO::new).toList();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
    }

    public OrderResponseDTO(Long id,List<ProductDTO> products, BigDecimal totalPrice, OrderStatus status) {
        this.products = products;
        this.orderId = id;
        this.totalPrice = totalPrice;
        this.status = status;
    }


}
