package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsApplicationImpl implements CustomerDetailsApplication {

    @Override
    public String getCustomerDetails() {
        return "Test";
    }

    @Override
    public String createCustomerDetails(CustomerDetails customerDetails) {
        return null;
    }
}
