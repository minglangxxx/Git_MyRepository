package com.spring_day2.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 33452
 * 	��ע��Component("user")��ͬ��<bean name="user" class="com.spring_day2.demo.User" />
 *	Component�Ѹ�����Ϊ�������õ�xml�����ļ��У�spring�����У��������еĲ���ָ������spring�����еĶ�����
 */
@Component("user")

/*	�������Ǻ������ֵ�����ע�⣬��Ŀǰ��ûѧ����ʲô�ر�Ĺ��ܣ���֮��Componentһ������ע�ᵽspring�����У����Ǻ���
 * 	�����ֵķֲ�˼�����������������������
 *  @Service("user")//service��
	@Controller("user")//web��
	@Repository("user")//dao��
*/

@Scope(scopeName="singleton")//ע�����õ������߶�����Ĭ��Ϊ����ģʽscopeName="singleton|prototype"

public class User {

	@Value("tom")
	private String name;
	@Value(value="18")//����ע��ģʽ������ע�������ֻ��һ����Ҫ��ֵ����������ֵ��value������ʡ�Լ�������@Value("tom")
	private int age;
	
/*	@Autowired//�Զ�װ�䡣ע�����ֵʱ����Ҫ�Ƚ�����ע�⵽spring�����У�Ȼ������Ҫע�����ĵط�@Autowired��������һ�кܶ�car�Ķ�����
	@Qualifier("car2")//ʹ��@Qualifierָ��ѡ����һ��car��name�ͺ���
*/	
	//����ע���Ƽ��ֶ�ע��ָ������@Resource
	@Resource(name="car2")//�ֶ�ע�⡣�ֶ�ѡ�񣬲������滹��Ҫ������ֱ��ѡ����Ҫע���name
	private Car car;
	
	
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	
	@PostConstruct//�ڶ��󱻳�ʼ��֮�����	init-method
	public void init() {
		System.out.println("��ʼ��");
	}
	@PreDestroy//�ڶ�������֮ǰ����		destroy-method
	public void destory() {
		System.out.println("����");
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
