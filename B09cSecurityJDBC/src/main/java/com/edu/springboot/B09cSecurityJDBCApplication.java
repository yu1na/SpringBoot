package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootApplication
public class B09cSecurityJDBCApplication {

	public static void main(String[] args) {
		SpringApplication.run(B09cSecurityJDBCApplication.class, args);
		
//		String passwd = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234");
//		System.out.println(passwd);
	}
}
