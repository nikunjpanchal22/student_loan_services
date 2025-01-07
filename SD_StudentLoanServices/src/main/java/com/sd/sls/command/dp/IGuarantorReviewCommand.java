package com.sd.sls.command.dp;
/*
 * @Author: Nikunj Panchal
 */

import java.util.Map;

import com.sd.sls.guarantor.model.Guarantor;


public interface IGuarantorReviewCommand {
	public Map<String, Boolean> execute(Guarantor guarantor);
}
