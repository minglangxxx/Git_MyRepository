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

	/**
	 *	 配置Mapper的四个原则
	 *	1.*Mapper.xml文件的namespace要和Mapper接口的类路径（此处就是返回值）相同，也就是命名空间要绑定这个接口
	 *	2.*Mapper.xml中定义的每个statement的id要和Mapper接口方法名相同
	 *	3.*Mapper.xml中定义的每个sql的输入值类型parameterType要和Mapper接口方法的输入参数类型相同
	 *	4.*Mapper.xml中定义的每个sql的返回值类型resultType要和Mapper接口方法的输出参数类型相同
	 */
	
	//根据id查询
	public User findUserById(Integer id);

	//封装pojo查询
	public List<User> findUserByQueryVo(QueryVo vo);
	public List<QueryVo> findQueryByID(QueryVo vo);
	
	//返回简单数据类型
	public Integer getCountUser();
	
	//初次使用resultMap进行映射查询
	public List<Orders> selectOrdersList();
	
	//一对一关联的联合查询,订单为中心
	public List<Orders> selectOrders();
	
	//一对多联合查询,用户为中心
	public List<User> selectUserList();
}
