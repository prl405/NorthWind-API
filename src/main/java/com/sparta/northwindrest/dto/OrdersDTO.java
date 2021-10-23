package com.sparta.northwindrest.dto;

import com.sparta.northwindrest.entities.ShipperEntity;

import java.time.Instant;

public class OrdersDTO {

    private Integer orderId;
    private String customerId;
    private EmployeeDTO employee;
    private Instant orderedDate;
    private Instant requiredDate;
    private Instant shippedDate;
    private String shipmentAddress;
    private String shipmentPostcode;
    private String shipmentCity;
    private ShipperEntity shipper;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }

    public Instant getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Instant orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Instant getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Instant requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public String getShipmentPostcode() {
        return shipmentPostcode;
    }

    public void setShipmentPostcode(String shipmentPostcode) {
        this.shipmentPostcode = shipmentPostcode;
    }

    public String getShipmentCity() {
        return shipmentCity;
    }

    public void setShipmentCity(String shipmentCity) {
        this.shipmentCity = shipmentCity;
    }

    public ShipperEntity getShipper() {
        return shipper;
    }

    public void setShipper(ShipperEntity shipper) {
        this.shipper = shipper;
    }
}
