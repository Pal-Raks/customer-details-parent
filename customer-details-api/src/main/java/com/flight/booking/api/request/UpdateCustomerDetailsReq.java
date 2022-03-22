package com.flight.booking.api.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateCustomerDetailsReq {
    @NotBlank(message="Name can't be blank.")
    private String customerName;
    @NotNull(message="Password can't be blank.")
    private String password;
    @NotBlank(message="Password can't be blank.")
    private String phoneNumber;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UpdateCustomerDetailsReq{" +
                "customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
