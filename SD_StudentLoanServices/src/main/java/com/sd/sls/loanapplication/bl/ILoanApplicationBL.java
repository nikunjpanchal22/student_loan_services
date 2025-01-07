package com.sd.sls.loanapplication.bl;

import java.util.List;
import java.util.Map;

import com.sd.sls.loanapplication.model.LoanApplication;

public interface ILoanApplicationBL {
	public Map<String, Object> submitApplication (Map<String, Object> userValues);
	
	public Long getApplicationId (String name);
	
	public String updateApplication(Map<String, Object> userValues);
	
	public String withdrawApplication (Map<String, Object> userValues);
	
	public List<LoanApplication> getApprovedApplications ();
	
//Added the method in the Interface to access it from the Bank RepresentativeBL Class in order to update the application
	public LoanApplication createLoanApplication (Map<String, Object> userValues);
		
	public Map<String, Boolean> assignApplication(Map<String, Object> userValues); 
	
// Get All the Applications		
	public List<LoanApplication> getAllLoanApplications();	
	
// Approve Loan Application
	public String approveApplication (Map<String, Object> userValues);
		
// Reject Loan Application
	public String rejectApplication (Map<String, Object> userValues);
}
