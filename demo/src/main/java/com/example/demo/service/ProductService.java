package com.example.demo.service;

import com.example.demo.Exceptions.ProductNotFoundException;
import com.example.demo.dto.ProductCreateDTO;
import com.example.demo.dto.ProductResponseDTO;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductResponseDTO createProduct(ProductCreateDTO createDTO) {
        Product product = new Product();
        product.setName(createDTO.getName());
        product.setPrice(createDTO.getPrice());
        Category category = categoryRepository.findById(createDTO.getCategory_Id()).
                orElseThrow(() -> new RuntimeException("Not found category"));
        product.setCategory(category);
        Product saved = productRepository.save(product);
        return new ProductResponseDTO(
                saved.getName(),
                saved.getId(),
                saved.getCategory().getId(),
                saved.getPrice());
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
    }

    public ProductResponseDTO getProductById(Long id) {
       Product product = productRepository.findById(id).orElseThrow(
               () -> new ProductNotFoundException("Product with id " + id + " not found"));
       return new ProductResponseDTO(product);
    }

    public ProductResponseDTO deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(()
        -> new ProductNotFoundException("Product with id " + id + " not found"));
       productRepository.delete(product);
       return new ProductResponseDTO(product);
    }

    }
