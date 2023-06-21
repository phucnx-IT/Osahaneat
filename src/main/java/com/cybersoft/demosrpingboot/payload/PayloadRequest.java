package com.cybersoft.demosrpingboot.payload;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PayloadRequest {
    @Size(min = 4, max = 20, message = "The email must be from 4 to 20 characters")
    @NotBlank
    private String email;
    @Size(min = 4, max = 20, message = "The username must be from 4 to 20 characters")
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 4, max = 20, message = "The password must be from 4 to 20 characters")
    private String password;
    @NegativeOrZero(message = "Id must not be zero or negative")
    private int roleId;
}
