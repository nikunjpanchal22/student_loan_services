package com.sd.sls.externaldb.dao;

import java.time.Year;

/*
 * Author: Rushabh Botadra
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sd.sls.constants.ISQLStatements;
import com.sd.sls.externaldb.model.ExternalDb;

@Repository
public class ExternalDbDAO implements IExternalDbDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean checkItrForBusiness(String uinNo)
	{
		List<ExternalDb> itrList = jdbcTemplate.query(ISQLStatements.GET_ITR_FOR_BUSINESS, new BeanPropertyRowMapper<>(ExternalDb.class), new Object[] {uinNo, Year.now().getValue() - 2, Year.now().getValue()});
		return 	itrList.size() > 0 ? true: false;
	}
	
	@Override
	public boolean checkItrForSalaried(String uinNo)
	{		
		List<ExternalDb> itrList = jdbcTemplate.query(ISQLStatements.GET_ITR_FOR_SALARIED, new BeanPropertyRowMapper<>(ExternalDb.class), new Object[] {uinNo});
		return itrList.size() > 0 ? true : false;
	}
}
