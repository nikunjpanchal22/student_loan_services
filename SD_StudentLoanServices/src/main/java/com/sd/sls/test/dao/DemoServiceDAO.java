package com.sd.sls.test.dao;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DemoServiceDAO implements IDemoServiceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Boolean testMethod() {
		String query = "Select first_name from employee";
		try
		{
			List<String> res = jdbcTemplate.queryForList(query, String.class);
			for (String string : res) {
				System.out.println(res + "------");
			}
			return true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

}
