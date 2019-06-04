package com.cms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.bean.SupplierBean;
import com.cms.entity.SupplierEntity;
import com.cms.exception.ApplicationException;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SupplierBean loginSupplierCheck(int id) throws ApplicationException {
		
		SupplierEntity supplierEntity = null;
		SupplierBean supplierBean = new SupplierBean();
		
		try {
			List list = (List) sessionFactory.getCurrentSession()
					.createQuery("from SupplierEntity where supplierId='" + id + "'").list();
			
			if (list != null && list.size() > 0) {
				
				supplierEntity = (SupplierEntity) list.get(0);
				supplierBean.setFirstName(supplierEntity.getFirstName());
				supplierBean.setLastName(supplierEntity.getLastName());
				supplierBean.setPassword(supplierEntity.getPassword());
				supplierBean.setSupplierId(supplierEntity.getSupplierId());
				supplierBean.setSupplierStatus(supplierEntity.getSupplierStatus());
				//System.out.println("in impl"+supplierBean);
				
			} else {
				return supplierBean;
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return supplierBean;
	}

	@Override
	public int addSupplier(SupplierBean supplierBean) throws ApplicationException {
		
		SupplierEntity supplierEntity = null;
		
		int id = 0;
		
		try {
			supplierEntity = new SupplierEntity();
			supplierEntity.setFirstName(supplierBean.getFirstName());
			supplierEntity.setLastName(supplierBean.getLastName());
			supplierEntity.setAge(supplierBean.getAge());
			supplierEntity.setGender(supplierBean.getGender());
			supplierEntity.setDob(supplierBean.getDob());
			supplierEntity.setContactNumber(supplierBean.getContactNumber());
			supplierEntity.setAltContactNumber(supplierBean.getAltContactNumber());
			supplierEntity.setEmailId(supplierBean.getEmailId());
			supplierEntity.setPassword(supplierBean.getPassword());
			supplierEntity.setAddressLine1(supplierBean.getAddressLine1());
			supplierEntity.setAddressLine2(supplierBean.getAddressLine2());
			supplierEntity.setCity(supplierBean.getCity());
			supplierEntity.setState(supplierBean.getState());
			supplierEntity.setZipCode(supplierBean.getZipCode());
			supplierEntity.setSupplierStatus(supplierBean.getSupplierStatus());
			sessionFactory.getCurrentSession().save(supplierEntity);

			supplierEntity = (SupplierEntity) sessionFactory.getCurrentSession().get(SupplierEntity.class,
					supplierEntity.getSupplierId());
		
			id = supplierEntity.getSupplierId();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return id;
	}

	@Override
	public SupplierBean fetchSupplier(int supplierId) throws ApplicationException {
		
		SupplierEntity supplierEntity = null;
		SupplierBean supplierBean = new SupplierBean();
		try {
			supplierEntity = (SupplierEntity) sessionFactory.getCurrentSession()
					.createQuery("from SupplierEntity where supplierId=" + supplierId).list().get(0);

			supplierBean.setFirstName(supplierEntity.getFirstName());
			supplierBean.setSupplierId(supplierEntity.getSupplierId());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return supplierBean;
	}

	@Override
	public List<SupplierBean> fetchAllSuppliers() throws ApplicationException {
		
		List<SupplierBean> supplierDetails = null;
		try {
			List supplierList = sessionFactory.getCurrentSession().createQuery("from SupplierEntity").list();
			supplierDetails = new ArrayList();

			for (int i = 0; i < supplierList.size(); i++) {
				SupplierBean supplierBean = new SupplierBean();
				SupplierEntity supplierEntity = (SupplierEntity) supplierList.get(i);

				supplierBean.setSupplierId(supplierEntity.getSupplierId());
				supplierBean.setFirstName(supplierEntity.getFirstName());
				supplierBean.setSupplierStatus(supplierEntity.getSupplierStatus());

				supplierDetails.add(supplierBean);
			}
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return supplierDetails;
	}

	@Override
	public void updateSupplierStatus(SupplierBean supplierBean) throws ApplicationException {
		
		SupplierEntity supplierEntity = new SupplierEntity();
		try {
			supplierEntity.setSupplierId(supplierBean.getSupplierId());
			SupplierEntity entity = (SupplierEntity) sessionFactory.getCurrentSession().get(SupplierEntity.class,
					supplierEntity.getSupplierId());
			entity.setSupplierStatus(supplierBean.getSupplierStatus());
			sessionFactory.getCurrentSession().update(entity);
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
	}

	@Override
	public List<SupplierBean> fetchSupplier(String status) throws ApplicationException {
		
		List<SupplierBean> supplierDetails = null;
		try {
			List supplierList = sessionFactory.getCurrentSession()
					.createQuery("from SupplierEntity where supplierStatus='" + status + "'").list();
			supplierDetails = new ArrayList();

			for (int i = 0; i < supplierList.size(); i++) {
				
				SupplierBean supplierBean = new SupplierBean();
				SupplierEntity supplierEntity = (SupplierEntity) supplierList.get(i);

				supplierBean.setSupplierId(supplierEntity.getSupplierId());
				supplierBean.setFirstName(supplierEntity.getFirstName());
				supplierBean.setSupplierStatus(supplierEntity.getSupplierStatus());

				supplierDetails.add(supplierBean);
				
			}
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return supplierDetails;
	}
}
