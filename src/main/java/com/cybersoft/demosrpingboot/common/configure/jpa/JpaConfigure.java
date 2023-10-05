package com.cybersoft.demosrpingboot.common.configure.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfigure {

    @Bean
    public AuditorAware<String> auditorProvider(){
        return new AuditorAwareImp();
    }

}
