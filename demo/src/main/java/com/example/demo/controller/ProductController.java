package com.example.demo.controller;


import com.example.demo.dto.ProductCreateRequest;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

private final ProductRepository productRepository;
private final CategoryRepository categoryRepository;

@PutMapping
public Product create(@RequestBody ProductCreateRequest dto){

    Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(()
            -> new RuntimeException("Category not found!"));

    Product product = new Product();
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());
    product.setCategory(category);
    return productRepository.save(product);

}

@GetMapping
    public List<Product> getAll(){
    return productRepository.findAll();
}

@GetMapping("/category/{categoryId}")
    public List<Product> getByCategory(@PathVariable Long id){
    return productRepository.findByCategory_Id(id);
}

@GetMapping("/page")
public Page<Product> getProducts(
        @RequestParam(defaultValue = "0")int page,
        @RequestParam(defaultValue = "5")int size
){
    return productRepository.findAll(PageRequest.of(page,size));
}
    @GetMapping("/{id}")
    public Optional<Product> product(@PathVariable Long id){
        return productRepository.findById(id);
    }


    }
