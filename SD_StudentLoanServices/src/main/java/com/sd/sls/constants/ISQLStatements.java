package com.sd.sls.constants;

/*
 * @Author: Abhishek Vishwakarma
 */

public class ISQLStatements {
	public final static String REGISTER_USER = "INSERT INTO \"USER\"(USER_NAME, EMAIL, PASSWORD, PHONE_NUMBER) VALUES (?, ?, ?, ?)";

	public static final String CHECK_USER = "SELECT USER_ID AS \"userId\", USER_NAME AS \"userName\", EMAIL AS \"email\", PASSWORD AS \"password\", PHONE_NUMBER AS \"phoneNumber\" FROM \"USER\" u WHERE u.USER_NAME = ? and u.EMAIL = ? and u.PHONE_NUMBER = ?";
	
	public static final String FIND_USER_BY_EMAIL = "SELECT USER_ID AS \"userId\", USER_NAME AS \"userName\", EMAIL AS \"email\", PASSWORD AS \"password\", PHONE_NUMBER AS \"phoneNumber\" FROM \"USER\" u WHERE u.EMAIL = ?";
	
	public static final String UPDATE_USER_PROFILE = "UPDATE \"USER\" SET ";
	
	public final static String REGISTER_APPLICANT = "INSERT INTO APPLICANT(USER_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, ADDRESS, EDUCATION_DETAILS, MEMBERSHIP_TYPE, EMAIL) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	public final static String REGISTER_APPLICANT_DRAFT = "INSERT INTO APPLICANT_DRAFT(USER_ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, ADDRESS, EDUCATION_DETAILS, MEMBERSHIP_TYPE, EMAIL) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String CHECK_APPLICANT = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT WHERE FIRST_NAME = ? AND LAST_NAME = ? AND EMAIL = ?";
	
	public static final String FIND_APPLICANT_BY_NAME = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT WHERE FIRST_NAME = ? AND LAST_NAME = ?";
	
	public static final String FIND_APPLICANT_DRAFT_BY_NAME = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT_DRAFT WHERE FIRST_NAME = ? AND LAST_NAME = ?";
	
