package com.sparta.northwindrest.mapservice;

import com.sparta.northwindrest.dto.EmployeeCustomersDTO;
import com.sparta.northwindrest.dto.EmployeeInfoDTO;
import com.sparta.northwindrest.dto.EmployeeDTO;
import com.sparta.northwindrest.entities.CustomersEntity;
import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.entities.OrderEntity;
import com.sparta.northwindrest.repositories.CustomersRepository;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import com.sparta.northwindrest.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomersRepository customersRepository;

    public List<EmployeeDTO> findAllEmployeesDTO(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeInfoDTO> findAllEmployeesInfoDTO(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeContactDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeCustomersDTO> findAllEmployeeCustomersDTO(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeCustomersDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToEmployeeDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setJobTitle(employeeEntity.getTitle());
        employeeDTO.setCity(employeeEntity.getCity());
        employeeDTO.setCountry(employeeEntity.getCountry());
        return employeeDTO;
    }

    private EmployeeInfoDTO convertToEmployeeContactDTO(EmployeeEntity employeeEntity){
        EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO();

        employeeInfoDTO.setId(employeeEntity.getId());
        employeeInfoDTO.setTitle(employeeEntity.getTitle());
        employeeInfoDTO.setFirstName(employeeEntity.getFirstName());
        employeeInfoDTO.setLastName(employeeEntity.getLastName());
        employeeInfoDTO.setPhone(employeeEntity.getHomePhone());
        employeeInfoDTO.setExtension(employeeEntity.getExtension());
        employeeInfoDTO.setAddress(employeeEntity.getAddress());
        employeeInfoDTO.setPostcode(employeeEntity.getPostalCode());
        employeeInfoDTO.setCity(employeeEntity.getCity());
        employeeInfoDTO.setCountry(employeeEntity.getCountry());
        return employeeInfoDTO;
    }

    private EmployeeCustomersDTO convertToEmployeeCustomersDTO(EmployeeEntity employeeEntity){
        EmployeeCustomersDTO employeeCustomersDTO = new EmployeeCustomersDTO();
        ArrayList<String> customerIdList = new ArrayList<>();
        ArrayList<String> customerNameList = new ArrayList<>();

        employeeCustomersDTO.setEmployeeId(employeeEntity.getId());
        employeeCustomersDTO.setEmployeeName(employeeEntity.getFirstName() + " "
                + employeeEntity.getLastName());
        employeeCustomersDTO.setEmployeeLocation(employeeEntity.getCity()
                + ", " + employeeEntity.getCountry());

        for (OrderEntity orderEntity: orderRepository.findAll()){
            if (orderEntity.getEmployeeID().getId().equals(employeeCustomersDTO.getEmployeeId())
                    && !customerIdList.contains(orderEntity.getCustomerID().getId())){
                customerIdList.add(orderEntity.getCustomerID().getId());
            }
        }

        for (OrderEntity orderEntity: orderRepository.findAll()){
            if (orderEntity.getEmployeeID().getId().equals(employeeCustomersDTO.getEmployeeId())
                    && !customerNameList.contains(orderEntity.getCustomerID().getCompanyName())){
                customerNameList.add(orderEntity.getCustomerID().getCompanyName());
            }
        }

        employeeCustomersDTO.setCustomerIds(customerIdList);
        employeeCustomersDTO.setCustomerNames(customerNameList);
        return employeeCustomersDTO;

    }
}
