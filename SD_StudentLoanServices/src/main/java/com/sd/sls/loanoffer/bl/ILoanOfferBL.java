package com.sd.sls.loanoffer.bl;

/*
* Author: Nikunj Panchal
*/

import com.sd.sls.loanoffer.model.LoanOffer;

import java.util.List;
import java.util.Map;

public interface ILoanOfferBL {
    public Map<String, Boolean> generateOffer (Map<String, Object> userValues);

    public List<LoanOffer> getAllOffers();
    
    public List<LoanOffer> checkGeneratedOffers (Long applicationId);
    
    public boolean updateOfferStatusFromApplicant(Map<String, Object> userValues);
}