package com.sd.sls.guarantor.bl;
/*
 * Author: Rushabh Botadra
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.applicant.dao.IApplicantDAO;
import com.sd.sls.applicant.model.Applicant;
import com.sd.sls.guarantor.constants.GuarantorConstants;
import com.sd.sls.guarantor.dao.IGuarantorDAO;
import com.sd.sls.guarantor.model.Guarantor;
import com.sd.sls.loanapplication.dao.ILoanApplicationDAO;
import com.sd.sls.loanapplication.model.LoanApplication;

@Service
public class GuarantorBL implements IGuarantorBL{
	
	@Autowired
	private IApplicantDAO applicantDAO;
	
	@Autowired
	private ILoanApplicationDAO loanApplicationDAO;
	
	@Autowired
	private IGuarantorDAO guarantorDAO;
	
	public Map<String, Boolean> addGuarantorDetails(Map<String, Object> userValues)
	{
		Map<String, Boolean> returnMap = new HashMap<>();
		if(checkIfApplicantExists(Integer.valueOf(Objects.toString(userValues.get(GuarantorConstants.APPLICANT)))) && checkIfApplicationExists(Integer.valueOf(Objects.toString(userValues.get(GuarantorConstants.APPLICATION)))))
		{
			Guarantor guarantor = createGuarantor(userValues);
			try {
	            if(guarantorDAO.addGuarantorDetails(guarantor) == 1)
	            {
	            	returnMap.put(GuarantorConstants.GUARANTOR_ADDED_SUCESSFULLY, true);
	            }
	        } catch (Exception e) {
	            System.err.println("An error occurred while adding guarantor: " + e.getMessage());
	            returnMap.put("Error occurred while adding guarantor", false);
	        }
			
		}
		else
		{
			returnMap.put("No Applicant/Application Found.\nPlease check with your Applicant", false);
		}
		return returnMap;
	}
	
	private Guarantor createGuarantor(Map<String, Object> userValues) 
	{
		Guarantor guarantor = new Guarantor();
		guarantor.setApplicant(new Applicant());
		guarantor.getApplicant().setApplicantId(Integer.valueOf(Objects.toString(userValues.get(GuarantorConstants.APPLICANT))));
		guarantor.setApplication(new LoanApplication());
		guarantor.getApplication().setApplicationId(Integer.valueOf(Objects.toString(userValues.get(GuarantorConstants.APPLICATION))));
		guarantor.setName(Objects.toString(userValues.get(GuarantorConstants.NAME)));
		guarantor.setRelationShip(Objects.toString(userValues.get(GuarantorConstants.RELATIONSHIP)));
		guarantor.setOccupation(Objects.toString(userValues.get(GuarantorConstants.OCCUPATION)));
		guarantor.setAnnualIncome(Long.valueOf(Objects.toString(userValues.get(GuarantorConstants.ANNUAL_INCOME))));
		guarantor.setAddress(Objects.toString(userValues.get(GuarantorConstants.ADDRESS)));
		guarantor.setUinNo(Objects.toString(userValues.get(GuarantorConstants.UIN_NO)));
		guarantor.setMonthlyExpense(Long.valueOf(Objects.toString(userValues.get(GuarantorConstants.MONTHLY_EXPENSE))));
		return guarantor;
	}
	
	private boolean checkIfApplicantExists(int applicantId)
	{
		return applicantDAO.checkIfApplicantExists(applicantId);
	}
	
	private boolean checkIfApplicationExists(int applicationId)
	{
		LoanApplication loanApplication = loanApplicationDAO.getApplicationById (applicationId);
		if(loanApplication != null)
		{
			return true;
		}
		return false;
	}
}


