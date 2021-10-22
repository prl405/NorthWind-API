package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.dto.OrdersDTO;
import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.mapservice.OrdersMapService;
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
    private final OrdersMapService ordersMapService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrdersMapService ordersMapService) {
        this.orderRepository = orderRepository;
        this.ordersMapService = ordersMapService;
    }

    @GetMapping("/northwind/orders")
    @ResponseBody
    public List<OrdersDTO> getAllOrders(){
        return ordersMapService.findAllOrdersDTO();
    }

    @GetMapping("/northwind/orders/fullInfo")
    @ResponseBody
    public List<OrderEntity> getAllOrdersInfo(){
        return orderRepository.findAll();
    }

    @GetMapping("/northwind/orders/{id}")
    @ResponseBody
    public Optional<OrderEntity> getOrderById(@PathVariable Integer id){
        return orderRepository.findById(id);
    }
}
