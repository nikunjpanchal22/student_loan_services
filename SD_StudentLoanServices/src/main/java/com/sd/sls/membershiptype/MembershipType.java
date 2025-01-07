package com.sd.sls.membershiptype;

/*
 * @Author: Ranatosh Sarkar
 */

public enum MembershipType {
	REGULAR("R"),
	SILVER("S"),
	GOLD("G");
	
	private final String membershipType;
	
	MembershipType(String membershipType) {
		this.membershipType = membershipType;
	}
	
	public String getMembershipType()
	{
		return membershipType;
	}
}
