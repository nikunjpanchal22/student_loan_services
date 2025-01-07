package com.sd.sls.bankadmin.controller;

import java.util.HashMap;

/*
 * @Author: Nikunj Panchal
 */

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.sls.applicant.bs.IApplicantBS;
import com.sd.sls.applicant.constants.ApplicantConstants;
import com.sd.sls.bankadmin.bs.IBankAdminBS;
import com.sd.sls.bankadmin.constants.BankAdminConstants;
import com.sd.sls.bankadmin.model.BankAdmin;
import com.sd.sls.loanapplication.bs.LoanApplicationBS;
import com.sd.sls.loanapplication.constants.LoanApplicationConstants;
import com.sd.sls.loanapplication.model.LoanApplication;
import com.sd.sls.loanoffer.bs.ILoanOfferBS;
import com.sd.sls.loanoffer.constants.LoanOfferConstants;
import com.sd.sls.loanoffer.model.LoanOffer;
import com.sd.sls.notification.bs.INotificationBS;
import com.sd.sls.notification.model.Notification;
import com.sd.sls.user.service.IUserBusinessService;

@RequestMapping("/bankadmin")
@RestController
public class BankAdminController {
	
	@Autowired
	private IApplicantBS applicantBS;
	
	@Autowired
	private INotificationBS notificationBS;

	@Autowired
	private IUserBusinessService userBusinessService;

	@Autowired
	IBankAdminBS bankAdminService;

	@Autowired
	private ILoanOfferBS loanOfferBS;

	@Autowired
	private LoanApplicationBS loanApplicationBS;
	
	//Added by Ranatosh Sarkar
	@GetMapping("/checkNotifications")
	public ResponseEntity<List<Notification>> checkNotifications()
	{
		return ResponseEntity.ok(notificationBS.checkNotifications());
	}
	
	//Added by Ranatosh Sarkar
	@PostMapping("/approveRegisteration/{userId}")
	public ResponseEntity<String> approveRegisterationsForApplicant(@PathVariable("userId") Long userId)
	{
		Map<String, Boolean> resultMap = applicantBS.registerApplicant(userId);
		if (resultMap.containsKey(ApplicantConstants.APPLICANT_REGISTERED)) 
		{
			return resultMap.get(ApplicantConstants.APPLICANT_REGISTERED) == true
					? new ResponseEntity<>("Applicant Registration Approved", HttpStatus.OK)
					: new ResponseEntity<>(ApplicantConstants.APPLICANT_REGISTERED_FAILED, HttpStatus.NOT_FOUND);
		}
		else 
		{
			return new ResponseEntity<>(ApplicantConstants.BAD_REQUEST, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody Map<String, Object> userValues) {
		String userName = Objects.toString(userValues.get(BankAdminConstants.EMAIL));
		String password = Objects.toString(userValues.get(BankAdminConstants.PASSWORD));
		return userBusinessService.loginUser(userName, password)
				? new ResponseEntity<>(BankAdminConstants.BANK_ADMIN_LOGGED_IN_SUCCESSFULLY, HttpStatus.OK)
				: new ResponseEntity<>(BankAdminConstants.INVALID_CREDENTIALS, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getApplications")
	public ResponseEntity<List<LoanApplication>> getApprovedApplications() {
		List<LoanApplication> applications = loanApplicationBS.getApprovedApplications();
		if (applications.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.ok(applications);
		}
	}

	@PostMapping("/generateOffer/{applicationId}")
	public ResponseEntity<String> generateOffer(
			@PathVariable("applicationId") int applicationId) {

		Map<String, Object> userValues = new HashMap<>();
		userValues.put(LoanApplicationConstants.APPLICATION_ID, applicationId);
		userValues.put(BankAdminConstants.ACTION, BankAdminConstants.GENERATED);

		Map<String, Boolean> resultMap = loanOfferBS.generateOffer(userValues);
		String key = "";
		for (Map.Entry<String, Boolean> entry : resultMap.entrySet()) {
			key = entry.getKey();
		}
		return ResponseEntity.ok(key);
	}

	@GetMapping("/getBankAdmins")
	public ResponseEntity<List<BankAdmin>> getBankAdmins() {
		List<BankAdmin> bankAdminList = bankAdminService.getBankAdmins();
		if (bankAdminList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.ok(bankAdminList);
		}
	}

	@PutMapping("/disburseLoan/{offerId}")
	public ResponseEntity<String> disburseLoanOffer (
			@PathVariable(BankAdminConstants.OFFER_ID) int offerId ) {

		Map<String, Object> userValues = new HashMap();
		userValues.put(BankAdminConstants.OFFER_ID, offerId);
		userValues.put(BankAdminConstants.ACTION, LoanOfferConstants.DISBURSED);
		return ResponseEntity.ok(bankAdminService.disburseLoanOffer(userValues));
	}
	
	@GetMapping("/getAllOffers")
    public ResponseEntity<List<LoanOffer>> getAllOffers () {
        List<LoanOffer> loanOfferList = loanOfferBS.getAllOffers();
        if (!loanOfferList.isEmpty()) {
            return ResponseEntity.ok(loanOfferList);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
