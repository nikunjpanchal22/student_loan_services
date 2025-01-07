package com.sd.sls.loanapplication.status.context;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sd.sls.loanapplication.factory.ApplicationStatusFactory;
import com.sd.sls.loanapplication.model.LoanApplication;
import com.sd.sls.loanapplication.status.state.IApplicationStatusState;

/*
 * @Author: Abhishek Vishwakarma
 */
@Component
public class ApplicationStatusContext 
{
//	@Autowired
	private IApplicationStatusState applicationStatusState;
	
	@Autowired
	private ApplicationStatusFactory applicationStatusFactory;
	
	public void setState(Map<String, Object> userValues)
	{
		//Using Factory Design Pattern here
		this.applicationStatusState = applicationStatusFactory.getApplicationStatusFactory(userValues);
	}
	
	public int updateLoanApplicationStatus(int loanApplicationId)
	{
		if (applicationStatusState == null)
		{
			throw new IllegalStateException("Failure in Setting State");
		}
		return applicationStatusState.updateStatus(loanApplicationId);
	}
}
