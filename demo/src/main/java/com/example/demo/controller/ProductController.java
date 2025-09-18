package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public Product getAll(@PathVariable  Long id){
     return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id,@RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @GetMapping("/less-than/{price}")
    public List<Product> priceLessThan(@PathVariable double price){
        return productService.lessByPrice(price);
    }

    @GetMapping("/contains/{name}")
    public List<Product> contains(@PathVariable String name){
        return productService.productContains(name);
    }


    @PostMapping
    public Product create(@RequestBody ProductDTO productDTO){
        return productService.createProductFromDTO(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
    productService.deleteProduct(id);
    }

    @GetMapping("/page")
    public Page<Product> getPaginated( Pageable pageable){
        return productService.getProductsPaginated(pageable);
    }
}
