package com.sd.sls.loanapplication.bs;

import java.util.List;
import java.util.Map;

import com.sd.sls.loanapplication.model.LoanApplication;

public interface ILoanApplicationBS {
	public Map<String, Object> submitApplication (Map<String, Object> userValues);
	
	public Long getApplicationId (String email);
	
	public String updateApplication(Map<String, Object> userValues);
	
	public String withdrawApplication (Map<String, Object> userValues);
	
	public List<LoanApplication> getApprovedApplications ();
	
// Assign Application	
	public Map<String, Boolean> assignApplication(Map<String, Object> userValues);
	
// 	Get all the Applications
	public List<LoanApplication> getAllLoanApplications();	
	
//Approve the Application
	public String approveApplication (Map<String, Object> userValues);
	
//Reject the Application
	public String rejectApplication (Map<String, Object> userValues);
}
