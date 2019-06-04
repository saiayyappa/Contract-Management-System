package com.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.bean.SupplierBean;
import com.cms.dao.SupplierDao;
import com.cms.exception.ApplicationException;

@Service("supplierService")
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierDao supplierDao;

	@Override
	public SupplierBean loginSupplierCheck(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		return supplierDao.loginSupplierCheck(id);

	}

	@Override
	public int addSupplier(SupplierBean supplierBean) throws ApplicationException {
		// TODO Auto-generated method stub
		return supplierDao.addSupplier(supplierBean);
	}

	@Override
	public SupplierBean fetchSupplier(int supplierId) throws ApplicationException {
		// TODO Auto-generated method stub
		return supplierDao.fetchSupplier(supplierId);
	}

	@Override
	public List<SupplierBean> fetchAllSuppliers() throws ApplicationException {
		// TODO Auto-generated method stub
		return supplierDao.fetchAllSuppliers();
	}

	@Override
	public void updateSupplierStatus(SupplierBean supplierBean) throws ApplicationException {
		// TODO Auto-generated method stub
		supplierDao.updateSupplierStatus(supplierBean);
	}

	@Override
	public List<SupplierBean> fetchSupplier(String status) throws ApplicationException {
		// TODO Auto-generated method stub
		return supplierDao.fetchSupplier(status);
	}

}
