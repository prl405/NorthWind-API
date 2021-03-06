package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.SupplierEntity;
import com.sparta.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/northwind")
public class SupplierController {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/suppliers")
    @ResponseBody
    public List<SupplierEntity> getAllSuppliers(){
        return supplierRepository.findAll();
    }
}
