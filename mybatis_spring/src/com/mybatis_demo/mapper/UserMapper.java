package com.mybatis_demo.mapper;

import java.util.List;

import com.mybatis_demo.pojo.Orders;
import com.mybatis_demo.pojo.QueryVo;
import com.mybatis_demo.pojo.User;

/**
 * 	Mapper接口相当于Dao接口，由MyBatis框架根据接口定义创建接口的动态代理对象
 * @author 33452
 *
 */
public interface UserMapper {

	//根据id查询
	public User queryUserById(int id);
	public int CountUser();
}
