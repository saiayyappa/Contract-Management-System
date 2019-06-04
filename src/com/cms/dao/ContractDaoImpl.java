package com.cms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.bean.ContractBean;
import com.cms.bean.SupplierBean;
import com.cms.entity.AmenityEntity;
import com.cms.entity.ContractEntity;
import com.cms.entity.SupplierEntity;
import com.cms.entity.TermsAndConditionsEntity;
import com.cms.exception.ApplicationException;

@Repository("contractDao")
public class ContractDaoImpl implements ContractDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addContract(ContractBean contractBean)  throws ApplicationException{
		
		int id = 0;
	
		try {
			ContractEntity contractEntity = new ContractEntity();

			contractEntity.setContractDesc(contractBean.getContractDesc());
			contractEntity.setContractProDate(contractBean.getContractProDate());
			contractEntity.setContractSubDate(contractBean.getContractSubDate());
			contractEntity.setContractStatus(contractBean.getContractStatus());
			contractEntity.setSupplierId(contractBean.getSupplierId());

			sessionFactory.getCurrentSession().saveOrUpdate(contractEntity);

			contractEntity = (ContractEntity) sessionFactory.getCurrentSession().get(ContractEntity.class,
					contractEntity.getContractId());

			id = contractEntity.getContractId();

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return id;
	}

