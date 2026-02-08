package com.learning.springmvcboot;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(public * com.learning.springmvcboot.AlienController.getAliens())")
	public void log()
	{
		System.out.println("getAliens method called");
	}
}
