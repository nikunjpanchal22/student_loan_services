package com.sd.sls.user.dao;

/*
 * @Author: Abhishek Vishwakarma
 */

import com.sd.sls.user.model.User;

public interface IUserDAO {
	public int registerUser(User user);

	public boolean checkIfUserAlreadyExists(User user);

	public User findUserByEmail(String email);
	
	public User findUserForNotification(String message);
	
	public int updateprofile(User user);
	
	public User findUserForBankRepresentative(int employeeId);
	
	public User findUserForBankAdmin(int adminId);
}
