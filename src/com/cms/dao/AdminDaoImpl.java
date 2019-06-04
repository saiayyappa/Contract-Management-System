package com.cms.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cms.bean.AdminBean;
import com.cms.entity.AdminEntity;
import com.cms.exception.ApplicationException;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addAdmin(AdminBean adminBean) throws ApplicationException {
		// TODO Auto-generated method stub
		int id = 0;
		
		try {
			AdminEntity adminEntity = new AdminEntity();
			adminEntity.setFirstName(adminBean.getFirstName());
			adminEntity.setLastName(adminBean.getLastName());
			adminEntity.setAge(adminBean.getAge());
			adminEntity.setGender(adminBean.getGender());
			adminEntity.setDob(adminBean.getDob());
			adminEntity.setContactNumber(adminBean.getContactNumber());
			adminEntity.setAltContactNumber(adminBean.getAltContactNumber());
			adminEntity.setEmailId(adminBean.getEmailId());
			adminEntity.setPassword(adminBean.getPassword());

			sessionFactory.getCurrentSession().saveOrUpdate(adminEntity);

			adminEntity = (AdminEntity) sessionFactory.getCurrentSession().get(AdminEntity.class,
					adminEntity.getAdminId());
			id = adminEntity.getAdminId();
			
		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}
		return id;
	}

	@Override
	public AdminBean loginAdminCheck(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		
		AdminEntity adminEntity = null;
		AdminBean adminBean = new AdminBean();
		
		try {
			List list = (List) sessionFactory.getCurrentSession()
					.createQuery("from AdminEntity where adminId='" + id + "'").list();

			if (list != null && list.size() > 0) {
				adminEntity = (AdminEntity) list.get(0);
				adminBean.setAdminId(adminEntity.getAdminId());
				adminBean.setFirstName(adminEntity.getFirstName());
				adminBean.setPassword(adminEntity.getPassword());
			} else
				return adminBean;

		} catch (HibernateException he) {
			ApplicationException ae = new ApplicationException(-1, he.getMessage());
			throw ae;
		}

		return adminBean;
	}
}
