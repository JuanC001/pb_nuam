package com.nuam.pb_spring.pb_spring.repositories;

import com.nuam.pb_spring.pb_spring.models.entity.Product;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface ProductPagingRepository extends ListPagingAndSortingRepository<Product, Integer> {}
