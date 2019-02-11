package com.spring_day3.tx_Service;


import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring_day3.tx_Dao.AcountDao;

public class AcountServiceImpl implements AcountService {


	private AcountDao acountDao;


	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(int from, int to, Double money) {
		//一个用户减少money
		acountDao.decreaseMoney(from, money);
		//int i = 1/0;
		//一个用户增减money
		acountDao.increaseMoney(to, money);
	}

	
	public AcountDao getAcountDao() {
		return acountDao;
	}

	public void setAcountDao(AcountDao acountDao) {
		this.acountDao = acountDao;
	}
	
}
