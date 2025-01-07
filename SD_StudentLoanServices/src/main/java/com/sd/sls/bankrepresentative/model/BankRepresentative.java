package com.sd.sls.bankrepresentative.model;

import java.io.Serializable;

import com.sd.sls.user.model.User;

/*
 * Author: Rushabh Botadra
 */

public class BankRepresentative implements Serializable
{

	private int employeeId;
	
	private User user;
	
	public BankRepresentative() {
		// TODO Auto-generated constructor stub
	}

	public BankRepresentative(int employeeId, User user) {
		super();
		this.employeeId = employeeId;
		this.user = user;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BankRepresentativeModel [employeeId=" + employeeId + "]";
	}
	
	
	
	
}
