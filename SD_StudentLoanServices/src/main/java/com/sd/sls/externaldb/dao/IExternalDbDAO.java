package com.sd.sls.externaldb.dao;

import java.util.List;

import com.sd.sls.externaldb.model.ExternalDb;

public interface IExternalDbDAO {
	public boolean checkItrForBusiness(String uinNo);
	
	public boolean checkItrForSalaried(String uinNo);
}
