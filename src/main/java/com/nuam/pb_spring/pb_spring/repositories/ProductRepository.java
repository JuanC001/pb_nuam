package com.nuam.pb_spring.pb_spring.repositories;

import com.nuam.pb_spring.pb_spring.models.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

        @Autowired
        private ProductCrudRepository productCrudRepository;

        public List<Product> getAll() {
                return (List<Product>) productCrudRepository.findAll();
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
