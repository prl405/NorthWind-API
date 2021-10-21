package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.*;
import com.sparta.northwindrest.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NorthwindController {

    private final ProductRepository productRepository;
    private final CustomersRepository customersRepository;
    private final EmployeeRepository employeeRepository;
    private final ShipperRepository shipperRepository;
    private final SupplierRepository supplierRepository;

    @Autowired
    public NorthwindController(ProductRepository productRepository, CustomersRepository customersRepository, EmployeeRepository employeeRepository, ShipperRepository shipperRepository, SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.customersRepository = customersRepository;
        this.employeeRepository = employeeRepository;
        this.shipperRepository = shipperRepository;
        this.supplierRepository = supplierRepository;
    }

    // ----------------------------------Products---------------------------------------------

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id){
        return productRepository.findById(id); // Exact matching
    }

    // ----------------------------------Customers---------------------------------------------

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomersEntity> getAllCustomers(@RequestParam(required = false) String name){
        if (name == null){
            return customersRepository.findAll();
        }

        List<CustomersEntity> foundCustomers = new ArrayList<>();
//        for (CustomersEntity customersEntity: customersRepository.findAll()){
//            if (customersEntity.getContactName().contains(name)){ // Partial matching
//                foundCustomers.add(customersEntity);
//            }
//        }
        foundCustomers = customersRepository.findAll()
                .stream()
                .filter(customersEntity -> customersEntity.getContactName().contains(name))
                .toList();
        return foundCustomers;
    }

    // -----------------------------------Employee--------------------------------------------

    @GetMapping("/employee")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // -----------------------------------Supplier---------------------------------------------

    @GetMapping("/supplier")
    @ResponseBody
    public List<SupplierEntity> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    // -----------------------------------Shipper---------------------------------------------

    @GetMapping("/shipper")
    @ResponseBody
    public List<ShipperEntity> getAllShippers(){
        return shipperRepository.findAll();
    }
}
