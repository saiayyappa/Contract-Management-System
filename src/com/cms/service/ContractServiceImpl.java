package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.bean.ContractBean;
import com.cms.bean.SupplierBean;
import com.cms.dao.ContractDao;
import com.cms.exception.ApplicationException;

@Service("contractService")
@Transactional
public class ContractServiceImpl implements ContractService {

	@Autowired
	ContractDao contractDao;
	
	@Override
	public int addContract(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.addContract(contractBean);
	}

	@Override
	public List<ContractBean> listContract() throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.listContract();
	}

	@Override
	public ContractBean fetchContract(int contractId) throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.fetchContract(contractId);
	}

	@Override
	public int updateContract(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.updateContract(contractBean);
	}

	@Override
	public int deleteContract(int contractId) throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.deleteContract(contractId);
	}

	@Override
	public void updateContractStatus(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		contractDao.updateContractStatus(contractBean);
	}

	@Override
	public List<ContractBean> fetchContractUsingStatus(String contractStatus) throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.fetchContractUsingStatus(contractStatus);
	}

	@Override
	public List<ContractBean> fetchAllContracts() throws ApplicationException {
		// TODO Auto-generated method stub
		return contractDao.fetchAllContracts();
	}

}
