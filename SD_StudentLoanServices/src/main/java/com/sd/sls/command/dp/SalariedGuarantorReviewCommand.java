package com.sd.sls.command.dp;

/*
 * @Author: Nikunj Panchal
 */

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.sls.bankrepresentative.constant.BankRepresentativeConstants;
import com.sd.sls.externaldb.dao.ExternalDbDAO;
import com.sd.sls.guarantor.model.Guarantor;

@Component
public class SalariedGuarantorReviewCommand implements IGuarantorReviewCommand 
{
	@Autowired
	private ExternalDbDAO externalDbDAO;
	
	public Map<String, Boolean> execute(Guarantor guarantor) 
	{
        Map<String, Boolean> resultMap = new HashMap<>();
        if (externalDbDAO.checkItrForSalaried(guarantor.getUinNo())) 
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
