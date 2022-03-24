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
        customerEntity = this.customerDetailsRepo.save(customerEntity);
        return customerEntity.getCustomerId();
    }

    @Override
    public CustomerDetails updateCustomerDetails(CustomerDetails customerDetails, String customerId) {
        CustomerEntity customerEntity = this.customerDetailsRepo.findByCustomerId(customerId);
        if (customerEntity == null) {
            return null;
        }
        if (customerDetails.getCustomerName() != null && !customerDetails.getCustomerName().isEmpty()) {
            customerEntity.setCustomerName(customerDetails.getCustomerName());
        }
        if (customerDetails.getPhoneNumber() != null) {
            customerEntity.setPhoneNumber(customerDetails.getPhoneNumber());
        }
        if (customerDetails.getPassword() != null && !customerDetails.getPassword().isEmpty()) {
            customerEntity.setEncryptedPassword(customerDetails.getPassword());
        }
        customerEntity = this.customerDetailsRepo.save(customerEntity);
        customerDetails.setCustomerName(customerEntity.getCustomerName());
        customerDetails.setCustomerEmail(customerEntity.getCustomerEmail());
        customerDetails.setCustomerId(customerEntity.getCustomerId());
        customerDetails.setPhoneNumber(customerEntity.getPhoneNumber());
        return customerDetails;
    }

    @Override
    public String deleteCustomerByCustomerId(String customerId) {
        long deletedRowsCount = this.customerDetailsRepo.deleteByCustomerId(customerId);
        return deletedRowsCount>0?"Success":"Entity Not found";
    }
}
