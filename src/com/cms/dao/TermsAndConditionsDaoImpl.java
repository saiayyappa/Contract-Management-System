package com.cms.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.bean.ContractBean;
import com.cms.entity.TermsAndConditionsEntity;
import com.cms.exception.ApplicationException;

@Repository("tacDao")
public class TermsAndConditionsDaoImpl implements TermsAndConditionsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addTac(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		try {
			TermsAndConditionsEntity tacEntity = new TermsAndConditionsEntity();
			
			tacEntity.setCondition1(contractBean.getCondition1());
			tacEntity.setTerm1(contractBean.getTerm1());
			tacEntity.setCondition2(contractBean.getCondition2());
			tacEntity.setTerm2(contractBean.getTerm2());
			tacEntity.setCondition3(contractBean.getCondition3());
			tacEntity.setTerm3(contractBean.getTerm3());

			sessionFactory.getCurrentSession().saveOrUpdate(tacEntity);
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return 1;
	}

	@Override
	public int updateTac(ContractBean contractBean) throws ApplicationException {
		// TODO Auto-generated method stub
		try {
			TermsAndConditionsEntity tacEntity = new TermsAndConditionsEntity();

			tacEntity.setContractId(contractBean.getContractId());
			tacEntity.setCondition1(contractBean.getCondition1());
			tacEntity.setCondition2(contractBean.getCondition2());
			tacEntity.setCondition3(contractBean.getCondition3());
			tacEntity.setTerm1(contractBean.getTerm1());
			tacEntity.setTerm2(contractBean.getTerm2());
			tacEntity.setTerm3(contractBean.getTerm3());

			sessionFactory.getCurrentSession().update(tacEntity);

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return 1;
	}

//	@Override
////	public ContractBean fetchTermsAndConditions(int contractId) {
//		// TODO Auto-generated method stub
//		ContractBean tacBean = new ContractBean();
//
//		try {
//			TermsAndConditionsEntity tacEntity = new TermsAndConditionsEntity();
//
//			tacEntity = (TermsAndConditionsEntity) sessionFactory.getCurrentSession()
//					.createQuery("from TermsAndConditionsEntity where contractId=" + contractId).list().get(0);
//			tacBean.setContractId(tacEntity.getContractId());
//			tacBean.setTerm1(tacEntity.getTerm1());
//			tacBean.setCondition1(tacEntity.getCondition1());
//			tacBean.setTerm2(tacEntity.getTerm2());
//			tacBean.setCondition2(tacEntity.getCondition2());
//			tacBean.setTerm3(tacEntity.getTerm3());
//			tacBean.setCondition3(tacEntity.getCondition3());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return tacBean;
//	}
	
}
