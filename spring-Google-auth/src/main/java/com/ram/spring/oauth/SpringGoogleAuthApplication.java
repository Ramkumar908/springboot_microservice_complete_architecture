package com.ram.spring.oauth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringGoogleAuthApplication {

	@GetMapping
	public String myGoogle()
	{
		return "Welcome to google";
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal principal)
	{
		System.out.println("username : "+principal.getName());
		return principal;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringGoogleAuthApplication.class, args);
	}

}
