package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("customer")
public interface CustomerDetailsApi {

    @GetMapping(value = "/details",produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getCustomerDetails();

    @PostMapping(value = "/registration",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq);

}
