package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import com.flight.booking.api.request.UpdateCustomerDetailsReq;
import com.flight.booking.api.response.CustomerDetailsResponse;
import com.flight.booking.application.CustomerDetailsApplication;
import com.flight.booking.application.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CustomerDetailsApiImpl implements CustomerDetailsApi {
    private CustomerDetailsApplication customerDetailsApplicationImpl;
    @Autowired
    public void setCustomerDetailsApplicationImpl(CustomerDetailsApplication customerDetailsApplicationImpl) {
        this.customerDetailsApplicationImpl = customerDetailsApplicationImpl;
    }
    @Bean
    private BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(15);
    }


    public ResponseEntity<CustomerDetailsResponse> getCustomerDetails(String customerId){
        CustomerDetailsResponse customerDetailsResponse = null;
        try {
            CustomerDetails customerDetails=this.customerDetailsApplicationImpl.getCustomerDetails(customerId);
            customerDetailsResponse = new CustomerDetailsResponse();
            customerDetailsResponse.setCustomerName(customerDetails.getCustomerName());
            customerDetailsResponse.setCustomerEmail(customerDetails.getCustomerEmail());
            customerDetailsResponse.setPhoneNumber(String.valueOf(customerDetails.getPhoneNumber()));
            customerDetailsResponse.setCustomerId(customerDetails.getCustomerId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerDetailsResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsResponse);
    }

    public ResponseEntity<String> createCustomerDetails(CustomerDetailsReq customerDetailsReq){
        CustomerDetails customerDetails= new CustomerDetails();
        customerDetails.setCustomerEmail(customerDetailsReq.getCustomerEmail());
        customerDetails.setCustomerName(customerDetailsReq.getCustomerName());
        customerDetails.setCustomerId(UUID.randomUUID().toString());
        customerDetails.setPhoneNumber(Long.parseLong(customerDetailsReq.getPhoneNumber()));
        customerDetails.setPassword(bCryptPasswordEncoder().encode(customerDetailsReq.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.customerDetailsApplicationImpl.createCustomerDetails(customerDetails));
    }

    @Override
    public ResponseEntity<CustomerDetailsResponse> updateCustomerDetails(UpdateCustomerDetailsReq updateCustomerDetailsReq, String customerId){
        CustomerDetails customerDetails= new CustomerDetails();
        if(updateCustomerDetailsReq.getPhoneNumber()!=null &&
                !updateCustomerDetailsReq.getPhoneNumber().isEmpty())
        {
            customerDetails.setPhoneNumber(Long.parseLong
                    (updateCustomerDetailsReq.getPhoneNumber()));
        }
        if(updateCustomerDetailsReq.getCustomerName()!=null
                && !updateCustomerDetailsReq.getCustomerName().isEmpty()) {
            customerDetails.setCustomerName(updateCustomerDetailsReq.getCustomerName());
        }
        if(updateCustomerDetailsReq.getPassword()!=null &&
                !updateCustomerDetailsReq.getPassword().isEmpty()) {
            customerDetails.setPassword(bCryptPasswordEncoder().encode(updateCustomerDetailsReq.getPassword()));
        }

        CustomerDetailsResponse customerDetailsResponse = null;
        try {
            CustomerDetails customerDetailsPostUpdate=this.customerDetailsApplicationImpl.updateCustomerDetails(customerDetails,customerId);
            customerDetailsResponse = new CustomerDetailsResponse();
            customerDetailsResponse.setCustomerName(customerDetailsPostUpdate.getCustomerName());
            customerDetailsResponse.setCustomerEmail(customerDetailsPostUpdate.getCustomerEmail());
            customerDetailsResponse.setPhoneNumber(String.valueOf(customerDetailsPostUpdate.getPhoneNumber()));
            customerDetailsResponse.setCustomerId(customerDetailsPostUpdate.getCustomerId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customerDetailsResponse);
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDetailsResponse);
    }

    @Override
    public ResponseEntity<String> deleteCustomerByCustomerId(String customerId) {
        String response=this.customerDetailsApplicationImpl.deleteCustomerByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(response+" : "+customerId);
    }
}
