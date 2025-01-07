package com.sd.sls.guarantor.model;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.io.Serializable;

import com.sd.sls.applicant.model.Applicant;
import com.sd.sls.loanapplication.model.LoanApplication;

public class Guarantor implements Serializable 
{
	private int guarantorId;
	
	private Applicant applicant;
	
	private LoanApplication application;
	
	private String name;
	
	private String relationShip;
	
	private String occupation;
	
	private Long annualIncome;
	
	private String address;
	
	private String uinNo;
	
	private Long monthlyExpense;
	
	public Guarantor() {
		// TODO Auto-generated constructor stub
	}

	public Guarantor(int guarantorId, Applicant applicant, LoanApplication application, String name,
			String relationShip, String occupation, Long annualIncome, String address, String uinNo,
			Long monthlyExpense) {
		super();
		this.guarantorId = guarantorId;
		this.applicant = applicant;
		this.application = application;
		this.name = name;
		this.relationShip = relationShip;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.address = address;
		this.uinNo = uinNo;
		this.monthlyExpense = monthlyExpense;
	}

	public int getGuarantorId() {
		return guarantorId;
	}

	public void setGuarantorId(int guarantorId) {
		this.guarantorId = guarantorId;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public LoanApplication getApplication() {
		return application;
	}

	public void setApplication(LoanApplication application) {
		this.application = application;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUinNo() {
		return uinNo;
	}

	public void setUinNo(String uinNo) {
		this.uinNo = uinNo;
	}

	public Long getMonthlyExpense() {
		return monthlyExpense;
	}

	public void setMonthlyExpense(Long monthlyExpense) {
		this.monthlyExpense = monthlyExpense;
	}

	@Override
	public String toString() {
		return "Guarantor [guarantorId=" + guarantorId + ", applicant=" + applicant + ", application=" + application
				+ ", name=" + name + ", relationShip=" + relationShip + ", occupation=" + occupation + ", annualIncome="
				+ annualIncome + ", address=" + address + ", uinNo=" + uinNo + ", monthlyExpense=" + monthlyExpense
				+ "]";
	} 
}
