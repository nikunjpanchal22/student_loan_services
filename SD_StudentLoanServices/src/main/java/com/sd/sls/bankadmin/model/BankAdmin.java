package com.sd.sls.bankadmin.model;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.user.model.User;
import java.io.Serializable;

public class BankAdmin implements Serializable
{
	private int adminId;
	
	private User user;
	
	private String authorityLevel;
	
	public BankAdmin() {
		// TODO Auto-generated constructor stub
	}

	public BankAdmin(int adminId, User user, String authorityLevel) {
		super();
		this.adminId = adminId;
		this.user = user;
		this.authorityLevel = authorityLevel;
	}

    public int getAdminId() {
        return adminId;
    }

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthorityLevel() {
		return authorityLevel;
	}

	public void setAuthorityLevel(String authorityLevel) {
		this.authorityLevel = authorityLevel;
	}

	@Override
	public String toString() {
		return "BankAdmin [adminId=" + adminId + ", user=" + user + ", authorityLevel=" + authorityLevel + "]";
	}
}
