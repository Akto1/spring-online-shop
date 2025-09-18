package com.example.demo.service;


import com.example.demo.dto.ProductDTO;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> lessByPrice(double price){
        return productRepository.findByPriceLessThan(price);
    }

    public List<Product> productContains(String name){
        return productRepository.findByNameContaining(name);
    }

    public Product updateProduct( Long id, Product updatedProduct){
    Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    product.setName(updatedProduct.getName());
    product.setPrice(updatedProduct.getPrice());
    return productRepository.save(product);

    }

    public Product getProductById(Long id){
      return   productRepository.findById(id).orElse(null);
    }

    public void  deleteProduct( Long id){
        productRepository.deleteById(id);
    }

    public Page<Product> getProductsPaginated(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product createProductFromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productRepository.save(product);
        
    }
}
