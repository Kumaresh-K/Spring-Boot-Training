package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ValidationTestApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext ctx =  SpringApplication.run(ValidationTestApplication.class, args);
	}

}
