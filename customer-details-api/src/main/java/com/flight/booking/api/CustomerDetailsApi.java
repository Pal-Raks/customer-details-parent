package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("customer")
public interface CustomerDetailsApi {

    @GetMapping("/details")
    public String getCustomerDetails();

    @PostMapping("/registration")
    public String createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq);

}
