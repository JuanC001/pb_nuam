package com.nuam.pb_spring.pb_spring.controllers;

import com.nuam.pb_spring.pb_spring.models.dto.ProductDTO;
import com.nuam.pb_spring.pb_spring.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nuam.pb_spring.pb_spring.models.entity.Product;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Page<Product> products = productService.getAllProducts(page, size);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product1 -> new ResponseEntity<>(product1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Product> postProduct(@Valid @RequestBody ProductDTO entity) {

        try {
            Date today = new Date();
            Product myNewProduct = new Product();
            myNewProduct.setName(entity.getName());
            myNewProduct.setDescription(entity.getDescription());
            myNewProduct.setPrice(entity.getPrice());
            myNewProduct.setCreatedAt(today);

            Product newProduct = productService.createProduct(myNewProduct);

            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        } catch (Error e) {

            System.out.println("Error: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct( @PathVariable Long id, @Valid @RequestBody ProductDTO entity) {

        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setName(entity.getName());
            updatedProduct.setDescription(entity.getDescription());
            updatedProduct.setPrice(entity.getPrice());
            productService.updateProduct(updatedProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
