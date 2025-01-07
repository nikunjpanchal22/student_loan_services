package com.sd.sls.test.service;

/*
 * @Author: Abhishek Vishwakarma
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.test.bl.IDemoBL;

@Service
public class DemoService implements IDemoService{
	
	@Autowired
	IDemoBL demoBL;

	@Override
	public Boolean testMethod() {
		return demoBL.testMethod();
	}

}
