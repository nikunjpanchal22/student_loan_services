package com.sd.sls.loanoffer.status.stateDP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sd.sls.bankadmin.dao.IBankAdminDAO;

@Component
public class OfferAcceptedState implements ILoanOfferStatusState {

    @Autowired
    private IBankAdminDAO bankAdminDAO;

    @Override
    public int updateStatus (int offerId) {
        return 0;
    }
}
