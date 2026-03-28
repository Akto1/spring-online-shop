package com.example.demo.controllers;
import com.example.demo.dto.OrderCreateDTO;
import com.example.demo.dto.OrderResponseDTO;
import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/order")

@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    public OrderResponseDTO createOrder(@RequestBody  OrderCreateDTO dto){
        return orderService.createOrder(dto);
    }

    @GetMapping("/get")
    public List<OrderResponseDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/get/{id}")
    public OrderResponseDTO getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public OrderResponseDTO deleteOrderById(@PathVariable Long id){
        return orderService.deleteOrderById(id);
    }
}



