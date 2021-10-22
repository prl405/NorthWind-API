package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/northwind/orders")
    @ResponseBody
    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/northwind/orders/{id}")
    @ResponseBody
    public Optional<OrderEntity> getOrderById(@PathVariable Integer id){
        return orderRepository.findById(id);
    }
}
