package com.sd.sls.loanapplication.dao;

import java.util.List;
import java.util.Map;

import com.sd.sls.loanapplication.model.LoanApplication;

public interface ILoanApplicationDAO {
	public int submitApplication (LoanApplication loanApplication);
	
	public boolean checkIfLoanExistWithApplicant(LoanApplication loanApplication);
	
	public LoanApplication getLoanApplication(int applicantName, Long loanAmount);
	
	public LoanApplication getApplicationId (String name);
	
	public int updateApplication (LoanApplication application);
	
	public int withdrawApplication (int applicationId);

	public List<LoanApplication> getApprovedApplications();
	
	public int assignApplication(Map<String, Object> userValues);
	
// Get all the Loan Applications	
	public List<LoanApplication> getAllLoanApplications();
			
// Get Loan Application By Id
	public LoanApplication getApplicationById (int applicationId);		
	
// Approve Application
	public int approveApplication(int applicationId);
		
// Reject Application
	public int rejectApplication(int applicationId);
	
// Change the Application Status to Under Review
	public int underReviewApplication(int applicationId);

	public int sanctionLoanApplication(int applicationId);

	public int disburseLoanApplication(int applicationId);
}
