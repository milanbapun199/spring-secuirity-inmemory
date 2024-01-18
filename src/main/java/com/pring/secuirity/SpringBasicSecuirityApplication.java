package com.pring.secuirity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBasicSecuirityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicSecuirityApplication.class, args);
	}

}
