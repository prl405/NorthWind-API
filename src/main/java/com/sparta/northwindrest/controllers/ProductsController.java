package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.ProductEntity;
import com.sparta.northwindrest.exceptionhandlers.EntityNotFoundException;
import com.sparta.northwindrest.exceptionhandlers.UtilityExceptionMethods;
import com.sparta.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/northwind/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/northwind/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) throws EntityNotFoundException {
        UtilityExceptionMethods.checkUpperBound(id, productRepository.findAll().size());
        return productRepository.findById(id); // Exact matching
    }
}
