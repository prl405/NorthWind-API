package com.sparta.northwindrest.mapservice;

import com.sparta.northwindrest.dto.EmployeeDTO;
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

    public List<EmployeeDTO> findAllEmployeesDTO(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeDetailsDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDTO convertToEmployeeDetailsDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(employeeEntity.getFirstName());
        employeeDTO.setLastName(employeeEntity.getLastName());
        employeeDTO.setJobTitle(employeeEntity.getTitle());
        employeeDTO.setCity(employeeEntity.getCity());
        employeeDTO.setCountry(employeeEntity.getCountry());
        return employeeDTO;
    }
}
