package com.springdemo.d_inject;

public class User {

	private String name;
	private int age;
	private Car car;
	public User() {
		super();
		System.out.println("空参构造方法");
	}
	
	public User(String name, Car car) {
		super();
		this.name = name;
		this.car = car;
		System.out.println("有参构造函数-正");
	}
	
	public User(Integer name, Car car) {
		super();
		this.name = name+"";
		this.car = car;
		System.out.println("有参构造函数-异");
	}

	public User(Car car, String name) {
		super();
		this.name = name;
		this.car = car;
		System.out.println("有参构造函数-反");
	}
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
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}
}
