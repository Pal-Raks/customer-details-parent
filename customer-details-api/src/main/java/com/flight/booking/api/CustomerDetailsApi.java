package com.flight.booking.api;

import com.flight.booking.api.request.CustomerDetailsReq;
import com.flight.booking.api.request.UpdateCustomerDetailsReq;
import com.flight.booking.api.response.CustomerDetailsResponse;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@RequestMapping("customer")
@OpenAPIDefinition(info = @Info(title = "Customer details API", version = "1.0", description = "Customer details Information"))

public interface CustomerDetailsApi {

//    @ApiOperation(value = "getCustomer", nickname = "getCustomer")
//    @ApiResponses(value = {
//            @ApiResponse(code = 500, message = "Server error"),
//            @ApiResponse(code = 200, message = "Successful retrieval",
//                    response = CustomerDetailsResponse.class) })
//    @RequestMapping(method = RequestMethod.GET, value = "/customer/details/{customerId}")
    @Tag(name = "getCustomerDetailsByCustomerId")
    @GetMapping(value = "/details/{customerId}",produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    ResponseEntity<CustomerDetailsResponse> getCustomerDetails(@PathVariable String customerId);

    @PostMapping(value = "/registration",consumes = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    ResponseEntity<String> createCustomerDetails(@RequestBody @Valid CustomerDetailsReq customerDetailsReq);

    @PutMapping(value = "/details/{customerId}",consumes =  {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    },
            produces =  {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            } )
    ResponseEntity<CustomerDetailsResponse> updateCustomerDetails(@RequestBody @Valid UpdateCustomerDetailsReq updateCustomerDetailsReq, @PathVariable String customerId);


    @DeleteMapping(value = "/delete/{customerId}", consumes =  {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    } )
    ResponseEntity<String> deleteCustomerDetailsByVustomerId(@PathVariable String customerId);

}
