package com.cms.service;

import com.cms.bean.AdminBean;
import com.cms.exception.ApplicationException;

public interface AdminService {

	public int addAdmin(AdminBean adminBean) throws ApplicationException;
	
	public AdminBean loginAdminCheck(int id) throws ApplicationException;
	
	
}
