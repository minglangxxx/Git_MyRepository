package com.mybatis_demo.pojo;

import java.io.Serializable;
/**
 * 	Serializableʵ�ֽӿ�������л��ͷ����л�
 * @author 33452
 *
 */
public class QueryVo implements Serializable{

	/**
	 * 	��װpojo���ԭ������Ϊʵ�����ù����У���ѯ�����Ǽ򵥵ĵ����ѯ
	 * 	һ��Query���װ����pojo�࣬�Ϳ���ͬʱʹ�ü���pojo�������ֵ��ѯ
	 * 	��Ȼ������ֻ����һ�����Ӳ�ѯ
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private int userID;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "QueryVo [user=" + user + ", userID=" + userID + "]";
	}

}
