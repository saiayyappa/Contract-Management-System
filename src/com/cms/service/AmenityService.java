package com.cms.service;

import com.cms.bean.ContractBean;
import com.cms.exception.ApplicationException;

public interface AmenityService {
	
	public int addAmenity(ContractBean contractBean) throws ApplicationException;
	
	public int updateAmenity(ContractBean contractBean) throws ApplicationException;
}
