package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

//    @GetMapping("/employees")
//    @ResponseBody
//    public List<EmployeeEntity> getEmployeesFirstNameAndCountry(@RequestParam(required = false) String firstName,
//                                                                  @RequestParam(required = false) String country){
//
//        if (firstName == null || country == null){
//            return employeeRepository.findAll();
//        }
//        return employeeRepository.findAll()
//                .stream()
//                .filter(employeeEntity -> employeeEntity.getFirstName().contains(firstName) &&
//                        employeeEntity.getCountry().equals(country))
//                .toList();
//    }
}