	public static final String FIND_APPLICANT_DRAFT_BY_ID = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT_DRAFT WHERE USER_ID = (SELECT USER_ID FROM \"USER\" WHERE USER_ID = ?)";
	
	public static final String SUBMIT_LOAN_APPLICATION = "INSERT INTO LOAN_APPLICATION (APPLICANT_ID, GUARANTOR_NAME, APPLICATION_DATE, APPLICATION_STATUS, LOAN_AMOUNT, PURPOSE, ASSIGNEE_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	public static final String CHECK_LOAN_APPLICATION = "SELECT * FROM LOAN_APPLICATION WHERE APPLICANT_ID = ? AND APPLICATION_STATUS NOT IN ('D', 'S', 'WD')";
	
	public static final String GET_LOAN_APPLICATION_FOR_DRAFT = "SELECT APPLICATION_ID AS \"applicationId\", APPLICANT_ID AS \"applicantId\", GUARANTOR_NAME AS \"guarantorName\", APPLICATION_DATE AS \"applicationDate\", APPLICATION_STATUS AS \"status\", LOAN_AMOUNT AS \"loanAmount\", PURPOSE AS \"purpose\", ASSIGNEE_ID AS \"assigneeId\" FROM LOAN_APPLICATION WHERE APPLICANT_ID = ? AND LOAN_AMOUNT = ? AND APPLICATION_STATUS = 'DR'";
	
	public static final String GET_LOAN_APPLICATION_FOR_APPLICANT = "SELECT APPLICATION_ID AS \"applicationId\", APPLICANT_ID AS \"applicantId\", GUARANTOR_NAME AS \"guarantorName\", APPLICATION_DATE AS \"applicationDate\", APPLICATION_STATUS AS \"status\", LOAN_AMOUNT AS \"loanAmount\", PURPOSE AS \"purpose\", ASSIGNEE_ID AS \"assigneeId\" FROM LOAN_APPLICATION WHERE APPLICANT_ID = (SELECT APPLICANT_ID FROM APPLICANT WHERE EMAIL = ?)";
	
	public static final String GENERATE_LOAN_OFFER = "INSERT INTO LOAN_OFFER (APPLICATION_ID, SANCTIONED_AMOUNT, INTEREST_RATE, OFFER_STATUS, DISBURSED_DATE) VALUES (?, ?, ? ,?, ?)";

	public static final String GET_LOAN_OFFER = "SELECT OFFER_ID AS \"OfferID\", APPLICATION_ID, SANCTIONED_AMOUNT AS \"sanctionedAmount\", INTEREST_RATE AS \"interestRate\", OFFER_STATUS, DISBURSED_DATE \"disbursedDate\" FROM LOAN_OFFER WHERE OFFER_ID = ?";

	public static final String CHECK_LOAN_OFFER = "SELECT * FROM LOAN_OFFER WHERE APPLICATION_ID = ? AND OFFER_STATUS NOT IN ('DIS')";

	public static final String GET_ALL_APPROVED_APPLICATIONS = "SELECT APPLICATION_ID, APPLICANT_ID, GUARANTOR_NAME, APPLICATION_DATE, APPLICATION_STATUS AS \"status\", LOAN_AMOUNT, PURPOSE, ASSIGNEE_ID FROM LOAN_APPLICATION WHERE APPLICATION_STATUS = 'A'";

	public static final String GET_ALL_BANK_ADMINS = "SELECT ADMIN_ID AS \"adminID\", USER_ID, AUTHORITY_LEVEL AS \"authorityLevel\" FROM BANK_ADMIN";

	public static final String GET_ALL_LOAN_OFFERS = "SELECT OFFER_ID AS \"OfferID\", APPLICATION_ID, SANCTIONED_AMOUNT AS \"sanctionedAmount\", INTEREST_RATE AS \"interestRate\", OFFER_STATUS AS \"offerStatus\", DISBURSED_DATE \"disbursedDate\" FROM LOAN_OFFER WHERE OFFER_STATUS = 'ACCEPTED'";
	
	public static final String UPDATE_LOAN_APPLICATION_STATUS = "UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = ? WHERE APPLICATION_ID = ?";
	
	public static final String SEND_NOTIFICATION = "INSERT INTO NOTIFICATION(USER_ID, MESSAGE, TIMESTAMP, NOTIFICATION_STATUS, SENDER_ID, SENDER_TYPE) VALUES(?, ?, ?, ?, ?, ?)";
	
	public static final String READ_NOTIFICATION = "SELECT NOTIFICATION_ID AS \"notificationId\", USER_ID AS \"userId\", MESSAGE AS \"message\", TIMESTAMP AS \"timeStamp\", NOTIFICATION_STATUS AS \"notificationStatus\", SENDER_ID AS \"senderId\", SENDER_TYPE AS \"senderType\" FROM NOTIFICATION WHERE NOTIFICATION_STATUS = 'S' ORDER BY TIMESTAMP DESC";
	
	public static final String GET_USER_FOR_NOTIFICATION = "SELECT * FROM \"USER\" WHERE USER_ID = (SELECT USER_ID FROM NOTIFICATION WHERE MESSAGE = ?)";
	
	public static final String DELETE_APPLICANT_FROM_DRAFT = "DELETE FROM APPLICANT_DRAFT WHERE APPLICANT_ID = ?";

// Get all the loan applications which are in the Submitted status
//	public static final String GET_ALL_LOAN_APPLICATIONS = "SELECT APPLICATION_ID, APPLICANT_ID, APPLICATION_DATE, APPLICATION_STATUS, LOAN_AMOUNT, PURPOSE, ASSIGNEE_ID FROM LOAN_APPLICATION WHERE APPLICATION_STATUS IN ('DR', 'UR')";
	public static final String GET_ALL_LOAN_APPLICATIONS = "SELECT APPLICATION_ID AS \"applicationId\", APPLICATION_DATE AS \"applicationDate\", APPLICATION_STATUS AS \"status\", LOAN_AMOUNT AS \"loanAmount\", PURPOSE AS \"purpose\", ASSIGNEE_ID AS \"assigneId\" FROM LOAN_APPLICATION WHERE APPLICATION_STATUS IN ('DR', 'UR')";		
	
	// Get all the Bank Representatives
	public static final String GET_ALL_BANK_REPRESENTATIVE = "SELECT EMPLOYEE_ID AS \"employeeId\" FROM BANK_REPRESENTATIVE ";
	
	public static final String GET_ALL_USER_FROM_BANK_REPRESENTATIVE = "SELECT U.USER_ID AS \"userId\", U.USER_NAME AS \"userName\", U.EMAIL AS \"email\", U.PASSWORD AS \"password\", U.PHONE_NUMBER AS \"phoneNumber\" FROM BANK_REPRESENTATIVE BR, \"USER\" U WHERE BR.USER_ID = U.USER_ID AND BR.EMPLOYEE_ID = ?"; 

// Update Application with Bank Representative Id - RB
	public static final String ASSIGN_APPLICATION = "UPDATE \"LOAN_APPLICATION\" SET ASSIGNEE_ID = ? WHERE APPLICATION_ID = ?";
		
// Get Applicant By ID - RB
	public static final String FIND_APPLICANT_BY_ID = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT WHERE APPLICANT_ID = ?";

// Get Guarantor Details By Application Id - RB
	public static final String FIND_GUARANTOR_BY_APPL_ID = "SELECT GURANTOR_ID AS \"guarantorId\", NAME AS \"name\", RELATIONSHIP AS \"relationship\", OCCUPATION AS \"occupation\", ANNUAL_INCOME AS \"annualIncome\", ADDRESS AS \"address\", UIN_NO AS \"uinNo\", MONTHLY_EXPENSE AS \"monthlyExpense\" FROM GUARANTOR WHERE APPLICATION_ID = ?";

// Get Application By Id
	public static final String GET_LOAN_APPLICATION_BY_ID = "SELECT APPLICATION_ID AS \"applicationId\", APPLICATION_DATE AS \"applicationDate\", APPLICATION_STATUS AS \"status\", LOAN_AMOUNT AS \"loanAmount\", PURPOSE AS \"purpose\", ASSIGNEE_ID AS \"assigneId\" FROM LOAN_APPLICATION WHERE APPLICATION_ID = ?";
		
// Get the last 3 years ITR for Business Person 	
	public static final String GET_ITR_FOR_BUSINESS = "SELECT UIN_NO AS \"uinNo\" FROM EXTERNAL_DB a WHERE UIN_NO = ? AND ITR_YEAR BETWEEN ? AND ? GROUP BY UIN_NO HAVING COUNT(DISTINCT ITR_YEAR) = 3";

// Get the current months ITR for Salaried Person
	public static final String GET_ITR_FOR_SALARIED = "SELECT UIN_NO AS \"uinNo\", ITR_NO AS \"itrNo\", OCCUPATION AS \"occupation\", ANNUAL_INCOME AS \"annualIncome\", SALARY_RECEIVED_DATE AS \"salaryReceivedDate\", CREDIT_SCORE AS \"creditScore\", REPO_RATE AS \"repoRate\", ITR_YEAR AS \"itrYear\"  FROM EXTERNAL_DB WHERE UIN_NO = ? AND SALARY_RECEIVED_DATE BETWEEN SYSDATE - 30 AND SYSDATE";

// Get Applicant by Application Id
	public static final String GET_APPLICANT_BY_APPLICANT_ID = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"user\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OFBIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT WHERE APPLICANT_ID = ?";
	
	public static final String GET_APPLICANT_BY_LOAN_APPLICATION = "SELECT A.APPLICANT_ID AS \"applicantId\", A.FIRST_NAME AS \"firstName\", A.LAST_NAME AS \"lastName\", A.DATE_OF_BIRTH AS \"dateOfBirth\", A.ADDRESS AS \"address\", A.EDUCATION_DETAILS AS \"educationDetails\", A.MEMBERSHIP_TYPE AS \"membershipType\", A.EMAIL AS \"email\" FROM APPLICANT A, LOAN_APPLICATION LA WHERE A.APPLICANT_ID = LA.APPLICANT_ID AND LA.APPLICATION_ID = ?";
	
	public static final String UPDATE_LOAN_OFFER_STATUS = "UPDATE LOAN_OFFER SET OFFER_STATUS = ?, DISBURSED_DATE = SYSDATE WHERE OFFER_ID = ?";

	public static final String DISBURSE_LOAN_APPLICATION = "UPDATE LOAN_APPLICATION SET APPLICATION_STATUS = ? WHERE APPLICATION_ID = (SELECT 1 FROM LOAN_OFFER WHERE OFFER_ID = ?)";
	
	public static final String GET_USER_FOR_BANK_ADMIN = "SELECT U.USER_ID AS \"userId\", U.USER_NAME AS \"userName\", U.EMAIL AS \"email\", U.PASSWORD AS \"password\", U.PHONE_NUMBER AS \"phoneNumber\" FROM BANK_ADMIN BA, \"USER\" U WHERE BA.USER_ID = U.USER_ID AND BA.ADMIN_ID = ?";

	public static final String GET_BANK_ADMIN_FOR_LOAN_APPLICATION = "SELECT ADMIN_ID AS \"admin_id\", AUTHORITY_LEVEL AS \"authorityLevel\" FROM BANK_ADMIN, LOAN_APPLICATION WHERE ADMIN_ID = ASSIGNEE_ID AND APPLICATION_ID = ?";
	
	public static final String GET_ALL_GENERATED_OFFERS = "SELECT OFFER_ID AS \"offerId\", SANCTIONED_AMOUNT AS \"sanctionedAmount\", INTEREST_RATE AS \"interestRate\", OFFER_STATUS AS \"offerStatus\", DISBURSED_DATE AS \"disbursedDate\" FROM LOAN_OFFER WHERE APPLICATION_ID = ?";
	
	public static final String UPDATE_LOAN_OFFER_FROM_APPLICANT = "UPDATE LOAN_OFFER SET OFFER_STATUS = ? WHERE APPLICATION_ID = ?";
	
	public static final String GET_APPLICATIONID_FOR_LOAN_OFFER = "SELECT APPLICATION_ID FROM LOAN_OFFER WHERE OFFER_ID = ?";
	
	public static final String GET_APPLICANT_BY_ID = "SELECT APPLICANT_ID AS \"applicantId\", USER_ID AS \"userId\", FIRST_NAME AS \"firstName\", LAST_NAME AS \"lastName\", DATE_OF_BIRTH AS \"dateOfBirth\", ADDRESS AS \"address\", EDUCATION_DETAILS AS \"educationDetails\", MEMBERSHIP_TYPE AS \"membershipType\", EMAIL AS \"email\" FROM APPLICANT WHERE APPLICANT_ID = ?";

	public static final String SUBMIT_GUARANTOR_DETAILS = "INSERT INTO GUARANTOR(APPLICANT_ID, APPLICATION_ID, NAME, RELATIONSHIP, OCCUPATION, ANNUAL_INCOME, ADDRESS, UIN_NO, MONTHLY_EXPENSE) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

}
