package com.flight.booking.api.request;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UpdateCustomerDetailsReq {
    @NotBlank(message="Name can't be blank.")
    private String customerName;
    @NotBlank(message="Password can't be blank.")
    private String password;

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

    @Override
    public String toString() {
        return "CustomerDetailsReq{" +
                "customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
