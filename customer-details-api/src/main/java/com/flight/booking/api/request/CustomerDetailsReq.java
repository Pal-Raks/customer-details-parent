package com.flight.booking.api.request;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;-->only to check not null but for blank string it won't discontinue
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CustomerDetailsReq {
    @NotBlank(message="Name can't be blank.")
    private String customerName;
    @NotBlank
    @Email(message="Email isn't proper.")
    private String customerEmail;
    @Pattern(regexp = "^(\\d{3}[- ]?){2}\\d{4}$",message = "Phone number isn't proper")
    private String phoneNumber;
    //private Long phoneNumber;-->we can use long and pass both string type and
    // number type value but since we can't use pattern so change to string
    @NotBlank(message="Password can't be blank.")
    private String password;
}
