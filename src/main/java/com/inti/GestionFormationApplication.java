package com.inti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionFormationApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionFormationApplication.class, args);
	}
	
	//Leopold
	
	@Bean
	public BCryptPasswordEncoder  passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
