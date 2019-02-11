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
 * 	该注解Component("user")等同于<bean name="user" class="com.spring_day2.demo.User" />
 *	Component把该类作为对象配置到xml配置文件中（spring容器中），括号中的参数指定放在spring容器中的对象名
 */
@Component("user")

/*	这三种是后来出现的三种注解，我目前还没学到有什么特别的功能，总之和Component一样可以注册到spring容器中，但是后面
 * 	这三种的分层思想更加清晰，看起来更明白
 *  @Service("user")//service层
	@Controller("user")//web层
	@Repository("user")//dao层
*/

@Scope(scopeName="singleton")//注解设置单例或者多例，默认为单例模式scopeName="singleton|prototype"

public class User {

	@Value("tom")
	private String name;
	@Value(value="18")//完整注解模式。但当注解的属性只有一个需要赋值，并且属性值是value，可以省略键。类似@Value("tom")
	private int age;
	
/*	@Autowired//自动装配。注解对象赋值时，需要先将对象注解到spring容器中，然后在需要注解对象的地方@Autowired。但是万一有很多car的对象呢
	@Qualifier("car2")//使用@Qualifier指定选择哪一个car的name就好了
*/	
	//对象注解推荐手动注解指名道姓@Resource
	@Resource(name="car2")//手动注解。手动选择，不想上面还需要两个。直接选定需要注解的name
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
	
	@PostConstruct//在对象被初始化之后调用	init-method
	public void init() {
		System.out.println("初始化");
	}
	@PreDestroy//在对象销毁之前调用		destroy-method
	public void destory() {
		System.out.println("销毁");
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
