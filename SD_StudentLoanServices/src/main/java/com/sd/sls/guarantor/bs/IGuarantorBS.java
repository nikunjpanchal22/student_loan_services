package com.sd.sls.guarantor.bs;
/*
 * Author: Rushabh Botadra
 */
import java.util.Map;

public interface IGuarantorBS {
	public Map<String, Boolean> addGuarantorDetails(Map<String, Object> userValues);
}
