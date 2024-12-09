package com.sd.sls.loanapplication.status.state;

import org.springframework.stereotype.Component;

/*
 * @Author: Abhishek Vishwakarma
 */
@Component
public class DraftState implements IApplicationStatusState {

	@Override
	public int updateStatus(Long loanApplicationId) {
		return 0;
	}

}