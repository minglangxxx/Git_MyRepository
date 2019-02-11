package com.mybatis_demo.pojo;

import java.io.Serializable;
/**
 * 	Serializable实现接口完成序列化和反序列化
 * @author 33452
 *
 */
public class QueryVo implements Serializable{

	/**
	 * 	包装pojo类的原因是因为实际运用过程中，查询并不是简单的单表查询
	 * 	一个Query类包装几个pojo类，就可以同时使用几个pojo类的属性值查询
	 * 	当然，这里只用了一个例子查询
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
