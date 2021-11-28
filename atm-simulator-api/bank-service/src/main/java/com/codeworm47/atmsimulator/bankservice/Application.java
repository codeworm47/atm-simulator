package com.codeworm47.atmsimulator.bankservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/*
Disabling default security configuration
Since I already registered custom security configuration -> SecurityConfiguration (config/security/SecurityConfiguration.java)
 */

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
