package com.example.SpringBoot_Code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCodeApplication.class, args);
	}

}
