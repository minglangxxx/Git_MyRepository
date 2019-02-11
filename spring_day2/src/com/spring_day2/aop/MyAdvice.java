package com.spring_day2.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * ֪ͨ��
 * @author 33452
 *
 */
public class MyAdvice {
/**
 * 	ǰ��֪ͨ							|-Ŀ�귽������֮ǰ����
 * 	����֪ͨ����������쳣��������ã�		|-Ŀ�귽������֮�����
 * 	����֪ͨ							|-Ŀ�귽������֮ǰ��֮�󶼵���
 * 	�쳣����֪ͨ						|-Ŀ�귽�������쳣����
 * 	����֪ͨ�������Ƿ�����쳣��������ã�	|-Ŀ�귽������֮�����
 */
	
	//ǰ��֪ͨ
	public void before() {
		System.out.println("ǰ��֪ͨ");
	}
	
	//����֪ͨ
	public void afterNoExceptionReturning() {
		System.out.println("����֪ͨ(���������쳣���������)");
	}
	
	//����֪ͨ
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("����֪֮ͨǰ�Ĳ���");
		Object proceed = pjp.proceed();//���ǵ���Ŀ�귽�����룬��Ҫ�ʣ���ס���Ҳ�֪��Ϊɶ
		System.out.println("����֪֮ͨ��Ĳ���");
		return proceed;
	}
	
	//�쳣֪ͨ
	public void afterException() {
		System.out.println("�쳣֪ͨ");
	}
	
	//����֪ͨ
	public void afterAnythingReturning() {
		System.out.println("����֪ͨ(���������쳣��Ҳ�����)");
	}
}
