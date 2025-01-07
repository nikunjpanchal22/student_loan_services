package com.sd.sls.loanoffer.status.context;

import com.sd.sls.loanoffer.factory.LoanOfferStatusFactory;
import com.sd.sls.loanoffer.status.stateDP.ILoanOfferStatusState;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
* Author: Nikunj Panchal
*/

@Component
public class LoanOfferStatusContext {

    @Autowired
    private LoanOfferStatusFactory loanOfferStatusFactory;

    private ILoanOfferStatusState loanOfferStatusState;

    public void setState(Map<String, Object> userValues)
    {
        //Using Factory Design Pattern here
        this.loanOfferStatusState = loanOfferStatusFactory.getLoanOfferState(userValues);
    }

    public int updateLoanOfferStatus(int applicationId)
    {
        if (loanOfferStatusState == null)
        {
            throw new IllegalStateException("Failure in Setting State");
        }
        return loanOfferStatusState.updateStatus(applicationId);
    }
}
