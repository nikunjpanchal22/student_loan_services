package com.sd.sls.guarantor.dao;

import com.sd.sls.guarantor.model.Guarantor;

public interface IGuarantorDAO {
    public Guarantor getGuarantorByAppId(int applicationId);
    public int addGuarantorDetails(Guarantor guarantor);
}
