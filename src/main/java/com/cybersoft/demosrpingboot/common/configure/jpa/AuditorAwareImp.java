package com.cybersoft.demosrpingboot.common.configure.jpa;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class AuditorAwareImp implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String email = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        return Optional.ofNullable(email);
    }
}
