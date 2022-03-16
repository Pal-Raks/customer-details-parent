package com.flight.booking.api;

import com.flight.booking.application.CustomerDetailsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDetailsApiImpl implements CustomerDetailsApi {

    private CustomerDetailsApplication customerDetailsApplicationImpl;
    @Autowired
    public void setCustomerDetailsApplicationImpl(CustomerDetailsApplication customerDetailsApplicationImpl) {
        this.customerDetailsApplicationImpl = customerDetailsApplicationImpl;
    }



    public String getCustomerDetails(){
        return this.customerDetailsApplicationImpl.getCustomerDetails();
    }
}
