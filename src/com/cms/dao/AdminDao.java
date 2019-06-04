package com.cms.dao;

import com.cms.bean.AdminBean;
import com.cms.exception.ApplicationException;

public interface AdminDao {

	public int addAdmin(AdminBean adminBean) throws ApplicationException;
	
	public AdminBean loginAdminCheck(int id) throws ApplicationException;

}
