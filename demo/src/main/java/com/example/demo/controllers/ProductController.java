package com.example.demo.controllers;

import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.models.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor

public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    @PostMapping("/create")
    private ProductResponseDTO productCreate(@RequestBody ProductCreateDTO product){
        return productService.createProduct(product);
    }

    @GetMapping("/get")
    private List<ProductResponseDTO> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    private ProductResponseDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/price")
    public List<ProductResponseDTO> getByPrice(@RequestParam BigDecimal min, @RequestParam  BigDecimal max){
        return productRepository.findByPriceBetween(min,max).stream()
                .map(ProductResponseDTO::new).toList();
    }

    @GetMapping("/page")
    public List<ProductResponseDTO> page(@RequestParam int page,@RequestParam int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.getContent().stream()
                .map(ProductResponseDTO::new).toList();
    }


}
