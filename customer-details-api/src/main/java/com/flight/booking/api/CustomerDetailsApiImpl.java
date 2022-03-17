package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import com.flight.booking.application.CustomerDetailsApplication;
import com.flight.booking.application.model.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class CustomerDetailsApiImpl implements CustomerDetailsApi {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private CustomerDetailsApplication customerDetailsApplicationImpl;
    @Autowired
    public void setCustomerDetailsApplicationImpl(CustomerDetailsApplication customerDetailsApplicationImpl) {
        this.customerDetailsApplicationImpl = customerDetailsApplicationImpl;
    }



    public ResponseEntity<String> getCustomerDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(this.customerDetailsApplicationImpl.getCustomerDetails());
    }

    public ResponseEntity<String> createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq){
        CustomerDetails customerDetails= new CustomerDetails();
        customerDetails.setCustomerEmail(customerDetails.getCustomerEmail());
        customerDetails.setCustomerName(customerDetailsReq.getCustomerName());
        customerDetails.setCustomerId(UUID.randomUUID().toString());
        customerDetails.setPassword(bCryptPasswordEncoder.encode(customerDetailsReq.getPassword()));
        customerDetails.setPhoneNumber(Integer.getInteger(customerDetailsReq.getPhoneNumber()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.customerDetailsApplicationImpl.createCustomerDetails(customerDetails));
    }
}
