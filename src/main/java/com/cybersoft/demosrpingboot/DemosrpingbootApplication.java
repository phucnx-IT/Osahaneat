package com.cybersoft.demosrpingboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DemosrpingbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosrpingbootApplication.class, args);
	}

}
