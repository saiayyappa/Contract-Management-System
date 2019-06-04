package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.bean.ContractBean;
import com.cms.dao.TermsAndConditionsDao;
import com.cms.exception.ApplicationException;

@Service("tacService")
@Transactional
public class TermsAndConditionsServiceImpl implements TermsAndConditionsService{

	@Autowired
	TermsAndConditionsDao tacDao;

	@Override
	public int addTac(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return tacDao.addTac(contractBean);
	}

	@Override
	public int updateTac(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return tacDao.updateTac(contractBean);
	}

	@Override
	public List<ContractBean> listTac() throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

}
