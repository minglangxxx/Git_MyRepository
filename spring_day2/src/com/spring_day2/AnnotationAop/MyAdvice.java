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
 * ֪ͨ��
 * @author 33452
 *
 */
@Component("myAdvice")
@Aspect//ע����������Ǹ�֪ͨ��
public class MyAdvice {
/**
 * 	ǰ��֪ͨ							|-Ŀ�귽������֮ǰ����
 * 	����֪ͨ����������쳣��������ã�		|-Ŀ�귽������֮�����
 * 	����֪ͨ							|-Ŀ�귽������֮ǰ��֮�󶼵���
 * 	�쳣����֪ͨ						|-Ŀ�귽�������쳣����
 * 	����֪ͨ�������Ƿ�����쳣��������ã�	|-Ŀ�귽������֮�����
 */
	//�����
	@Pointcut("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void pc() {}
	
	//ǰ��֪ͨ
	@Before("MyAdvice.pc()")
	public void before() {
		System.out.println("ǰ��֪ͨ");
	}
	
	//����֪ͨ
	@AfterReturning("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterNoExceptionReturning() {
		System.out.println("����֪ͨ(���������쳣���������)");
	}
	
	//����֪ͨ
	@Around("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("����֪֮ͨǰ�Ĳ���");
		Object proceed = pjp.proceed();//���ǵ���Ŀ�귽�����룬��Ҫ�ʣ���ס���Ҳ�֪��Ϊɶ
		System.out.println("����֪֮ͨ��Ĳ���");
		return proceed;
	}
	
	//�쳣֪ͨ
	@AfterThrowing("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterException() {
		System.out.println("�쳣֪ͨ");
	}
	
	//����֪ͨ
	@After("execution(* com.spring_day2.AnnotationAop.*ServiceImpl.*(..))")
	public void afterAnythingReturning() {
		System.out.println("����֪ͨ(���������쳣��Ҳ�����)");
	}
}
