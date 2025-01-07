package com.sd.sls.user.bl;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.Map;

import com.sd.sls.user.model.User;

public interface IUserBusinessLogic {
	public Map<String, Boolean> registerUser(Map<String, Object> userValues);

	public boolean loginUser(String email, String password);
	
	public Map<String, Boolean> updateprofile(Map<String, Object> userValues);
	
	public User findUserByEmail(String email);
	
	public User createUser(Map<String, Object> userValues);
	
}
