package com.cms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cms.bean.AdminBean;
import com.cms.dao.AdminDao;
import com.cms.exception.ApplicationException;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public int addAdmin(AdminBean adminBean) throws ApplicationException {
		// TODO Auto-generated method stub

		return adminDao.addAdmin(adminBean);
	}

	@Override
	public AdminBean loginAdminCheck(int id) throws ApplicationException {
		// TODO Auto-generated method stub
		return adminDao.loginAdminCheck(id);
	}

	
}
