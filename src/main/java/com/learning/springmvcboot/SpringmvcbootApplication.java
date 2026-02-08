package com.learning.springmvcboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringmvcbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcbootApplication.class, args);
	}

}
