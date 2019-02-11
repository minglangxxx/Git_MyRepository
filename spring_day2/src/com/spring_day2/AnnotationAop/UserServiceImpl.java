package com.spring_day2.AnnotationAop;

import org.springframework.stereotype.Component;

/**
 * 目标对象类
 * @author 33452
 *
 */
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("保存用户");
		int i = 1/0;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("删除用户");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("更新用户");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("查找用户");
	}

}
