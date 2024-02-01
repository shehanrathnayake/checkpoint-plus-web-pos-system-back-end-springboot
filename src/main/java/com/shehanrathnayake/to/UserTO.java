package com.shehanrathnayake.to;

import com.shehanrathnayake.util.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserTO implements Serializable {
    @Null(message = "Id should be null")
    private String id;
    @NotBlank(message = "Name cannot be null")
    @Pattern(regexp = "^[A-Za-z. ]+$", message = "Invalid name")
    private String name;
    @NotBlank(message = "Password cannot be null")
    @Pattern(regexp = "^[A-Za-z0-9@#$%^&*]+$", message = "Invalid password format")
    private String password;
    @NotNull(message = "User role cannot be null")
    private UserRole roles;
}
