package com.flight.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})
//@EntityScan(basePackages = {"com.flight.booking.*"})
//@ComponentScan(basePackages = {"com.flight.booking.*"}) //if its not in package format properly
public class CustomerDetailsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerDetailsApplication.class);
    }
}
