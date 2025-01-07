package com.sd.sls.user.dao;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sd.sls.constants.ISQLStatements;
import com.sd.sls.user.model.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int registerUser(User user) {
		return jdbcTemplate.update(ISQLStatements.REGISTER_USER,
				new Object[] { user.getUserName(), user.getEmail(), user.getPassword(), user.getPhoneNumber() });
	}

	@Override
	public boolean checkIfUserAlreadyExists(User user) {
		return jdbcTemplate.query(ISQLStatements.CHECK_USER, new BeanPropertyRowMapper<>(User.class),
				new Object[] { user.getUserName(), user.getEmail(), user.getPhoneNumber() }).size() > 0 ? true : false;
	}

	@Override
	public User findUserByEmail(String email) {
		List<User> userList = jdbcTemplate.query(ISQLStatements.FIND_USER_BY_EMAIL,
				new BeanPropertyRowMapper<>(User.class), email);
		return userList.size() > 0 ? userList.get(0) : null;
	}
	
	@Override
	public User findUserForNotification(String message)
	{
		List<User> userList = jdbcTemplate.query(ISQLStatements.GET_USER_FOR_NOTIFICATION, new BeanPropertyRowMapper<>(User.class), new Object[] {message});
		return userList.size() > 0 ? userList.get(0) : null;
	}
	
	@Override
	public User findUserForBankRepresentative(int employeeId)
	{
		List<User> userList = jdbcTemplate.query(ISQLStatements.GET_ALL_USER_FROM_BANK_REPRESENTATIVE, new BeanPropertyRowMapper<>(User.class), new Object[] {employeeId});
		return userList.size() > 0 ? userList.get(0) : null;
	}
	
	@Override
	public User findUserForBankAdmin(int adminId)
	{
		List<User> userList = jdbcTemplate.query(ISQLStatements.GET_USER_FOR_BANK_ADMIN, new BeanPropertyRowMapper<>(User.class), new Object[] {adminId});
		return userList.size() > 0 ? userList.get(0) : null;
	}

	@Override
	public int updateprofile(User user) {
		return jdbcTemplate.update(buildUpdateQuery(user), user.getUserId());
	}

	private String buildUpdateQuery(User user) {
		boolean first = true;
		StringBuffer updateQuery = new StringBuffer(ISQLStatements.UPDATE_USER_PROFILE);
		if (user.getEmail() != null) {
			updateQuery.append("EMAIL = '").append(user.getEmail()).append("'");
			first = false;
		}
		
		if (user.getPassword() != null) {
			if (!first) {
				updateQuery.append(", ");
			}
			updateQuery.append("PASSWORD = '").append(user.getPassword()).append("'");
			first = false;
		}

		if (user.getUserName() != null) {
			if (!first) {
				updateQuery.append(", ");
			}
			updateQuery.append("USER_NAME = '").append(user.getUserName()).append("'");
			first = false;
		}

		if (user.getPhoneNumber() != null) {
			if (!first) {
				updateQuery.append(", ");
			}
			updateQuery.append("PHONE_NUMBER = '").append(user.getPhoneNumber()).append("'");
		}

		updateQuery.append(" WHERE USER_ID = ?");
		return updateQuery.toString();
	}
}
