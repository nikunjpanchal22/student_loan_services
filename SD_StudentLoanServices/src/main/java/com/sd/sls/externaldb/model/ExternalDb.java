package com.sd.sls.externaldb.model;

/*
 * Author: Rushabh Botadra
 */
import java.io.Serializable;
import java.sql.Date;


public class ExternalDb implements Serializable
{
	private String uinNo;
	
	private String itrNo;
	
	private String occupation;
	
	private Long annualIncome;
	
	private Date salaryReceivedDate;
	
	private int creditScore;
	
	private Double repoRate;
	
	private int itrYear;
	
	public ExternalDb() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ExternalDb(String uinNo, String itrNo, String occupation, Long annualIncome, Date salaryReceivedDate,
			int creditScore, Double repoRate, int itrYear) {
		super();
		this.uinNo = uinNo;
		this.itrNo = itrNo;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.salaryReceivedDate = salaryReceivedDate;
		this.creditScore = creditScore;
		this.repoRate = repoRate;
		this.itrYear = itrYear;
	}

	

	public String getUinNo() {
		return uinNo;
	}


	public void setUinNo(String uinNo) {
		this.uinNo = uinNo;
	}


	public String getItrNo() {
		return itrNo;
	}


	public void setItrNo(String itrNo) {
		this.itrNo = itrNo;
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


	public Date getSalaryReceivedDate() {
		return salaryReceivedDate;
	}


	public void setSalaryReceivedDate(Date salaryReceivedDate) {
		this.salaryReceivedDate = salaryReceivedDate;
	}


	public int getCreditScore() {
		return creditScore;
	}


	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}


	public Double getRepoRate() {
		return repoRate;
	}


	public void setRepoRate(Double repoRate) {
		this.repoRate = repoRate;
	}


	public int getItrYear() {
		return itrYear;
	}


	public void setItrYear(int itrYear) {
		this.itrYear = itrYear;
	}


	@Override
	public String toString() {
		return "ExternalDb [uinNo=" + uinNo + ", itrNo=" + itrNo + ", occupation=" + occupation + ", annualIncome="
				+ annualIncome + ", salaryReceivedDate=" + salaryReceivedDate + ", creditScore=" + creditScore
				+ ", repoRate=" + repoRate + ", itrYear=" + itrYear + "]";
	}
	
	
}
