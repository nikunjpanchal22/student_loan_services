package com.sd.sls.guarantor.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sd.sls.guarantor.bs.IGuarantorBS;
import com.sd.sls.guarantor.constants.GuarantorConstants;

@RequestMapping("/guarantor")
@RestController
public class GuarantorController 
{
	@Autowired
	private IGuarantorBS guarantorBS;
	
	@PostMapping("/addGuarantor")
	public ResponseEntity<String> addGuarantorDetails(@RequestBody Map<String, Object> userValues) 
	{
		Map<String, Boolean> resultMap = guarantorBS.addGuarantorDetails(userValues);
		if (resultMap.containsKey(GuarantorConstants.GUARANTOR_ADDED_SUCESSFULLY) && resultMap.get(GuarantorConstants.GUARANTOR_ADDED_SUCESSFULLY) == true)
		{
			return new ResponseEntity<>(GuarantorConstants.GUARANTOR_ADDED_SUCESSFULLY, HttpStatus.OK);
		}
		else if (resultMap.containsKey(GuarantorConstants.NO_APPLICANT_APPLICATION_FOUND))
		{
			return new ResponseEntity<>(GuarantorConstants.NO_APPLICANT_APPLICATION_FOUND, HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<>("Failure in Guarantor Addition", HttpStatus.BAD_REQUEST);
		}
	}
}
