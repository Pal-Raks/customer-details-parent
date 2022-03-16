package com.flight.booking.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("hi")
public interface CustomerDetailsApi {

    @GetMapping("/d")
    public String test();

}
