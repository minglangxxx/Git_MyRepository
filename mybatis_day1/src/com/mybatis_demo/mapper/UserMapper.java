package com.mybatis_demo.mapper;

import java.util.List;


import com.mybatis_demo.pojo.User;

/**
 * 	Mapper�ӿ��൱��Dao�ӿڣ���MyBatis��ܸ��ݽӿڶ��崴���ӿڵĶ�̬�������
 * @author 33452
 *
 */
public interface UserMapper {

	/**
	 *	 ����Mapper���ĸ�ԭ��
	 *	1.*Mapper.xml�ļ���namespaceҪ��Mapper�ӿڵ���·�����˴����Ƿ���ֵ����ͬ��Ҳ���������ռ�Ҫ������ӿ�
	 *	2.*Mapper.xml�ж����ÿ��statement��idҪ��Mapper�ӿڷ�������ͬ
	 *	3.*Mapper.xml�ж����ÿ��sql������ֵ����parameterTypeҪ��Mapper�ӿڷ������������������ͬ
	 *	4.*Mapper.xml�ж����ÿ��sql�ķ���ֵ����resultTypeҪ��Mapper�ӿڷ������������������ͬ
	 */
	
	//����id��ѯ
	public User findUserById(Integer id);

}
