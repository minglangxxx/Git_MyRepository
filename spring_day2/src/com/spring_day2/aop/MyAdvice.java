package com.spring_day2.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 通知类
 * @author 33452
 *
 */
public class MyAdvice {
/**
 * 	前置通知							|-目标方法运行之前调用
 * 	后置通知（如果出现异常，不会调用）		|-目标方法运行之后调用
 * 	环绕通知							|-目标方法运行之前和之后都调用
 * 	异常拦截通知						|-目标方法出现异常调用
 * 	后置通知（无论是否出现异常，都会调用）	|-目标方法运行之后调用
 */
	
	//前置通知
	public void before() {
		System.out.println("前置通知");
	}
	
	//后置通知
	public void afterNoExceptionReturning() {
		System.out.println("后置通知(方法出现异常，不会调用)");
	}
	
	//环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕通知之前的部分");
		Object proceed = pjp.proceed();//这是调用目标方法代码，不要问，记住，我不知道为啥
		System.out.println("环绕通知之后的部分");
		return proceed;
	}
	
	//异常通知
	public void afterException() {
		System.out.println("异常通知");
	}
	
	//后置通知
	public void afterAnythingReturning() {
		System.out.println("后置通知(方法出现异常，也会调用)");
	}
}
