package com.example.demo.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Member;
import com.example.demo.model.Wish;

import javassist.bytecode.SignatureAttribute.MethodSignature;

@Component
@Aspect
public class LogAspect {

	@Autowired(required = false)
	private HttpServletRequest request;

	@Pointcut("execution(* com.example.demo.controller..*(..))")
	public void pointcut() {
		System.out.println("enter pointcut!");
	}
	
	@Pointcut("@annotation(com.example.demo.annotation.CustomAnnotation)")
	public void annotation() {
	}

	@Before("annotation()")
	public void before(JoinPoint joinPoint) {
		System.out.println("=====before advice starts=====");

		System.out.println(request.getRequestURL());
		System.out.println("--------------" + joinPoint.getSignature());
//	        System.out.println("--------------"+joinPoint.getArgs()[0]);
//	        System.out.println(getMethodName(joinPoint));
		Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);

		System.out.println("=====before advice ends=====");
	}

//	    private String getMethodName(JoinPoint joinPoint) {
//	        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//	        return signature.getClass().getName();
//	    }

	@AfterReturning(value = "pointcut()"
			, returning = "member")
	public void after(JoinPoint joinPoint, Member member) {
		System.out.println("--------member--------" + joinPoint.getSignature().getName() + "----------------");
		System.out.println("-------member---------" + member);
	}
	
	@AfterThrowing(value = "pointcut()", throwing="e")
	public void afterThrow(JoinPoint joinPoint ,Exception e) {
	
		System.out.println("*********"+e.getMessage());
	}
	
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj=joinPoint.proceed();
		
		if(obj instanceof Member) {			
			System.out.println("*/*/*/*"+joinPoint.getSignature());
		}else if (obj instanceof Wish) {			
			System.out.println("*/*/*/*"+joinPoint.getSignature());
		}
		return obj;
	}
}
