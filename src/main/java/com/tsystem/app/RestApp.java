package com.tsystem.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.tsystem.*")
public class RestApp {

	public static void main(String[] args) {
		SpringApplication.run(RestApp.class, args);
	}
}
