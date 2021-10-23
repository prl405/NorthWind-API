package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.dto.OrdersDTO;
import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.exceptionhandlers.EntityNotFoundException;
import com.sparta.northwindrest.exceptionhandlers.UtilityExceptionMethods;
import com.sparta.northwindrest.mapservice.OrdersMapService;
import com.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/northwind")
public class OrderController {

    private final OrderRepository orderRepository;
    @Autowired
    private final OrdersMapService ordersMapService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrdersMapService ordersMapService) {
        this.orderRepository = orderRepository;
        this.ordersMapService = ordersMapService;
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<OrdersDTO> getAllOrders(){
        return ordersMapService.findAllOrdersDTO();
    }

    @GetMapping("/orders/fullInfo")
    @ResponseBody
    public List<OrderEntity> getAllOrdersInfo(){
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    @ResponseBody
    public Optional<OrderEntity> getOrderById(@PathVariable Integer id) throws EntityNotFoundException {
        UtilityExceptionMethods.checkBounds(id, 10248, 11077);
        return orderRepository.findById(id);
    }
}
