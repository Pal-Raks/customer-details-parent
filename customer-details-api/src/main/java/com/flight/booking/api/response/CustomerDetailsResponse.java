package com.flight.booking.api.response;

public class CustomerDetailsResponse {

    private String customerName;
    private String customerEmail;
    private String phoneNumber;
    private String customerId;

    public CustomerDetailsResponse() { //sometimes jackson binding gives error so need to use
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerDetailsResponse{" +
                "customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
