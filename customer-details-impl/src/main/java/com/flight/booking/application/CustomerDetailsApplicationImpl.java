package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;
import com.flight.booking.repository.CustomerDetailsRepo;
import com.flight.booking.repository.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerDetailsApplicationImpl implements CustomerDetailsApplication {

    private CustomerDetailsRepo customerDetailsRepo;

    @Autowired
    public void setCustomerDetailsRepo(CustomerDetailsRepo customerDetailsRepo) {
        this.customerDetailsRepo = customerDetailsRepo;
    }

    @Override
    public CustomerDetails getCustomerDetails(String customerId) {
        CustomerEntity customerEntity = this.customerDetailsRepo.findByCustomerId(customerId);
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerName(customerEntity.getCustomerName());
        customerDetails.setCustomerEmail(customerEntity.getCustomerEmail());
        customerDetails.setCustomerId(customerEntity.getCustomerId());
        customerDetails.setPhoneNumber(customerEntity.getPhoneNumber());
        return customerDetails;
    }

    @Override
    public String createCustomerDetails(CustomerDetails customerDetails) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(customerDetails.getCustomerName());
        customerEntity.setCustomerEmail(customerDetails.getCustomerEmail());
        customerEntity.setCustomerId(customerDetails.getCustomerId());
        customerEntity.setPhoneNumber(customerDetails.getPhoneNumber());
        customerEntity.setEncryptedPassword(customerDetails.getPassword());
        customerEntity= this.customerDetailsRepo.save(customerEntity);
        return customerEntity.getCustomerId();
    }

    @Override
    public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails, String customerId) {
        CustomerEntity customerEntity = this.customerDetailsRepo.findByCustomerId(customerId);
        customerEntity.setCustomerName(customerDetails.getCustomerName());
        customerEntity.setCustomerEmail(customerDetails.getCustomerEmail());
        customerEntity.setCustomerId(customerDetails.getCustomerId());
        customerEntity.setPhoneNumber(customerDetails.getPhoneNumber());
        customerEntity.setEncryptedPassword(customerDetails.getPassword());
        customerEntity= this.customerDetailsRepo.save(customerEntity);

        return null;//Just holding to remember need to change this
    }
}
