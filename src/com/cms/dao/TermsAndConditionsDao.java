package com.cms.dao;

import com.cms.bean.ContractBean;
import com.cms.exception.ApplicationException;

public interface TermsAndConditionsDao {

	public int addTac(ContractBean contractBean) throws ApplicationException;
	
	public int updateTac(ContractBean contractBean) throws ApplicationException;
}
