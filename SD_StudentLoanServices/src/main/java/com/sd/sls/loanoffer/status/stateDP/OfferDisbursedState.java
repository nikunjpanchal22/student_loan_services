package com.sd.sls.loanoffer.status.stateDP;

/*
 * Author: Nikunj Panchal
 */

import com.sd.sls.bankadmin.dao.BankAdminDAO;
import com.sd.sls.bankadmin.dao.IBankAdminDAO;
import com.sd.sls.loanoffer.dao.LoanOfferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferDisbursedState implements ILoanOfferStatusState {

    @Autowired
    private LoanOfferDAO loanOfferDAO;

    @Override
    public int updateStatus (int offerId) {
        return (loanOfferDAO.disburseLoanOffer(offerId));
    }
}
