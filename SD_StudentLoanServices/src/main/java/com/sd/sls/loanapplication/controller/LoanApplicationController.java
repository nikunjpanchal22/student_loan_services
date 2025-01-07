package com.sd.sls.loanapplication.controller;

import java.util.HashMap;

/*
 * @Author: Abhishek Vishwakarma
 */

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sd.sls.interceptor.dp.Context;
import com.sd.sls.interceptor.dp.InterceptorDispatcher;
import com.sd.sls.interceptor.dp.InterceptorFramework;
import com.sd.sls.interceptor.dp.LoggingInterceptor;
import com.sd.sls.loanapplication.bs.ILoanApplicationBS;
import com.sd.sls.loanapplication.constants.LoanApplicationConstants;
import com.sd.sls.loanapplication.model.LoanApplication;
import com.sd.sls.loanapplication.status.context.ApplicationStatusContext;
import com.sd.sls.loanapplication.status.state.WithdrawState;

@RequestMapping("/loanApplication")
@RestController
public class LoanApplicationController 
{
	@Autowired
	private ILoanApplicationBS loanApplicationBS;
	
	@Autowired
	private InterceptorDispatcher dispatcher;
	
	@Autowired
	private LoggingInterceptor interceptor;
	
	@Autowired
	private InterceptorFramework interceptorFramework;
	
	@PostMapping("/submitApplication")
	public ResponseEntity<String> submitApplication(@RequestBody Map<String, Object> userValues)
	{
		Map<String, Object> resultMap = loanApplicationBS.submitApplication(userValues);
		String key = "";
		for (Map.Entry<String, Object> entry : resultMap.entrySet()) 
		{
            key = entry.getKey();
        }
		
		if (key.equals(LoanApplicationConstants.LOAN_SUBMITTED_SUCCESSFULLY))
		{
			LoanApplication application = (LoanApplication) resultMap.get(LoanApplicationConstants.LOAN_SUBMITTED_SUCCESSFULLY);
			
			//Interceptor Design Pattern
			interceptorFramework.registerInterceptor(interceptor);
			Context context = new Context();
			context.put("applicationDetails", application);
			interceptorFramework.execute(context);
			return ResponseEntity.ok(key + application.getApplicationId());
		}
		return ResponseEntity.ok(key);
	}
	
	@GetMapping("/getApplicationId")
	public ResponseEntity<String> getApplicationId (@RequestParam String email)
	{
		String applicationId = Objects.toString(loanApplicationBS.getApplicationId(email));
		return ResponseEntity.ok(applicationId == LoanApplicationConstants.NULL ? LoanApplicationConstants.NO_LOAN_APPLICATION_FOUND : LoanApplicationConstants.LOAN_APPLICATION_FOUND + applicationId);
	}
	
	@PutMapping("/updateApplication/{applicationId}")
	public ResponseEntity<String> updateApplication (@PathVariable(LoanApplicationConstants.APPLICATION_ID) Long applicationId, @RequestBody Map<String, Object> userValues)
	{
		userValues.put("applicationId", applicationId);
		return ResponseEntity.ok(loanApplicationBS.updateApplication(userValues));
	}
	
	@PutMapping("/withdrawApplication/{applicationId}")
	public ResponseEntity<String> withdrawApplication(@PathVariable(LoanApplicationConstants.APPLICATION_ID) Long applicationId)
	{
		Map<String, Object> userValues = new HashMap<String, Object>();
		userValues.put(LoanApplicationConstants.APPLICATION_ID, applicationId);
		userValues.put(LoanApplicationConstants.ACTION, LoanApplicationConstants.WITHDRAW);
		return ResponseEntity.ok(loanApplicationBS.withdrawApplication(userValues));
	}
}
