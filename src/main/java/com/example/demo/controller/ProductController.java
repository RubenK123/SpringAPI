package com.example.demo.controller;

import com.example.demo.controller.model.ProductId;
import com.example.demo.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ProductId> createProduct(@RequestBody final Product product) {
        System.out.println(product);
        ProductId result = new ProductId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        List<Product> result = new ArrayList<>();
        result.add(new Product("1",
                "Product1",
                new BigDecimal("1250")));
        result.add(new Product("2",
                "Product2",
                new BigDecimal("234")));
        result.add(new Product("3",
                "Product3",
                new BigDecimal("6545")));
        return result;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable final String id) {
        System.out.println(id);
        return new Product("888",
                "return a single product",
                new BigDecimal("44222.33"));
    }
}

