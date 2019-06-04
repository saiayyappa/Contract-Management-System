package com.cms.service;

import java.util.List;

import com.cms.bean.ContractBean;
import com.cms.bean.SupplierBean;
import com.cms.exception.ApplicationException;

public interface ContractService {

	public int addContract(ContractBean contractBean) throws ApplicationException;
	
	public List<ContractBean> listContract() throws ApplicationException;
	
	public ContractBean fetchContract(int contractId) throws ApplicationException;
	
	public int updateContract(ContractBean contractBean) throws ApplicationException;
	
	public int deleteContract(int contractId) throws ApplicationException;
	
	public void updateContractStatus(ContractBean contractBean) throws ApplicationException;

	public List<ContractBean> fetchContractUsingStatus(String contractStatus) throws ApplicationException;
	
	public List<ContractBean> fetchAllContracts() throws ApplicationException;
}
