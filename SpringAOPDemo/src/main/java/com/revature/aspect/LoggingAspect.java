package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut="within(com.revature.service.*)")
	public void logAfterReturn(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterThrowing(pointcut="within(*)", throwing="t")
	public void logAfterThrow(JoinPoint jp, Throwable t) {
		log.error(jp.getSignature()+" threw "+t.getClass()+" with message "+t.getMessage());
	}


	

}
