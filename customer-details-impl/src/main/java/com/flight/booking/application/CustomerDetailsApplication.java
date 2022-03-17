package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;


public interface CustomerDetailsApplication {
    public String getCustomerDetails();
    public String createCustomerDetails(CustomerDetails customerDetails);
}
