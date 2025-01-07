package com.sd.sls.loanapplication.status.state;

import org.springframework.stereotype.Component;

/*
 * @Author: Abhishek Vishwakarma
 */
@Component
public class SubmittedState implements IApplicationStatusState {

	@Override
	public int updateStatus(int loanApplicationId) {
		return 0;
	}

}
