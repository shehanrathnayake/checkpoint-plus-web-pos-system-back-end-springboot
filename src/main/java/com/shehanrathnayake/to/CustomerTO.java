package com.shehanrathnayake.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTO implements Serializable {
    @Null(message = "Customer ID should be null")
    String customerId;
    @NotBlank(message = "Customer name cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Wrong name format")
    String name;
    @NotBlank(message = "Customer phone number cannot be blank")
    @Pattern(regexp = "^[+]?\\d+$", message = "Wrong number format")
    String phone;
    @NotBlank(message = "Address cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Wrong address format")
    String address;
}
