package com.sd.sls.user.bl;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sd.sls.user.constants.UserConstants;
import com.sd.sls.user.dao.IUserDAO;
import com.sd.sls.user.model.User;

@Service
public class UserBusinessLogic implements IUserBusinessLogic {

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Map<String, Boolean> registerUser(Map<String, Object> userValues) 
	{
		Map<String, Boolean> returnMap = new HashMap<>();
		User user = createUser(userValues);
		if (checkIfUserAlreadyExists(user)) 
		{
			returnMap.put(UserConstants.USER_ALREADY_REGISTERED, true);
			return returnMap;
		}

		if (userDAO.registerUser(user) == 1) 
		{
			returnMap.put(UserConstants.USER_REGISTERED, true);
		}
		return returnMap;
	}

	@Override
	public boolean loginUser(String email, String password) 
	{
		User user = findUserByEmail(email);
		return user != null && passwordEncoder.matches(password, user.getPassword());
	}

	@Override
	public Map<String, Boolean> updateprofile(Map<String, Object> userValues) 
	{
		Map<String, Boolean> returnMap = new HashMap<>();
		User user = createUser(userValues);
		user.setUserId(Integer.valueOf(Objects.toString(userValues.get(UserConstants.USER_ID))));
		int updateUser = userDAO.updateprofile(user);
		if(updateUser == 1)
		{
			returnMap.put(UserConstants.USER_UPDATED_SUCCESSFULLY, true);
			return returnMap;
		}
		returnMap.put(UserConstants.USER_UPDATION_FAILED, false);
		
		return returnMap;
	}
	
	@Override
	public User findUserByEmail(String email)
	{
		return userDAO.findUserByEmail(email);
	}

	@Override
	public User createUser(Map<String, Object> userValues) 
	{
		User user = new User();
		user.setUserName(userValues.get(UserConstants.USERNAME) == null ? null : Objects.toString(userValues.get(UserConstants.USERNAME)));
		user.setEmail(userValues.get(UserConstants.EMAIL) == null ? null : Objects.toString(userValues.get(UserConstants.EMAIL)));
		user.setPassword(userValues.get(UserConstants.PASSWORD) == null ? null : passwordEncoder.encode(Objects.toString(userValues.get(UserConstants.PASSWORD))));
		user.setPhoneNumber(userValues.get(UserConstants.PHONE_NUMBER) == null ? null : Long.valueOf(Objects.toString(userValues.get(UserConstants.PHONE_NUMBER))));
		return user;
	}

	private boolean checkIfUserAlreadyExists(User user) 
	{
		return userDAO.checkIfUserAlreadyExists(user);
	}
}
