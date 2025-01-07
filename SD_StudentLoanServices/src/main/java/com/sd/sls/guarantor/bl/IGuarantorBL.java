package com.sd.sls.guarantor.bl;
/*
 * Author: Rushabh Botadra
 */

import java.util.Map;

public interface IGuarantorBL {
	
	public Map<String, Boolean> addGuarantorDetails(Map<String, Object> userValues);

}
