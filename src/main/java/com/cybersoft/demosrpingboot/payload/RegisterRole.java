package com.cybersoft.demosrpingboot.payload;

import com.cybersoft.demosrpingboot.entity.Users;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRole {
    @Size(min = 4, max = 20, message = "{register.roleName.size}")
    @NotBlank
    private String roleName;
}
