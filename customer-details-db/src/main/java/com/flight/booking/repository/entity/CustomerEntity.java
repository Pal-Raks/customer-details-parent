package com.flight.booking.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name= "customers")
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = -2731425678149216053L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false, unique=true)
    private String userId;

    @Column(nullable = false, length=50, name = "customer_name")
    private String customerName;

    @Column(nullable=false, length=120, unique=true, name = "customer_email")
    private String customerEmail;
    @Column(nullable=false, unique=true, name="phone_number")
    private Integer phoneNumber;

    @Column(nullable=false, unique=true,name ="encrypted_password")
    private String encryptedPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id && Objects.equals(userId, that.userId) && Objects.equals(customerName, that.customerName) && Objects.equals(customerEmail, that.customerEmail) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(encryptedPassword, that.encryptedPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, customerName, customerEmail, phoneNumber, encryptedPassword);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", encryptedPassword='" + encryptedPassword + '\'' +
                '}';
    }
}
