package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.ProductEntity;
import com.sparta.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NorthwindController {

    private final ProductRepository productRepository;

    @Autowired
    public NorthwindController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }
}
