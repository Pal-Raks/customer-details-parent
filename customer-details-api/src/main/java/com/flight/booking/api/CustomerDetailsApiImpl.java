package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import com.flight.booking.application.CustomerDetailsApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CustomerDetailsApiImpl implements CustomerDetailsApi {

    private CustomerDetailsApplication customerDetailsApplicationImpl;
    @Autowired
    public void setCustomerDetailsApplicationImpl(CustomerDetailsApplication customerDetailsApplicationImpl) {
        this.customerDetailsApplicationImpl = customerDetailsApplicationImpl;
    }



    public ResponseEntity<String> getCustomerDetails(){
        return ResponseEntity.status(HttpStatus.OK).body(this.customerDetailsApplicationImpl.getCustomerDetails());
    }

    public ResponseEntity<String> createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.customerDetailsApplicationImpl.getCustomerDetails());
    }
}
