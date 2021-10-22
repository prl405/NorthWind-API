package com.sparta.northwindrest.dto;

import com.sparta.northwindrest.entities.CustomersEntity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCustomersDTO {
    private Integer employeeId;
    private String employeeName;
    private String employeeLocation;
    private List<String> customerIds;
    private List<String> customerNames;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation;
    }

    public List<String> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<String> customerIds) {
        this.customerIds = customerIds;
    }

    public List<String> getCustomerNames() {
        return customerNames;
    }

    public void setCustomerNames(List<String> customerNames) {
        this.customerNames = customerNames;
    }
}
