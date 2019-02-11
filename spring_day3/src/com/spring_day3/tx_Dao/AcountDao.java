package com.spring_day3.tx_Dao;

public interface AcountDao {
	void increaseMoney(int id,double money);
	void decreaseMoney(int id,double money);
}
