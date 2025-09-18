package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order.setCreatedAt(LocalDateTime.now());
        List<Product> products = productRepository.findAllById(orderDTO.getProductsIds());
        order.setProducts(products);
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not created"));

    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order remakeOrder(Long id, OrderDTO dto) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with " + id + " is not created!"));
        order.setCustomerName(dto.getCustomerName());
        List<Product> products = productRepository.findAllById(dto.getProductsIds());
        order.setProducts(products);
       return orderRepository.save(order);
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}
