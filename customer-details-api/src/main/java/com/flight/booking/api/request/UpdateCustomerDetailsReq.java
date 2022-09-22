package com.flight.booking.api.request;

import java.util.Objects;

public class UpdateCustomerDetailsReq {
    private String customerName;
    private String password;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCustomerDetailsReq that = (UpdateCustomerDetailsReq) o;
        return Objects.equals(customerName, that.customerName) && Objects.equals(password, that.password) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, password, phoneNumber);
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
