package com.sd.sls.bankadmin.bs;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.bankadmin.model.BankAdmin;

import java.util.List;
import java.util.Map;

public interface IBankAdminBS {
    public List<BankAdmin> getBankAdmins ();

    public String disburseLoanOffer(Map<String, Object> userValues);
}
