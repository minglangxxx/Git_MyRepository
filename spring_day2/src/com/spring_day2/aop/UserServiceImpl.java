package com.spring_day2.aop;

/**
 * Ŀ�������
 * @author 33452
 *
 */
public class UserServiceImpl implements UserService {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("�����û�");
		int i = 1/0;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("ɾ���û�");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("�����û�");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("�����û�");
	}

}
