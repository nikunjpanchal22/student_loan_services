package com.sd.sls.loanapplication.model;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.io.Serializable;
import java.sql.Date;

import com.sd.sls.applicant.model.Applicant;
import com.sd.sls.guarantor.model.Guarantor;

public class LoanApplication implements Serializable 
{
	private int applicationId;
	
	private Applicant applicant;
	
	private Guarantor guarantor;
	
	private Date applicationDate;
	
	private String status;
	
	private Long loanAmount;
	
	private String purpose;
	
	//This object could be of Bank Representative or Bank Admin depending on the status of the application
	private Object assigneId;
	
	public LoanApplication() {
		// TODO Auto-generated constructor stub
	}

	public LoanApplication(int applicationId, Applicant applicant, Guarantor guarantor, Date applicationDate,
			String status, Long loanAmount, String purpose, Object assigneId) {
		super();
		this.applicationId = applicationId;
		this.applicant = applicant;
		this.guarantor = guarantor;
		this.applicationDate = applicationDate;
		this.status = status;
		this.loanAmount = loanAmount;
		this.purpose = purpose;
		this.assigneId = assigneId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Guarantor getGuarantor() {
		return guarantor;
	}

	public void setGuarantor(Guarantor guarantor) {
		this.guarantor = guarantor;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Object getAssigneId() {
		return assigneId;
	}

	public void setAssigneId(Object assigneId) {
		this.assigneId = assigneId;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicant=" + applicant + ", guarantor="
				+ guarantor + ", applicationDate=" + applicationDate + ", status=" + status + ", loanAmount="
				+ loanAmount + ", purpose=" + purpose + ", assigneId=" + assigneId + "]";
	}
}