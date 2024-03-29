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
    private String customerId;
    @NotBlank(message = "Customer name cannot be blank")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Wrong name format")
    private String name;
    @NotBlank(message = "Customer phone number cannot be blank")
    @Pattern(regexp = "^[+]?\\d+$", message = "Wrong number format")
    private String phone;
    @NotBlank(message = "Address cannot be blank")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Wrong address format")
    private String address;

    public CustomerTO(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
