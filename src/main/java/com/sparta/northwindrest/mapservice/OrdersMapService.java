package com.sparta.northwindrest.mapservice;

import com.sparta.northwindrest.dto.OrdersDTO;
import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersMapService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private EmployeeMapService employeeMapService;

    public List<OrdersDTO> findAllOrdersDTO(){
        return orderRepository.findAll()
                .stream()
                .map(this::convertToOrdersDTO)
                .collect(Collectors.toList());
    }

    private OrdersDTO convertToOrdersDTO(OrderEntity orderEntity){
        OrdersDTO ordersDTO = new OrdersDTO();

        ordersDTO.setOrderId(orderEntity.getId());
        ordersDTO.setCustomerId(orderEntity.getCustomerID().getId());
        ordersDTO.setEmployee(employeeMapService.convertToEmployeeDTO(orderEntity.getEmployeeID()));
        ordersDTO.setOrderedDate(orderEntity.getOrderDate());
        ordersDTO.setRequiredDate(orderEntity.getRequiredDate());
        ordersDTO.setShippedDate(orderEntity.getShippedDate());
        ordersDTO.setShipmentAddress(orderEntity.getShipAddress());
        ordersDTO.setShipmentPostcode(orderEntity.getShipPostalCode());
        ordersDTO.setShipmentCity(orderEntity.getShipCity());
        ordersDTO.setShipper(orderEntity.getShipVia());
        return ordersDTO;
    }
}
