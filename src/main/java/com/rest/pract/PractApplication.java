package com.rest.pract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@EnableWebMvc
@SpringBootApplication
public class PractApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractApplication.class, args);
	}

}
