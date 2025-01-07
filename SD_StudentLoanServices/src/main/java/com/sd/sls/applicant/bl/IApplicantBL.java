package com.sd.sls.applicant.bl;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.Map;

import com.sd.sls.applicant.model.Applicant;

public interface IApplicantBL 
{
	//Added by Ranatosh Sarkar
	public Map<String, Boolean> registerApplicantDraft(Map<String, Object> userValues);
	
	//Added by Ranatosh Sarkar
	public Map<String, Boolean> registerApplicant(Long userId);
	
	public Applicant getApplicantDetailsByName (String firstName, String lastName);
}
