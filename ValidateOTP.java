package com.aop.advice.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class ValidateOTP {

	@Before("execution(public void login())") //@Before("execution(* *(int,int))") //execute in ascending order of advice method name(if 1 aspect and multiple advice) or aspect method name (if 2+ aspects)
	public void generateOTP()
	{
		System.out.println("OTP generated, please check");
	}
	
	@After("execution(public void login())")
	public void verifyOTP()//verifyOTP(Joinpoint jp) //here you can use jp.something
	{
		System.out.println("OTP is correct");
	}
	
	//general advice which calls other advice
	@Pointcut("execution(* *(int,int))")
	public void pointcut()
	{
		System.out.println("Pointcut");
	}
}
