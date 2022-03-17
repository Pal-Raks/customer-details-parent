package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;
import com.flight.booking.repository.CustomerDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerDetailsApplicationImpl implements CustomerDetailsApplication {

    private CustomerDetailsRepo customerDetailsRepo;
    //BCryptPasswordEncoder bCryptPasswordEncoder;
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
        customerDetails.setCustomerId(UUID.randomUUID().toString());
        //customerDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        return null;
                //this.customerDetailsRepo.save(customerDetails);
    }
}
