package com.sd.sls.applicant.bs;

import java.util.Map;

public interface IApplicantBS {
	public Map<String, Boolean> registerApplicant(Map<String, Object> userValues);
}