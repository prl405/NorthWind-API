package com.sparta.northwindrest.DTO;

import com.sparta.northwindrest.entities.EmployeeEntity;
import com.sparta.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeMapService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDetailsDTO> getAllEmployeeDetails(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeDetailsDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDetailsDTO convertToEmployeeDetailsDTO(EmployeeEntity employeeEntity){
        EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO();

        employeeDetailsDTO.setId(employeeEntity.getId());
        employeeDetailsDTO.setFirstName(employeeEntity.getFirstName());
        employeeDetailsDTO.setLastName(employeeEntity.getLastName());
        employeeDetailsDTO.setJobTitle(employeeEntity.getTitle());
        employeeDetailsDTO.setCity(employeeEntity.getCity());
        employeeDetailsDTO.setCountry(employeeEntity.getCountry());
        return employeeDetailsDTO;
    }
}
