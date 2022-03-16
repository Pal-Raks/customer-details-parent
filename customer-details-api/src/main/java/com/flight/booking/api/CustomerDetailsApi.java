package com.flight.booking.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("customer")
public interface CustomerDetailsApi {

    @GetMapping("/details")
    public String getCustomerDetails();

}