	@Override
	public List<ContractBean> listContract() throws ApplicationException{
		
		List<ContractBean> contractDetails = null;

		try {
			
			List list1 = sessionFactory.getCurrentSession().createQuery("from ContractEntity").list();
			List list2 = sessionFactory.getCurrentSession().createQuery("from TermsAndConditionsEntity").list();
			List list3 = sessionFactory.getCurrentSession().createQuery("from AmenityEntity").list();
			contractDetails = new ArrayList();

			for (int i = 0; i < list1.size(); i++) {

				ContractBean contractBean = new ContractBean();
				ContractEntity contractEntity = (ContractEntity) list1.get(i);
				TermsAndConditionsEntity tacEntity = (TermsAndConditionsEntity) list2.get(i);
				AmenityEntity amenityEntity = (AmenityEntity) list3.get(i);

				contractBean.setContractId(contractEntity.getContractId());
				contractBean.setContractDesc(contractEntity.getContractDesc());
				contractBean.setContractSubDate(contractEntity.getContractSubDate());
				contractBean.setContractProDate(contractEntity.getContractProDate());
				contractBean.setContractStatus(contractEntity.getContractStatus());
				contractBean.setSupplierId(contractEntity.getSupplierId());
				contractBean.setCondition1(tacEntity.getCondition1());
				contractBean.setCondition2(tacEntity.getCondition2());
				contractBean.setCondition3(tacEntity.getCondition3());
				contractBean.setTerm1(tacEntity.getTerm1());
				contractBean.setTerm2(tacEntity.getTerm2());
				contractBean.setTerm3(tacEntity.getTerm3());
				contractBean.setAmenity1(amenityEntity.getAmenity1());
				contractDetails.add(contractBean);
			}

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return contractDetails;
	}

	@Override
	public ContractBean fetchContract(int contractId) throws ApplicationException{
		
		ContractBean contractBean = null;
		try {
			contractBean = new ContractBean();
			ContractEntity contractEntity = (ContractEntity) sessionFactory.getCurrentSession()
					.createQuery("from ContractEntity where contractId=" + contractId).list().get(0);
			TermsAndConditionsEntity tacEntity = (TermsAndConditionsEntity) sessionFactory.getCurrentSession()
					.createQuery("from TermsAndConditionsEntity where contractId=" + contractId).list().get(0);
			AmenityEntity amenityEntity = (AmenityEntity) sessionFactory.getCurrentSession()
					.createQuery("from AmenityEntity where contractId=" + contractId).list().get(0);

			contractBean.setContractId(contractEntity.getContractId());
			contractBean.setContractDesc(contractEntity.getContractDesc());
			contractBean.setContractSubDate(contractEntity.getContractSubDate());
			contractBean.setContractProDate(contractEntity.getContractProDate());
			contractBean.setContractStatus(contractEntity.getContractStatus());
			contractBean.setSupplierId(contractEntity.getSupplierId());
			contractBean.setCondition1(tacEntity.getCondition1());
			contractBean.setCondition2(tacEntity.getCondition2());
			contractBean.setCondition3(tacEntity.getCondition3());
			contractBean.setTerm1(tacEntity.getTerm1());
			contractBean.setTerm2(tacEntity.getTerm2());
			contractBean.setTerm3(tacEntity.getTerm3());
			contractBean.setAmenity1(amenityEntity.getAmenity1());

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return contractBean;
	}

	@Override
	public int updateContract(ContractBean contractBean) throws ApplicationException {
		int id = 1;
		
		try {
			ContractEntity contractEntity = new ContractEntity();
			TermsAndConditionsEntity tacEntity = new TermsAndConditionsEntity();
			AmenityEntity amenityEntity = new AmenityEntity();

			contractEntity.setContractId(contractBean.getContractId());
			contractEntity.setContractDesc(contractBean.getContractDesc());
			contractEntity.setContractProDate(contractBean.getContractProDate());
			contractEntity.setContractSubDate(contractBean.getContractSubDate());
			contractEntity.setContractStatus(contractBean.getContractStatus());
			contractEntity.setSupplierId(contractBean.getSupplierId());
			tacEntity.setContractId(contractBean.getContractId());
			tacEntity.setCondition1(contractBean.getCondition1());
			tacEntity.setCondition2(contractBean.getCondition2());
			tacEntity.setCondition3(contractBean.getCondition3());
			tacEntity.setTerm1(contractBean.getTerm1());
			tacEntity.setTerm2(contractBean.getTerm2());
			tacEntity.setTerm3(contractBean.getTerm3());
			amenityEntity.setAmenity1(contractBean.getAmenity1());
			amenityEntity.setContractId(contractBean.getContractId());

			sessionFactory.getCurrentSession().update(contractEntity);
			sessionFactory.getCurrentSession().update(tacEntity);
			sessionFactory.getCurrentSession().update(amenityEntity);

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return id;
	}

	@Override
	public int deleteContract(int contractId) throws ApplicationException {
		
		try {
			ContractEntity contractEntity = new ContractEntity();
			TermsAndConditionsEntity tacEntity = new TermsAndConditionsEntity();
			AmenityEntity amenityEntity = new AmenityEntity();

			contractEntity.setContractId(contractId);
			tacEntity.setContractId(contractId);
			amenityEntity.setContractId(contractId);

			sessionFactory.getCurrentSession().delete(contractEntity);
			sessionFactory.getCurrentSession().delete(tacEntity);
			sessionFactory.getCurrentSession().delete(amenityEntity);

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return 1;
	}

	@Override
	public void updateContractStatus(ContractBean contractBean) throws ApplicationException {
		
		ContractEntity contractEntity = new ContractEntity();
		try{
			contractEntity.setContractId(contractBean.getContractId());
			ContractEntity entity = (ContractEntity) sessionFactory.getCurrentSession().get(ContractEntity.class, contractEntity.getContractId());
			entity.setContractStatus(contractBean.getContractStatus());	
			sessionFactory.getCurrentSession().update(entity);
			
			//contractBean.setContractId(contractEntity.getContractId());
			//contractBean.setSupplierId(contractEntity.getSupplierId());
		}catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		
	}

	@Override
	public List<ContractBean> fetchContractUsingStatus(String contractStatus) throws ApplicationException {
		
		List<ContractBean> contractDetails = null;
		try {
			List contractList = sessionFactory.getCurrentSession()
					.createQuery("from ContractEntity where contractStatus='"+contractStatus+"' order by supplierId").list();
			contractDetails = new ArrayList();
			
			for (int i = 0; i < contractList.size(); i++) {
				ContractBean contractBean = new ContractBean();
				ContractEntity contractEntity = (ContractEntity) contractList.get(i);
				
				contractBean.setSupplierId(contractEntity.getSupplierId());
				contractBean.setContractId(contractEntity.getContractId());
				contractBean.setContractDesc(contractEntity.getContractDesc());
				contractBean.setContractStatus(contractEntity.getContractStatus());

				contractDetails.add(contractBean);
			}
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return contractDetails;
	}

	@Override
	public List<ContractBean> fetchAllContracts() throws ApplicationException {

		List<ContractBean> contractDetails = null;
		try {
			List contractList = sessionFactory.getCurrentSession()
					.createQuery("from ContractEntity order by supplierId").list();
			contractDetails = new ArrayList();
			
			for (int i = 0; i < contractList.size(); i++) {
				ContractBean contractBean = new ContractBean();
				ContractEntity contractEntity = (ContractEntity) contractList.get(i);

				contractBean.setSupplierId(contractEntity.getSupplierId());
				contractBean.setContractId(contractEntity.getContractId());
				contractBean.setContractDesc(contractEntity.getContractDesc());
				contractBean.setContractStatus(contractEntity.getContractStatus());

				contractDetails.add(contractBean);
			}
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return contractDetails;
	}

}
