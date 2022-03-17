package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;


public interface CustomerDetailsApplication {
     String getCustomerDetails();
     String createCustomerDetails(CustomerDetails customerDetails);
}
