package com.sparta.northwindrest.mapservice;

import com.sparta.northwindrest.dto.CustomersDTO;
import com.sparta.northwindrest.dto.CustomersInfoDTO;
import com.sparta.northwindrest.entities.CustomersEntity;
import com.sparta.northwindrest.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersMapService {
    @Autowired
    private CustomersRepository customersRepository;

    public List<CustomersDTO> findAllCustomersDTO(){
        return customersRepository.findAll()
                .stream()
                .map(this::convertToCustomersDTO)
                .collect(Collectors.toList());
    }

    public List<CustomersInfoDTO> findAllCustomerInfo(){
        return customersRepository.findAll()
                .stream()
                .map(this::convertToCustomersInfoDTO)
                .collect(Collectors.toList());
    }

    private CustomersDTO convertToCustomersDTO(CustomersEntity customersEntity){
        CustomersDTO customersDTO = new CustomersDTO();

        customersDTO.setCustomerId(customersEntity.getId());
        customersDTO.setCompanyName(customersEntity.getCompanyName());
        customersDTO.setContactInfo(convertToCustomersInfoDTO(customersEntity));
        return customersDTO;
    }

    private CustomersInfoDTO convertToCustomersInfoDTO(CustomersEntity customersEntity){
        CustomersInfoDTO customersInfoDTO = new CustomersInfoDTO();

        customersInfoDTO.setContactName(customersEntity.getContactName());
        customersInfoDTO.setContactJobTitle(customersEntity.getContactTitle());
        customersInfoDTO.setAddress(customersEntity.getAddress());
        customersInfoDTO.setPostalCode(customersEntity.getPostalCode());
        customersInfoDTO.setLocation(customersEntity.getCity() +
                ", " + customersEntity.getCountry());
        customersInfoDTO.setPhoneNumber(customersEntity.getPhone());
        customersInfoDTO.setFax(customersEntity.getFax());
        return customersInfoDTO;
    }
}
