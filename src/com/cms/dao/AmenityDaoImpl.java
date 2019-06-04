package com.cms.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.bean.ContractBean;
import com.cms.entity.AmenityEntity;
import com.cms.exception.ApplicationException;

@Repository("amenityDao")
public class AmenityDaoImpl implements AmenityDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public int addAmenity(ContractBean contractBean) throws ApplicationException{
		// TODO Auto-generated method stub
		try {
			AmenityEntity amenityEntity = new AmenityEntity();
			
			amenityEntity.setAmenity1(contractBean.getAmenity1());

			sessionFactory.getCurrentSession().saveOrUpdate(amenityEntity);
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return 1;
	}

	@Override
	public int updateAmenity(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			AmenityEntity amenityEntity = new AmenityEntity();

			amenityEntity.setContractId(contractBean.getContractId());
			amenityEntity.setAmenity1(contractBean.getAmenity1());

			sessionFactory.getCurrentSession().update(amenityEntity);

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return 1;
	}

}
