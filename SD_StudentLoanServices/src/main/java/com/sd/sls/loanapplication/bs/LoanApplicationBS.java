package com.sd.sls.loanapplication.bs;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.List;
import java.util.Map;

import com.sd.sls.loanapplication.bl.ILoanApplicationBL;
import com.sd.sls.loanapplication.model.LoanApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationBS implements ILoanApplicationBS 
{
	@Autowired
	private ILoanApplicationBL loanApplicationBL;
	
	@Override
	public Map<String, Object> submitApplication(Map<String, Object> userValues) 
	{
		return loanApplicationBL.submitApplication(userValues);
	}

	@Override
	public Long getApplicationId (String email)
	{
		return loanApplicationBL.getApplicationId(email);
	}
	
	@Override
	public String updateApplication(Map<String, Object> userValues)
	{
		return loanApplicationBL.updateApplication(userValues);
	}

	@Override
	public String withdrawApplication (Map<String, Object> userValues)
	{
		return loanApplicationBL.withdrawApplication(userValues);
	}
	
	@Override
	public List<LoanApplication> getApprovedApplications() {
		return loanApplicationBL.getApprovedApplications();
	}
	
// Assign Application 	
	@Override
	public Map<String, Boolean> assignApplication(Map<String, Object> userValues) 
	{
		return loanApplicationBL.assignApplication(userValues);
	}
	
// Get all Loan Applications
	@Override
	public List<LoanApplication> getAllLoanApplications() {
		return loanApplicationBL.getAllLoanApplications();
	}
	
// Approve Loan Application
	@Override
	public String approveApplication (Map<String, Object> userValues)
	{
		return loanApplicationBL.approveApplication(userValues);
	}
		
// Reject Loan Application
	@Override
	public String rejectApplication (Map<String, Object> userValues)
	{
		return loanApplicationBL.rejectApplication(userValues);
	}
}
