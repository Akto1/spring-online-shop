//package com.example.demo.controller;
//
//import com.example.demo.dto.OrderDTO;
//import com.example.demo.service.OrderService;
//import com.example.demo.model.Order;
//import lombok.AllArgsConstructor;
//
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/orders")
//@AllArgsConstructor
//public class OrderController {
//    private final OrderService orderService;
//
//
//
//@PostMapping
//    public Order createOrder(@RequestBody OrderDTO orderDTO){
//        return orderService.createOrder(orderDTO);
//}
//
//@GetMapping("/user/{id}")
//    public List<Order> getUserOrder(@PathVariable Long id){
//        return orderService.getAllUserOrders(id);
//}
//
//@PutMapping("/{id}")
//public Order remakeUserOrder(@PathVariable Long id,@RequestBody OrderDTO dto){
//        return orderService.remakeOrder(id,dto);
//}
//
//
//@DeleteMapping("/{id}")
//    public void deleteOrder(@PathVariable Long id){
//        orderService.deleteOrderById(id);
//}
//
//
//}
