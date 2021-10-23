package com.sparta.northwindrest.dto;


public class CustomersDTO {
    private String customerId;
    private String companyName;
    private CustomersInfoDTO contactInfo;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CustomersInfoDTO getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(CustomersInfoDTO contactInfo) {
        this.contactInfo = contactInfo;
    }
}
