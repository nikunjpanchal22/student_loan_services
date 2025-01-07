package com.sd.sls.guarantor.bs;
/* 
 * Author: Rushabh Botadra
 */

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.sls.guarantor.bl.IGuarantorBL;

@Service
public class GuarantorBS implements IGuarantorBS{
	
	@Autowired
	private IGuarantorBL guarantorBL;
	
	@Override
	public Map<String, Boolean> addGuarantorDetails(Map<String, Object> userValues)
	{
		return guarantorBL.addGuarantorDetails(userValues);
	}
}
