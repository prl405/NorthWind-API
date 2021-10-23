package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.dto.CustomersDTO;
import com.sparta.northwindrest.entities.CustomersEntity;
import com.sparta.northwindrest.mapservice.CustomersMapService;
import com.sparta.northwindrest.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomersController {

    private final CustomersRepository customersRepository;
    @Autowired
    private final CustomersMapService customersMapService;

    @Autowired
    public CustomersController(CustomersRepository customersRepository, CustomersMapService customersMapService) {
        this.customersRepository = customersRepository;
        this.customersMapService = customersMapService;
    }

    @GetMapping("/northwind/customers")
    @ResponseBody
    public List<CustomersDTO> getAllCustomers(){
        return customersMapService.findAllCustomersDTO();
    }

    @GetMapping("/northwind/customers/fullInfo")
    @ResponseBody
    public List<CustomersEntity> getAllCustomersInfo(@RequestParam(required = false) String companyName){
        if (companyName == null){
            return customersRepository.findAll();
        }
        return customersRepository.findAll()
                .stream()
                .filter(customersEntity -> customersEntity.getContactName().contains(companyName))
                .toList();
    }
}
