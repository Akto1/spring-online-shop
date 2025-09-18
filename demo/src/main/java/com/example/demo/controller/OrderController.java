package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.OrderService;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    OrderRepository orderRepository;

    public OrderController(OrderService orderService, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

@PostMapping
    public Order createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @GetMapping
    public Page<Order> getOrders(Pageable pageable){
        return orderRepository.findAll(pageable);
    }

    @PutMapping("/put/{id}")
    public Order replaceOrder(@PathVariable Long id,@RequestBody OrderDTO orderDTO){
        return orderService.remakeOrder(id,orderDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteById(id);
    }

    @GetMapping("/all")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }



}
