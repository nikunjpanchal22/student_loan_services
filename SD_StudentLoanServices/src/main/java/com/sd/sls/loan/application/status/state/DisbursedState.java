package com.sd.sls.loan.application.status.state;

import org.springframework.stereotype.Component;

/*
 * @Author: Abhishek Vishwakarma
 */
@Component
public class DisbursedState implements IApplicationStatusState {

	@Override
	public int updateStatus(Long loanApplicationId) {
		return 0;
	}

}