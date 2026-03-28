package com.example.demo.service;

import com.example.demo.Exceptions.OrderValidationException;
import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.dto.*;
import com.example.demo.models.Order;
import com.example.demo.models.OrderStatus;
import com.example.demo.models.Product;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponseDTO createOrder(OrderCreateDTO dto){
        List<Product> products = productRepository.findAllById(dto.getProductIds());
      if(products.isEmpty()){
          throw new ProductNotFoundException("Products not found");
      }

        BigDecimal total = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
      if(total.compareTo(BigDecimal.ZERO) == 0){
          throw new OrderValidationException("Total price of order is ZERO!");
      }
        Order order = new Order();
      order.setTotalPrice(total);
      order.setStatus(OrderStatus.CREATED);
    for(Product p: products){
        p.setOrder(order);
    }
    order.setProductList(products);
      Order savedOrder = orderRepository.save(order);

      List<ProductDTO> productDTOs = products.stream()
              .map(p -> new ProductDTO(
                      p.getId(),
                      p.getName(),
                      p.getPrice())).toList();

          return new OrderResponseDTO(
          savedOrder.getId(),
                  productDTOs,
                  order.getTotalPrice(),
                  order.getStatus()
          );
    }

    public List<OrderResponseDTO> getAllOrders(){
        return orderRepository.findAll().stream().map(OrderResponseDTO::new).toList();
    }

    public OrderResponseDTO getOrderById(Long id){
        Order order = orderRepository.findById(id).orElseThrow(()
                -> new OrderValidationException("Order with id " + id + " not found!"));
        return new OrderResponseDTO(order);
    }


    public OrderResponseDTO deleteOrderById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()
                -> new OrderValidationException("Order with id " + id + " not found"));
        orderRepository.delete(order);
        return new OrderResponseDTO(order);
    }



}
