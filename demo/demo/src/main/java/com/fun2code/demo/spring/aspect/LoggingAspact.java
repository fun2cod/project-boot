package com.fun2code.demo.spring.aspect;



import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspact {
//setup logger
	private Logger logger=Logger.getLogger(getClass().getName());
	//setup pointcut declaration
	@Pointcut("execution(* com.fun2code.demo.spring.PersonController.*.*(..))")
	private void forcontroller() {}
	@Pointcut("execution(* com.fun2code.demo.spring.repository.*.*(..))")
	private void forRepository() {}
	@Pointcut("forcontroller()||forRepository() ")
	private void forAppFlow() {	}
	//add before
	@Before("forAppFlow()")
	private void before(JoinPoint thej) {
		String m=thej.getSignature().toShortString();
		logger.info("====> in @before:calling methode" +m);
		Object[] args=thej.getArgs();
		for (Object tempArg:args) {
			logger.info("===> argument:" +tempArg);
		}
	}
	//add afterreturning
	@AfterReturning(pointcut="forAppFlow()",returning="re")
	private void after(JoinPoint thej, Object re) {
		String m=thej.getSignature().toShortString();
		logger.info("====> in @before:calling methode" +m);
	
			logger.info("===> argument:" +re);
	}
}
