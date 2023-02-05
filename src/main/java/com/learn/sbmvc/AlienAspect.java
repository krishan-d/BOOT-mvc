package com.learn.sbmvc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AlienAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AlienAspect.class);

	// Before advice...
	@Before("execution(public * com.learn.sbmvc.controller.AlienController.getAliens())")
	public void log() {
		LOGGER.info("getAliens method called...");
	}
	
	// After finally advice... : execute despite exception
//	@After("execution(public * com.learn.sbmvc.controller.AlienController.getAliens())")
	
	// AfterReturning... : will not execute if exception occurs
	@AfterReturning("execution(public * com.learn.sbmvc.controller.AlienController.getAliens())")
	public void logAfter() {
		LOGGER.info("getAliens method executed...");
	}
	
}
