package com.sparta.northwindrest.mapservice;

import com.sparta.northwindrest.dto.EmployeeContactDTO;
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
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());
    }

    public List<EmployeeContactDTO> findAllEmployeesContactDTO(){
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToEmployeeContactDTO)
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

    private EmployeeContactDTO convertToEmployeeContactDTO(EmployeeEntity employeeEntity){
        EmployeeContactDTO employeeContactDTO = new EmployeeContactDTO();

        employeeContactDTO.setId(employeeEntity.getId());
        employeeContactDTO.setTitle(employeeEntity.getTitle());
        employeeContactDTO.setFirstName(employeeEntity.getFirstName());
        employeeContactDTO.setLastName(employeeEntity.getLastName());
        employeeContactDTO.setPhone(employeeEntity.getHomePhone());
        employeeContactDTO.setPhone(employeeEntity.getExtension());
        employeeContactDTO.setAddress(employeeEntity.getAddress());
        employeeContactDTO.setPostcode(employeeContactDTO.getPostcode());
        employeeContactDTO.setCity(employeeEntity.getCity());
        employeeContactDTO.setCountry(employeeEntity.getCountry());
        return employeeContactDTO;
    }
}
