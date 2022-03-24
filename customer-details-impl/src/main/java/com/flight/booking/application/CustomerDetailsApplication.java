package com.flight.booking.application;

import com.flight.booking.application.model.CustomerDetails;


public interface CustomerDetailsApplication {
     CustomerDetails getCustomerDetails(String customerId);
     String createCustomerDetails(CustomerDetails customerDetails);
     CustomerDetails updateCustomerDetails(CustomerDetails customerDetails, String customerId);
     String deleteCustomerByCustomerId(String customerId);
}
