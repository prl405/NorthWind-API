package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.repositories.ProductRepository;

public class NorthwindController {

    private ProductRepository productRepository;

    public NorthwindController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
