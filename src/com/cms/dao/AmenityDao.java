package com.cms.dao;

import com.cms.bean.ContractBean;
import com.cms.exception.ApplicationException;

public interface AmenityDao {

	public int addAmenity(ContractBean contractBean) throws ApplicationException;

	public int updateAmenity(ContractBean contractBean) throws ApplicationException;
}
