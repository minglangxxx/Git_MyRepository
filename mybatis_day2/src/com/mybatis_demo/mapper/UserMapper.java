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

	/**
	 *	 ����Mapper���ĸ�ԭ��
	 *	1.*Mapper.xml�ļ���namespaceҪ��Mapper�ӿڵ���·�����˴����Ƿ���ֵ����ͬ��Ҳ���������ռ�Ҫ������ӿ�
	 *	2.*Mapper.xml�ж����ÿ��statement��idҪ��Mapper�ӿڷ�������ͬ
	 *	3.*Mapper.xml�ж����ÿ��sql������ֵ����parameterTypeҪ��Mapper�ӿڷ������������������ͬ
	 *	4.*Mapper.xml�ж����ÿ��sql�ķ���ֵ����resultTypeҪ��Mapper�ӿڷ������������������ͬ
	 */
	
	//����id��ѯ
	public User findUserById(Integer id);

	//��װpojo��ѯ
	public List<User> findUserByQueryVo(QueryVo vo);
	public List<QueryVo> findQueryByID(QueryVo vo);
	
	//���ؼ���������
	public Integer getCountUser();
	
	//����ʹ��resultMap����ӳ���ѯ
	public List<Orders> selectOrdersList();
	
	//һ��һ���������ϲ�ѯ,����Ϊ����
	public List<Orders> selectOrders();
	
	//һ�Զ����ϲ�ѯ,�û�Ϊ����
	public List<User> selectUserList();
}
