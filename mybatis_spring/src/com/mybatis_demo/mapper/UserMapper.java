package com.mybatis_demo.mapper;

import java.util.List;

import com.mybatis_demo.pojo.Orders;
import com.mybatis_demo.pojo.QueryVo;
import com.mybatis_demo.pojo.User;

/**
 * 	Mapper�ӿ��൱��Dao�ӿڣ���MyBatis��ܸ��ݽӿڶ��崴���ӿڵĶ�̬�������
 * @author 33452
 *
 */
public interface UserMapper {

	//����id��ѯ
	public User queryUserById(int id);
	public int CountUser();
}
