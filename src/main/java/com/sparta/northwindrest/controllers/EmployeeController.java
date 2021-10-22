package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.dto.EmployeeDetailsDTO;
import com.sparta.northwindrest.mapservice.EmployeeMapService;
import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    @Autowired
    private final EmployeeMapService employeeMapService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeMapService employeeMapService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapService = employeeMapService;
    }

    @GetMapping("/northwind/employees")
    @ResponseBody
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) String firstName,
                                             @RequestParam(required = false) String lastName,
                                             @RequestParam(required = false) String country,
                                             @RequestParam(required = false) String city){

        List<EmployeeEntity> foundEntities = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            if (checkFirstName(employeeEntity, firstName) && !foundEntities.contains(employeeEntity)) {
                foundEntities.add(employeeEntity);
            }
            if (checkLastName(employeeEntity, lastName) && !foundEntities.contains(employeeEntity)) {
                foundEntities.add(employeeEntity);
            }
            if (checkCountry(employeeEntity, country) && !foundEntities.contains(employeeEntity)) {
                foundEntities.add(employeeEntity);
            }
            if (checkCity(employeeEntity, city) && !foundEntities.contains(employeeEntity)) {
                foundEntities.add(employeeEntity);
            }
        }
        if (foundEntities.size() == 0){
            throw new IllegalArgumentException();
        }
        else {
            return foundEntities;
        }
    }

    @GetMapping("/northwind/employees/{id}")
    @ResponseBody
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable Integer id){
        return employeeRepository.findById(id);
    }

    @GetMapping("/northwind/employees/employeeDetails")
    @ResponseBody
    public List<EmployeeDetailsDTO> getAllEmployeeDetails(){
        return employeeMapService.getAllEmployeeDetails();
    }

    //----------------------------Utility Methods-------------------------------------

    private boolean checkCity(EmployeeEntity employeeEntity, String city){
        return city != null && (employeeEntity.getCity().contains(city)
                || employeeEntity.getCity().toLowerCase().contains(city));
    }

    private boolean checkFirstName(EmployeeEntity employeeEntity, String firstName){
        return firstName != null && (employeeEntity.getFirstName().contains(firstName)
                || employeeEntity.getFirstName().toLowerCase().contains(firstName));
    }

    private boolean checkLastName(EmployeeEntity employeeEntity, String lastName){
        return lastName != null && (employeeEntity.getLastName().contains(lastName)
                || employeeEntity.getLastName().toLowerCase().contains(lastName));
    }

    private boolean checkCountry(EmployeeEntity employeeEntity, String country){
        return country != null && (employeeEntity.getCountry().contains(country)
                || employeeEntity.getCountry().toLowerCase().contains(country));
    }
}