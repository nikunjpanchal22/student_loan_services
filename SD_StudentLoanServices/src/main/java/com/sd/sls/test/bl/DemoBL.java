package com.sd.sls.test.bl;

/*
 * @Author: Abhishek Vishwakarma
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.test.dao.IDemoServiceDAO;

@Service
public class DemoBL implements IDemoBL {
	
	@Autowired
	IDemoServiceDAO demoServiceDAO;
	
	@Override
	public Boolean testMethod() {
		return demoServiceDAO.testMethod();
	}

}
