package com.sparta.northwindrest.controllers;

import com.sparta.northwindrest.dto.EmployeeCustomersDTO;
import com.sparta.northwindrest.dto.EmployeeInfoDTO;
import com.sparta.northwindrest.dto.EmployeeDTO;
import com.sparta.northwindrest.exceptionhandlers.EntityNotFoundException;
import com.sparta.northwindrest.exceptionhandlers.UtilityExceptionMethods;
import com.sparta.northwindrest.mapservice.EmployeeMapService;
import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/northwind")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    @Autowired
    private final EmployeeMapService employeeMapService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository, EmployeeMapService employeeMapService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapService = employeeMapService;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeDTO> getAllEmployees(){
        return employeeMapService.findAllEmployeesDTO();
    }

    @GetMapping("/employees/")
    @ResponseBody
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) String firstName,
                                             @RequestParam(required = false) String lastName,
                                             @RequestParam(required = false) String country,
                                             @RequestParam(required = false) String city) throws EntityNotFoundException{

        List<EmployeeDTO> foundEntities = new ArrayList<>();
        for (EmployeeDTO employeeDTO : employeeMapService.findAllEmployeesDTO()) {
            if (checkFirstName(employeeDTO, firstName) && !foundEntities.contains(employeeDTO)) {
                foundEntities.add(employeeDTO);
            }
            if (checkLastName(employeeDTO, lastName) && !foundEntities.contains(employeeDTO)) {
                foundEntities.add(employeeDTO);
            }
            if (checkCountry(employeeDTO, country) && !foundEntities.contains(employeeDTO)) {
                foundEntities.add(employeeDTO);
            }
            if (checkCity(employeeDTO, city) && !foundEntities.contains(employeeDTO)) {
                foundEntities.add(employeeDTO);
            }
        }
        if (foundEntities.size() == 0){
            throw new EntityNotFoundException("No Values Provided");
        }
        else {
            return foundEntities;
        }
    }

    @GetMapping("/employees/info")
    @ResponseBody
    public List<EmployeeInfoDTO> getAllEmployeeInfo(){
        return employeeMapService.findAllEmployeesInfoDTO();
    }

    @GetMapping("/employees/customers")
    @ResponseBody
    public List<EmployeeCustomersDTO> getAllEmployeeCustomers(){
        return employeeMapService.findAllEmployeeCustomersDTO();
    }

    @GetMapping("/employees/fullInfo/{id}")
    @ResponseBody
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable Integer id) throws EntityNotFoundException{
        UtilityExceptionMethods.checkUpperBound(id, employeeRepository.findAll().size());
        return employeeRepository.findById(id);
    }

    @GetMapping("/employees/fullInfo")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployeeDetails(){
        return employeeRepository.findAll();
    }

    //----------------------------Utility Methods-------------------------------------

    private boolean checkCity(EmployeeDTO employeeDTO, String city){
        return city != null && (employeeDTO.getCity().contains(city)
                || employeeDTO.getCity().toLowerCase().contains(city));
    }

    private boolean checkFirstName(EmployeeDTO employeeDTO, String firstName){
        return firstName != null && (employeeDTO.getFirstName().contains(firstName)
                || employeeDTO.getFirstName().toLowerCase().contains(firstName));
    }

    private boolean checkLastName(EmployeeDTO employeeDTO, String lastName){
        return lastName != null && (employeeDTO.getLastName().contains(lastName)
                || employeeDTO.getLastName().toLowerCase().contains(lastName));
    }

    private boolean checkCountry(EmployeeDTO employeeDTO, String country){
        return country != null && (employeeDTO.getCountry().contains(country)
                || employeeDTO.getCountry().toLowerCase().contains(country));
    }
}