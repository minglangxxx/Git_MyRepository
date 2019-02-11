package com.spring_day2.AnnotationAop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 通知类
 * @author 33452
 *
 */
@Component("myAdvice")
@Aspect//注解表明该类是个通知类
public class MyAdvice {
/**
 * 	前置通知							|-目标方法运行之前调用
 * 	后置通知（如果出现异常，不会调用）		|-目标方法运行之后调用
 * 	环绕通知							|-目标方法运行之前和之后都调用
 * 	异常拦截通知						|-目标方法出现异常调用
 * 	后置通知（无论是否出现异常，都会调用）	|-目标方法运行之后调用
 */
	//切入点
	@Pointcut("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void pc() {}
	
	//前置通知
	@Before("MyAdvice.pc()")
	public void before() {
		System.out.println("前置通知");
	}
	
	//后置通知
	@AfterReturning("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterNoExceptionReturning() {
		System.out.println("后置通知(方法出现异常，不会调用)");
	}
	
	//环绕通知
	@Around("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知之前的部分");
		Object proceed = pjp.proceed();//这是调用目标方法代码，不要问，记住，我不知道为啥
		System.out.println("环绕通知之后的部分");
		return proceed;
	}
	
	//异常通知
	@AfterThrowing("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterException() {
		System.out.println("异常通知");
	}
	
	//后置通知
	@After("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterAnythingReturning() {
		System.out.println("后置通知(方法出现异常，也会调用)");
	}
}
