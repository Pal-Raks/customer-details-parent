package com.flight.booking.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDetailsApiImpl implements CustomerDetailsApi {
    public String test(){
        return "hi";
    }
}
