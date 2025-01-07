package com.sd.sls.loanoffer.bs;

/*
* Author: Nikunj Panchal
*/

import com.sd.sls.loanoffer.bl.ILoanOfferBL;
import com.sd.sls.loanoffer.model.LoanOffer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoanOfferBS implements ILoanOfferBS{

    @Autowired
    private ILoanOfferBL loanOfferBL;

    @Override
    public Map<String, Boolean> generateOffer(Map<String, Object> userValues) {
        return loanOfferBL.generateOffer(userValues);
    }

    @Override
    public List<LoanOffer> getAllOffers()
    {
        return loanOfferBL.getAllOffers();
    }
    
    @Override
    public List<LoanOffer> checkGeneratedOffers (Long applicationId)
    {
    	return loanOfferBL.checkGeneratedOffers(applicationId);
    }
    
    @Override
    public boolean updateOfferStatusFromApplicant(Map<String, Object> userValues)
    {
    	return loanOfferBL.updateOfferStatusFromApplicant(userValues);
    }
}

