package com.sd.sls.applicant.dao;

/*
 * @Author: Abhishek Vishwakarma
 */

import com.sd.sls.applicant.model.Applicant;

public interface IApplicantDAO 
{
	//Added by Ranatosh Sarkar
	public int registerApplicant(Applicant applicant);
	
	//Added by Ranatosh Sarkar
	public int registerApplicantDraft(Applicant applicant);
	
	public boolean checkIfApplicantAlreadyExists(Applicant applicant);
	
	public Applicant getApplicantDetailsByName (String firstName, String lastName);
	
	public Applicant getApplicantDetailsByNameFromDraft (String firstName, String lastName);
	
	public Applicant getApplicantDetailsByUserIdFromDraft (Long userId);
	
	public int deleteApplicantFromDraft(int userId);
	
// Get Applicant By Application Id
	public Applicant getApplicantDetailsByApplId(int applicationId);
	
	public Applicant getApplicantDetailsByLoanApplication(int loanApplicationId);
	
		public boolean checkIfApplicantExists(int applicantId);
}
