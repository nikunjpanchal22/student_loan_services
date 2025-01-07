package com.sd.sls.bankadmin.bs;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.bankadmin.bl.IBankAdminBL;
import com.sd.sls.bankadmin.model.BankAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BankAdminBS implements IBankAdminBS {

    @Autowired
    private IBankAdminBL bankAdminBL;

    @Override
    public List<BankAdmin> getBankAdmins () {
        return bankAdminBL.getBankAdmins();
    }

    @Override
    public String disburseLoanOffer(Map<String, Object> userValues) {
        return bankAdminBL.disburseLoanOffer(userValues);
    }
}
