package com.cms.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.bean.AdminBean;
import com.cms.bean.ContractBean;
import com.cms.bean.SupplierBean;
import com.cms.exception.ApplicationException;
import com.cms.service.AdminService;
import com.cms.service.ContractService;
import com.cms.service.SupplierService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	SupplierService supplierService;

	@Autowired
	ContractService contractService;

	static Logger log = Logger.getLogger("ContractMgmt");

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ModelAndView saveAdmin(@ModelAttribute("command") AdminBean adminBean, BindingResult result,
			HttpSession session) {
		ModelAndView mav = null;
		int id = 0;

		try {

			id = adminService.addAdmin(adminBean);

		} catch (ApplicationException ae) {

			log.info(ae.getMessage());
			mav = new ModelAndView("applicationError");

		}

		mav = new ModelAndView("adminLogin", "successMessage1", "Successfully registered. Use this ID: " + id + " to login.");
		return mav;
	}

	@RequestMapping(value = "/loginAdmin", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginAdmin(@ModelAttribute("command") AdminBean adminBean1, BindingResult result,
			HttpSession session) {
		ModelAndView mav = null;
		AdminBean adminBean = null;

		List contractList = new ArrayList<ContractBean>();
		Map<String, Object> model = new HashMap<String, Object>();
		try {
			adminBean = adminService.loginAdminCheck(adminBean1.getAdminId());
			session.setAttribute("adminBean", adminBean);
		
			if (adminBean1.getPassword().equals(adminBean.getPassword())
					&& adminBean1.getAdminId() == (adminBean.getAdminId())) {
				contractList = contractService.fetchAllContracts();

				model.put("contractList", contractList);
				model.put("AdminName", adminBean1.getFirstName());

				mav = new ModelAndView("admin", model);

			} else
				mav = new ModelAndView("adminLogin", "message1", "Invalid Username or Password");

		} catch (ApplicationException ae) {

			log.info(ae.getMessage());
			mav = new ModelAndView("applicationError");

		}

		return mav;
	}
}
