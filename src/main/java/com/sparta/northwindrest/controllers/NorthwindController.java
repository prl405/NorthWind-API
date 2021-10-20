package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.CustomersEntity;
import com.sparta.northwindrest.entities.ProductEntity;
import com.sparta.northwindrest.repositories.CustomersRepository;
import com.sparta.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NorthwindController {

    private final ProductRepository productRepository;
    private CustomersRepository customersRepository;

    @Autowired
    public NorthwindController(ProductRepository productRepository, CustomersRepository customersRepository) {
        this.productRepository = productRepository;
        this.customersRepository = customersRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id){
        return productRepository.findById(id); // Exact matching
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomersEntity> getAllCustomers(@RequestParam(required = false) String name){
        if (name == null){
            return customersRepository.findAll();
        }

        List<CustomersEntity> foundCustomers = new ArrayList<>();
        for (CustomersEntity customersEntity: customersRepository.findAll()){
            if (customersEntity.getContactName().contains(name)){ // Partial matching
                foundCustomers.add(customersEntity);
            }
        }
        return foundCustomers;
    }
}
