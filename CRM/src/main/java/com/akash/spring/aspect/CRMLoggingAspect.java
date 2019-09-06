package com.akash.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger=Logger.getLogger(getClass().getName());
	//setup pointcut expression
	@Pointcut("execution(* com.akash.spring.service.*.*(..))")
	private void forServicePackage(){}
	@Pointcut("execution(* com.akash.spring.controller.*.*(..))")
	private void forControllerPackage(){}
	@Pointcut("execution(* com.akash.spring.dao.*.*(..))")
	private void forDaoPackage(){}
	@Pointcut("execution(* com.akash.spring.entity.*.*(..))")
	private void forEntityPackage(){}
	
	@Pointcut("forEntityPackage()||forDaoPackage()||forServicePackage()||forControllerPackage()")
	private void forAppFlow(){}
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint)
	{
		// display method we are calling
		String method =joinPoint.getSignature().toShortString();
		myLogger.info("=========> in @Befor: callin method:  "+method);
		//display the arguments to the method
		
		
	}
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint join, Object result)
	{
		//display method we are returning from
		String method=join.getSignature().toShortString();
		myLogger.info("=======>> in after returning method: "+ method);
		
		//display data returned
		myLogger.info("===========>> result: "+result);
		
		
	}
	

}
