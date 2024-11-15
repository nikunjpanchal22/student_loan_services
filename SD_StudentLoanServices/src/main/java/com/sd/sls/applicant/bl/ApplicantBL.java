package com.sd.sls.applicant.bl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.sd.sls.applicant.constants.ApplicantConstants;
import com.sd.sls.applicant.dao.IApplicantDAO;
import com.sd.sls.applicant.model.Applicant;
import com.sd.sls.user.bl.IUserBusinessLogic;
import com.sd.sls.user.dao.IUserDAO;
import com.sd.sls.user.model.User;

@Service
public class ApplicantBL implements IApplicantBL {

	@Autowired
	private IApplicantDAO applicantDAO;

	@Autowired
	private IUserDAO userDAO;

	@Autowired
	private IUserBusinessLogic userBusinessLogic;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public Map<String, Boolean> registerApplicant(Map<String, Object> userValues) {
		Map<String, Boolean> returnMap = new HashMap<>();
		Applicant applicant = createApplicant(userValues);
		if (checkIfApplicantAlreadyExists(applicant)) {
			returnMap.put(ApplicantConstants.APPLICANT_ALREADY_REGISTERED, true);
			return returnMap;
		}

		transactionTemplate.execute(new TransactionCallbackWithoutResult() 
		{
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) 
			{
				if (applicant.getUser() == null) 
				{
					if (userValues.containsKey(ApplicantConstants.EMAIL) && userValues.containsKey(ApplicantConstants.PASSWORD) && userValues.containsKey(ApplicantConstants.PHONE_NUMBER)) 
					{
						User user = userBusinessLogic.createUser(userValues);
						user.setUserName(applicant.getFirstName() + " " + applicant.getLastName());
						if (userDAO.registerUser(user) == 1) 
						{
							user = userDAO.findUserByEmail(Objects.toString(userValues.get(ApplicantConstants.EMAIL)));
							applicant.setUser(user);
						}
					} 
					else 
					{
						returnMap.put(ApplicantConstants.NO_USER_FOUND, true);
						return;
					}
				}

				if (applicantDAO.registerApplicant(applicant) == 1) 
				{
					returnMap.put(ApplicantConstants.APPLICANT_REGISTERED, true);
				}
			}
		});

		return returnMap;
	}

	private Applicant createApplicant(Map<String, Object> userValues) 
	{
		Applicant applicant = new Applicant();
		User user = userDAO.findUserByEmail(Objects.toString(userValues.get(ApplicantConstants.EMAIL)));
		applicant.setUser(user == null ? null : user);
		applicant.setFirstName(Objects.toString(userValues.get(ApplicantConstants.FIRST_NAME)));
		applicant.setLastName(Objects.toString(userValues.get(ApplicantConstants.LAST_NAME)));
		String dateString = Objects.toString(userValues.get(ApplicantConstants.DATE_OF_BIRTH));
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(ApplicantConstants.DATE_PATTERN).toFormatter(Locale.ENGLISH);
		java.sql.Date sqlDate = null;
		try 
		{
			LocalDate localDate = LocalDate.parse(dateString, formatter);
			sqlDate = java.sql.Date.valueOf(localDate);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		applicant.setDateOfBirth(sqlDate);
		applicant.setAddress(Objects.toString(userValues.get(ApplicantConstants.ADDRESS)));
		applicant.setEducationDetails(Objects.toString(userValues.get(ApplicantConstants.EDUCATION_DETAILS)));
		applicant.setMembershipType(Objects.toString(userValues.get(ApplicantConstants.MEMBERSHIP_TYPE)));
		applicant.setEmail(Objects.toString(userValues.get(ApplicantConstants.EMAIL)));
		return applicant;
	}

	private boolean checkIfApplicantAlreadyExists(Applicant applicant) 
	{
		return applicantDAO.checkIfApplicantAlreadyExists(applicant);
	}
}