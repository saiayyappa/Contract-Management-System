package com.cms.service;

import java.util.List;

import com.cms.bean.SupplierBean;
import com.cms.exception.ApplicationException;

public interface SupplierService {

	public SupplierBean loginSupplierCheck(int id) throws ApplicationException;

	public int addSupplier(SupplierBean supplierBean) throws ApplicationException;

	public SupplierBean fetchSupplier(int supplierId) throws ApplicationException;
	
	public List<SupplierBean> fetchAllSuppliers() throws ApplicationException;
	
	public void updateSupplierStatus(SupplierBean supplierBean) throws ApplicationException;

	public List<SupplierBean> fetchSupplier(String status) throws ApplicationException;
}
