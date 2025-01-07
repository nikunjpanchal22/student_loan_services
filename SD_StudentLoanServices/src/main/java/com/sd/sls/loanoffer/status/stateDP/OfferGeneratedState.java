package com.sd.sls.loanoffer.status.stateDP;

import com.sd.sls.bankadmin.dao.IBankAdminDAO;
import com.sd.sls.loanoffer.dao.ILoanOfferDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferGeneratedState implements ILoanOfferStatusState {

    @Autowired
    private ILoanOfferDAO loanOfferDAO;

    @Override
    public int updateStatus (int applicationId) {
        return loanOfferDAO.generateLoanOfferStatus(applicationId);
    }
}