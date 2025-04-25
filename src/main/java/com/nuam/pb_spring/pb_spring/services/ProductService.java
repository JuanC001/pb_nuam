package com.nuam.pb_spring.pb_spring.services;

import java.util.Optional;

import com.nuam.pb_spring.pb_spring.models.entity.Product;
import com.nuam.pb_spring.pb_spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.getAll(page, size);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.getById(id);
    }

    public Product createProduct(Product entity) {
        return productRepository.save(entity);
    }

    public Product updateProduct(Product entity) {
        return productRepository.update(entity);
    }

    public Boolean deleteProduct(Long id) {
        if(getProductById(id).isPresent()){
            productRepository.delete(id);
            return true;
        }

        return false;
    }

}
