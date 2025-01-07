package com.sd.sls.bankadmin.dao;

/*
 * @Author: Nikunj Panchal
 */

import com.sd.sls.bankadmin.model.BankAdmin;
import com.sd.sls.loanoffer.status.LoanOfferStatus;
import com.sd.sls.user.dao.IUserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.sd.sls.constants.ISQLStatements;

import java.util.List;

@Repository
public class BankAdminDAO implements IBankAdminDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private IUserDAO userDAO;

    @Override
    public List<BankAdmin> getBankAdmins () {
        List<BankAdmin> bankAdminList =  jdbcTemplate.query(
                ISQLStatements.GET_ALL_BANK_ADMINS, new BeanPropertyRowMapper<>(BankAdmin.class));
        return !bankAdminList.isEmpty() ? bankAdminList : null;
    }
    
    @Override
    public BankAdmin getBankAdminForLoanApplication (int loanApplicationId) {
    	List<BankAdmin> bankAdminList =  jdbcTemplate.query(
    			ISQLStatements.GET_BANK_ADMIN_FOR_LOAN_APPLICATION, new BeanPropertyRowMapper<>(BankAdmin.class), loanApplicationId);
    	for (BankAdmin bankAdmin : bankAdminList) {
			bankAdmin.setUser(userDAO.findUserForBankAdmin(bankAdmin.getAdminId()));
		}
    	return !bankAdminList.isEmpty() ? bankAdminList.get(0) : null;
    }

    @Override
    public int disburseLoanOffer (int offerID) {
        return jdbcTemplate.update(
                ISQLStatements.UPDATE_LOAN_APPLICATION_STATUS, new Object[]{LoanOfferStatus.DISBURSED, offerID});
    }
}
