//package com.example.demo.service;
//
//
//import com.example.demo.dto.OrderDTO;
//import com.example.demo.dto.OrderItemDTO;
//import com.example.demo.model.*;
//import com.example.demo.repository.OrderRepository;
//import com.example.demo.repository.ProductRepository;
//import com.example.demo.repository.UserRepository;
//import jakarta.transaction.Transactional;
//
//
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//
//@AllArgsConstructor
//@Service
//public class OrderService {
//    private final OrderRepository orderRepository;
//    private final ProductRepository productRepository;
//    private final UserRepository userRepository;
//
//
//    @Transactional
//    public Order createOrder(OrderDTO dto){
//        User user = userRepository.findById(dto.getUserId())
//                .orElseThrow(() -> new RuntimeException("Product with " + dto.getUserId() + " id not found"));
//        Order order = new Order();
//        order.setUser(user);
//        order.setCreatedAt(LocalDateTime.now());
//        double total = 0.0;
//
//        for(OrderItemDTO itemDTO: dto.getItems()){
//            Product product = productRepository.findById(itemDTO.getProductId())
//                    .orElseThrow(()-> new RuntimeException("Product with id " + itemDTO.getProductId() + " not found"));
//        int qty = itemDTO.getQuantity() == null? 1: itemDTO.getQuantity();
//        double price = product.getPrice();
//  OrderItem orderItem = OrderItem.builder()
//          .product(product)
//          .quantity(qty)
//          .price(price)
//          .build();
//  order.addItem(orderItem);
//  total +=price*qty;
//        }
//        order.setTotal(total);
//        return orderRepository.save(order);
//    }
//
//    @Transactional
//    public Order remakeOrder(Long id,OrderDTO dto){
//        Order order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found!"));
//        order.getItems().clear();
//        double total = 0.0;
//
//        for(OrderItemDTO itemDTO : dto.getItems()){
//           Product product = productRepository.findById(itemDTO.getProductId()).orElseThrow(()-> new RuntimeException("Product not found"));
//           int qty = itemDTO.getQuantity() == null? 1 : itemDTO.getQuantity();
//           OrderItem item = OrderItem.builder()
//                   .product(product)
//                   .quantity(qty)
//                   .price(product.getPrice())
//                   .build();
//           order.addItem(item);
//           total+=product.getPrice() * qty;
//        }
//        order.setTotal(total);
//        return order;
//    }
//
//    @Transactional
//    public Order changeStatus(Long id, OrderStatus status){
//        Order order = orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order not found!"));
//        order.setStatus(status);
//        return orderRepository.save(order);
//    }
//    public Order getOrderById(Long id){
//      return orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Order with id "+ id + " ot found!"));
//    }
//
//    public List<Order> getAllUserOrders(Long userId){
//        return orderRepository.findByUser_Id(userId);
//    }
//    public void deleteOrderById(Long orderId){
//        if(!orderRepository.existsById(orderId)){
//            throw new RuntimeException("Order not found");
//        }
//        orderRepository.deleteById(orderId);
//    }
//
//}
