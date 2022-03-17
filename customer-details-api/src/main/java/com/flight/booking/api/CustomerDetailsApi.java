package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import com.flight.booking.api.request.UpdateCustomerDetailsReq;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("customer")
public interface CustomerDetailsApi {

    @GetMapping(value = "/details/{customerId}",produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    ResponseEntity<String> getCustomerDetails(@PathVariable String customerId);

    @PostMapping(value = "/registration",consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    ResponseEntity<String> createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq);

    @PutMapping(value = "/details/{customerId}",consumes =  {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    },
            produces =  {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            } )
    ResponseEntity<String> updateCustomerDetails(@RequestBody @Valid UpdateCustomerDetailsReq updateCustomerDetailsReq, @PathVariable String customerId);

}
