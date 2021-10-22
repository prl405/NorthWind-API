package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.ShipperEntity;
import com.sparta.northwindrest.repositories.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShipperController {

    private final ShipperRepository shipperRepository;

    @Autowired
    public ShipperController(ShipperRepository shipperRepository) {
        this.shipperRepository = shipperRepository;
    }

    @GetMapping("/northwind/shippers")
    @ResponseBody
    public List<ShipperEntity> getAllShippers(){
        return shipperRepository.findAll();
    }
}
