package com.sd.sls.bankadmin.bl;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.bankadmin.constants.BankAdminConstants;
import com.sd.sls.bankadmin.dao.IBankAdminDAO;
import com.sd.sls.bankadmin.model.BankAdmin;
import com.sd.sls.guarantor.dao.IGuarantorDAO;
import com.sd.sls.guarantor.model.Guarantor;
import com.sd.sls.loanapplication.constants.LoanApplicationConstants;
import com.sd.sls.loanapplication.status.ApplicationStatus;
import com.sd.sls.loanapplication.status.context.ApplicationStatusContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sd.sls.loanoffer.status.context.LoanOfferStatusContext;
import com.sd.sls.user.dao.IUserDAO;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BankAdminBL implements IBankAdminBL {

    @Autowired
    private IBankAdminDAO bankAdminDAO;

    @Autowired
    private IGuarantorDAO guarantorDAO;
    
    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private LoanOfferStatusContext loanOfferStatusContext;

    @Autowired
    private ApplicationStatusContext applicationStatusContext;

    @Override
    public Double calculateSanctionAmount (int applicationId) {
        Guarantor guarantor = guarantorDAO.getGuarantorByAppId(applicationId);

        Double LoanMultiplier = 0.0;

        if (Objects.equals(guarantor.getOccupation(), BankAdminConstants.BUSINESS))
            LoanMultiplier = (BankAdminConstants.BUSINESS_RATE * ((double) guarantor.getAnnualIncome() /12));
        else
            LoanMultiplier = (BankAdminConstants.SALARY_RATE * ((double) guarantor.getAnnualIncome() /12));

        return (((guarantor.getAnnualIncome()/12) - guarantor.getMonthlyExpense())/ BankAdminConstants.LOAN_TENURE) * LoanMultiplier;
    }

    @Override
    public List<BankAdmin> getBankAdmins () {
    	List<BankAdmin> bankAdminList = bankAdminDAO.getBankAdmins();
    	for (BankAdmin bankAdmin : bankAdminList) 
    	{
			bankAdmin.setUser(userDAO.findUserForBankAdmin(bankAdmin.getAdminId()));
		}
    	return bankAdminList;
    }

    @Override
    public String disburseLoanOffer (Map<String, Object> userValues) {
//        return bankAdminDAO.disburseLoanOffer(offerID);

        //Used State Design Pattern here to set the status of loan offer to Disbursed
        loanOfferStatusContext.setState(userValues);

        boolean x = loanOfferStatusContext.updateLoanOfferStatus(
                (Integer) userValues.get(BankAdminConstants.OFFER_ID)) == 1;

        userValues.replace(BankAdminConstants.ACTION, LoanApplicationConstants.DISBURSED);
        applicationStatusContext.setState(userValues);

        boolean y = applicationStatusContext.updateLoanApplicationStatus(
                (Integer) userValues.get(BankAdminConstants.OFFER_ID)) == 1;

        if (x && y) {
            return BankAdminConstants.LOAN_OFFER_DISBURSED;
        }
        return BankAdminConstants.LOAN_OFFER_DISBURSED_FAILED;
    }
}
