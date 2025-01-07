package com.sd.sls.loanoffer.status.stateDP;

import com.sd.sls.bankadmin.dao.IBankAdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfferRejectedState implements ILoanOfferStatusState {

    @Autowired
    private IBankAdminDAO bankAdminDAO;

    @Override
    public int updateStatus (int offerId) {
        return 0;
    }
}
