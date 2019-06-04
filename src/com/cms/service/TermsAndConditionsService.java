package com.cms.service;

import java.util.List;

import com.cms.bean.ContractBean;
import com.cms.exception.ApplicationException;

public interface TermsAndConditionsService {

	public int addTac(ContractBean contractBean) throws ApplicationException;
	
	public int updateTac(ContractBean contractBean) throws ApplicationException;
	
	public List<ContractBean> listTac() throws ApplicationException;
}
