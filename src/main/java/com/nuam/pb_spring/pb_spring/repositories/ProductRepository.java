package com.nuam.pb_spring.pb_spring.repositories;

import com.nuam.pb_spring.pb_spring.models.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

        private ProductCrudRepository productCrudRepository;

        public List<Product> getAll() {
                return (List<Product>) productCrudRepository.findAll();
        }

        public Product getById(Long id) {
                return productCrudRepository.findById(id).orElse(null);
        }

        public Product save(Product product) {
                return productCrudRepository.save(product);
        }

        public void delete(Long id) {
                productCrudRepository.deleteById(id);
        }

}
