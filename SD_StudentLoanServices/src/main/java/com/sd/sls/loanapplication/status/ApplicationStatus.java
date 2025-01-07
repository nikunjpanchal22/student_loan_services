package com.sd.sls.loanapplication.status;

/*
 * @Author: Abhishek Vishwakarma
 */

public enum ApplicationStatus {
	DRAFT("DR"), 
	SUBMITTED("S"), 
	UNDER_REVIEW("UR"), 
	APPROVED("A"), 
	REJECTED("R"), 
	WITHDRAWN("WD"), 
	SANCTIONED("S"),
	DISBURSED("D");

	private final String status;

	ApplicationStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
