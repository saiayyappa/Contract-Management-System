package com.cms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.bean.ContractBean;
import com.cms.dao.AmenityDao;
import com.cms.exception.ApplicationException;

@Service("amenityService")
@Transactional
public class AmenityServiceImpl implements AmenityService{
	
	@Autowired
	AmenityDao amenityDao;

	@Override
	public int addAmenity(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return amenityDao.addAmenity(contractBean);
	}

	@Override
	public int updateAmenity(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return amenityDao.updateAmenity(contractBean);
	}

}
