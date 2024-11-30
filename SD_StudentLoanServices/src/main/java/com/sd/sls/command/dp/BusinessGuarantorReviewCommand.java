package com.sd.sls.command.dp;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.sls.bank.representative.constant.BankRepresentativeConstants;
import com.sd.sls.external.db.dao.ExternalDbDAO;
import com.sd.sls.guarantor.model.Guarantor;

@Component
public class BusinessGuarantorReviewCommand implements GuarantorReviewCommand 
{
	@Autowired
	private ExternalDbDAO externalDbDAO;
	
	@Override
	public Map<String, Boolean> execute(Guarantor guarantor) 
	{
		Map<String, Boolean> resultMap = new HashMap<>();
        if (externalDbDAO.checkItrForBusiness(guarantor.getUinNo())) 
        {
            resultMap.put(BankRepresentativeConstants.GUARANTOR_REVIEWED_SUCCESSFULLY, true);
        }
        else 
        {
            resultMap.put(BankRepresentativeConstants.GUARANTOR_REVIEWED_FAILED, false);
        }
        return resultMap;
	}

}