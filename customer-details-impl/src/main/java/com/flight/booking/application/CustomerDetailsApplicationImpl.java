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
    public String getCustomerDetails() {
        return "Test";
    }

    @Override
    public String createCustomerDetails(CustomerDetails customerDetails) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setCustomerName(customerDetails.getCustomerName());
        customerEntity.setCustomerEmail(customerDetails.getCustomerEmail());
        customerEntity.setCustomerId(customerDetails.getCustomerId());
        customerEntity.setPhoneNumber(customerDetails.getPhoneNumber());
        return this.customerDetailsRepo.save(customerEntity).getCustomerId();//Just holding to remember need to change this
    }
}
