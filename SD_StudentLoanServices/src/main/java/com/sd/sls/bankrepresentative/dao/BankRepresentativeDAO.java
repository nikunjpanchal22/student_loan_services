package com.sd.sls.bankrepresentative.dao;

/*
 * Author: Rushabh Botadra
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sd.sls.bankrepresentative.model.BankRepresentative;
import com.sd.sls.constants.ISQLStatements;
import com.sd.sls.user.dao.IUserDAO;

@Repository
public class BankRepresentativeDAO implements IBankRepresentativeDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public List<BankRepresentative> getAllBankRepresentatives()
	{
		List<BankRepresentative> bankRepresentatives = jdbcTemplate.query(ISQLStatements.GET_ALL_BANK_REPRESENTATIVE, new BeanPropertyRowMapper<>(BankRepresentative.class));
		for (BankRepresentative bankRepresentative : bankRepresentatives) {
			bankRepresentative.setUser(userDAO.findUserForBankRepresentative(bankRepresentative.getEmployeeId()));
		}
		return bankRepresentatives.size() > 0 ? bankRepresentatives : null;
	}
	
}
