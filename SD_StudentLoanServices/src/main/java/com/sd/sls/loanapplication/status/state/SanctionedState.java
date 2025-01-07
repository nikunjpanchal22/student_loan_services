package com.sd.sls.loanapplication.status.state;

import com.sd.sls.loanapplication.dao.LoanApplicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * @Author: Abhishek Vishwakarma
 */
@Component
public class SanctionedState implements IApplicationStatusState {

	@Autowired
	private final LoanApplicationDAO loanApplicationDAO;

	public SanctionedState(LoanApplicationDAO loanApplicationDAO) {
		this.loanApplicationDAO = loanApplicationDAO;
	}

	@Override
	public int updateStatus(int applicationId) {
		return loanApplicationDAO.sanctionLoanApplication(applicationId);
	}

}
