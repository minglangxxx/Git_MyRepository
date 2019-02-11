package com.spring_day3.tx_Dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AcountDaoImpl extends JdbcDaoSupport implements AcountDao {

	@Override
	public void increaseMoney(int id, double money) {
		super.getJdbcTemplate().update("update springdemo_acount set money = money+? where id = ?", money,id);
	}

	@Override
	public void decreaseMoney(int id, double money) {
		super.getJdbcTemplate().update("update springdemo_acount set money = money-? where id = ?", money,id);
	}

}
