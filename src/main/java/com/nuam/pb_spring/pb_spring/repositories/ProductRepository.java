package com.nuam.pb_spring.pb_spring.repositories;

import com.nuam.pb_spring.pb_spring.models.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.domain.Sort;

@Repository
public class ProductRepository {

        @Autowired
        private ProductCrudRepository productCrudRepository;
        @Autowired
        private ProductPagingRepository productPagingRepository;

        public Page<Product> getAll(int page, int size) {
                PageRequest pageable = PageRequest.of(page, size, Sort.by("id").ascending());
                return productPagingRepository.findAll(pageable);
        }

        public Optional<Product> getById(Long id) {
                return productCrudRepository.findById(id);
        }

        public Product save(Product product) {
                return productCrudRepository.save(product);
        }

        public void delete(Long id) {
                productCrudRepository.deleteById(id);
        }

        public Product update(Product product) {
                return productCrudRepository.save(product);
        }

}
