package com.cybersoft.demosrpingboot.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank
    @Email
    private String email;
    @Size(min = 4, max = 20, message = "{payload.username.size}")
    @NotBlank
    private String firstName;
    @Size(min = 4, max = 20, message = "{payload.username.size}")
    @NotBlank
    private String lastName;
    @Size(min = 4, max = 20, message = "{payload.username.size}")
    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 4, max = 20, message = "{payload.password.size}")
    private String password;
}
