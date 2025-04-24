package com.nuam.pb_spring.pb_spring.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")
    public String getAllProducts() {
        return "hola mundo";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id) {
        return "Producto con ID: " + id;
    }

    @PostMapping("/")
    public String postProduct(@RequestBody String entity) {

        return entity;
    }

    @PutMapping("/{id}")
    public String putProduct(@PathVariable Long id, @RequestBody String entity) {

        return "Producto con ID: " + id + " actualizado con datos: " + entity;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return "Producto con ID: " + id + " eliminado";
    }

}
