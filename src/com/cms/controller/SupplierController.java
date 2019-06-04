package com.cms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cms.bean.SupplierBean;
import com.cms.exception.ApplicationException;
import com.cms.service.ContractService;
import com.cms.service.SupplierService;

@SessionAttributes("supplierBean")
@Controller
public class SupplierController {
	@Autowired
	SupplierService supplierService;

	@Autowired
	ContractService contractService;

	static Logger log = Logger.getLogger("ContractMgmt");

	@RequestMapping(value = "/loginSupplier", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView loginSupplier(@ModelAttribute("command") SupplierBean supplierBean1, HttpSession session) {

		ModelAndView mav = null;
		SupplierBean supplierBean = null;

		try {

			supplierBean = supplierService.loginSupplierCheck(supplierBean1.getSupplierId());

			if (supplierBean1.getPassword().equals(supplierBean.getPassword())
					&& supplierBean1.getSupplierId() == supplierBean.getSupplierId()) {

				if ((supplierBean.getSupplierStatus().equals("APPROVED"))) {
					session.setAttribute("supplierBean", supplierBean);
					mav = new ModelAndView("supplier");
				}

				else if ((supplierBean.getSupplierStatus().equals("REJECTED")))
					mav = new ModelAndView("supplierLogin", "message", "Login denied by Admin");

				else
					mav = new ModelAndView("supplierLogin", "message",
							"Wait for approval from Admin in order to login");
			} else
				mav = new ModelAndView("supplierLogin", "message", "Invalid Username or Password");

		} catch (ApplicationException ae) {

			log.info(ae.getMessage());
			mav = new ModelAndView("applicationError");

		}

		return mav;
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView saveSupplier(@ModelAttribute("command") SupplierBean supplierBean, BindingResult result,
			HttpSession session) {

		ModelAndView mav = null;

		int id = 0;

		try {

			id = supplierService.addSupplier(supplierBean);

			if (id != 0)
				mav = new ModelAndView("supplierLogin", "successMessage",
						"Successfully registered. Use this ID: " + id + " to login.");
			else
				mav = new ModelAndView("error");

		} catch (ApplicationException ae) {

			log.info(ae.getMessage());
			mav = new ModelAndView("applicationError");

		}

		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {

		session.invalidate();

		return new ModelAndView("about");
	}

	@RequestMapping(value = "/fetchAllSuppliers")
	public ModelAndView fetchAllSuppliers(HttpServletRequest request, HttpSession session) {

		ModelAndView mav = null;

		if (session.getAttribute("adminBean") != null) {

			List<SupplierBean> supplierList = new ArrayList<SupplierBean>();

			try {
				supplierList = supplierService.fetchAllSuppliers();

				request.setAttribute("supplierList", supplierList);

				if (supplierList.size() != 0)
					mav = new ModelAndView("manageSupplier", "supplierList", supplierList);
				else
					mav = new ModelAndView("manageSupplier", "recordMessage", "No Records Found");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}
		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/fetchSupplier")
	public ModelAndView fetchSupplier(@RequestParam("supplierStatus") String status, HttpSession session) {

		ModelAndView mav = null;

		if (session.getAttribute("adminBean") != null) {

			List<SupplierBean> supplierList = new ArrayList<SupplierBean>();

			try {

				supplierList = supplierService.fetchSupplier(status);

				if (supplierList.size() != 0)
					mav = new ModelAndView("manageSupplier", "supplierList", supplierList);
				else
					mav = new ModelAndView("manageSupplier", "recordMessage", "No Records Found");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}

		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/updateSupplierStatus")
	public ModelAndView updateSupplierStatus(HttpServletRequest request,
			@ModelAttribute("command") SupplierBean supplierBean, BindingResult result, HttpSession session) {

		ModelAndView mav = null;

		List<SupplierBean> supplierList = new ArrayList<SupplierBean>();

		if (session.getAttribute("adminBean") != null) {

			try {
				supplierService.updateSupplierStatus(supplierBean);
				supplierList = supplierService.fetchAllSuppliers();

				request.setAttribute("supplierList", supplierList);

				if (supplierList.size() != 0)
					mav = new ModelAndView("manageSupplier", "supplierList", supplierList);
				else
					mav = new ModelAndView("manageSupplier", "recordMessage", "No Records Found");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}

			mav = new ModelAndView("manageSupplier");

		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

}
