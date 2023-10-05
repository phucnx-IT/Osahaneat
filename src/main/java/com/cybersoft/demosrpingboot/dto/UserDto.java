package com.cybersoft.demosrpingboot.dto;

import com.cybersoft.demosrpingboot.payload.RegisterRole;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDto {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private Set<RegisterRole> roles;
}
