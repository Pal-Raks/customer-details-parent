package com.flight.booking.application;

import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsApplicationImpl implements CustomerDetailsApplication {

    @Override
    public String getCustomerDetails() {
        return "Test";
    }
}
