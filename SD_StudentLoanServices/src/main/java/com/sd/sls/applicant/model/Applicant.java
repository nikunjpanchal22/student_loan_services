package com.sd.sls.applicant.model;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.io.Serializable;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.sql.Date;

import com.sd.sls.user.model.User;

public class Applicant implements Serializable  
{	
	private int applicantId;
	
	private User user;
	
	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String address;
	
	private String educationDetails;
	
	private String membershipType;
	
	private String email;
	
	public Applicant() {
		// TODO Auto-generated constructor stub
	}

	public Applicant(int applicantId, User user, String firstName, String lastName, Date dateOfBirth, String address,
			String educationDetails, String membershipType, String email) {
		super();
		this.applicantId = applicantId;
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.educationDetails = educationDetails;
		this.membershipType = membershipType;
		this.email = email;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(String educationDetails) {
		this.educationDetails = educationDetails;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", user=" + user + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", educationDetails="
				+ educationDetails + ", membershipType=" + membershipType + ", email=" + email + "]";
	}
}
