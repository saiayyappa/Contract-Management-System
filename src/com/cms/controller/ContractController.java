package com.cms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cms.bean.ContractBean;
import com.cms.bean.SupplierBean;
import com.cms.exception.ApplicationException;
import com.cms.service.AmenityService;
import com.cms.service.ContractService;
import com.cms.service.SupplierService;
import com.cms.service.TermsAndConditionsService;

@Controller
public class ContractController {

	@Autowired
	ContractService contractService;
	@Autowired
	TermsAndConditionsService tacService;
	@Autowired
	AmenityService amenityService;
	@Autowired
	SupplierService supplierService;

	static Logger log = Logger.getLogger("ContractMgmt");

	@RequestMapping(value = "/addContract", method = RequestMethod.GET)
	public ModelAndView addContract(@RequestParam("supplierId") int supplierId,
			@ModelAttribute("command") ContractBean contractBean, BindingResult result, HttpSession session) {
		ModelAndView mav = null;
		if (session.getAttribute("supplierBean") != null && contractBean != null) {

			List<ContractBean> contractList, contractList1 = new ArrayList<ContractBean>();
			int id = 0;

			try {

				id = contractService.addContract(contractBean);
				tacService.addTac(contractBean);
				amenityService.addAmenity(contractBean);
				contractList = contractService.listContract();

				for (ContractBean contract : contractList) {
					if (contract.getSupplierId() == supplierId)
						contractList1.add(contract);
				}
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("contractList", contractList1);
				model.put("addMessage", "Contract created successfully");

				if (id != 0)
					mav = new ModelAndView("supplier", model);
				else
					mav = new ModelAndView("error");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}

		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/fetchContract", method = RequestMethod.GET)
	public ModelAndView fetchContract(@RequestParam("contractId") int contractId, HttpSession session) {
		ModelAndView mav = null;
		if (session.getAttribute("supplierBean") != null) {

			ContractBean contractBean = new ContractBean();
			try {

				contractBean = contractService.fetchContract(contractId);

				if (contractBean != null)
					mav = new ModelAndView("editContract", "contractBean", contractBean);
				else
					mav = new ModelAndView("error");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}
		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/updateContract", method = RequestMethod.GET)
	public ModelAndView updateContract(@RequestParam("supplierId") int supplierId,
			@ModelAttribute("command") ContractBean contractBean, BindingResult result, HttpSession session) {
		ModelAndView mav = null;
		if (session.getAttribute("supplierBean") != null) {

			List<ContractBean> contractList, contractList1 = new ArrayList<ContractBean>();

			int i = 0;
			try {
				i = contractService.updateContract(contractBean);
				tacService.updateTac(contractBean);
				amenityService.updateAmenity(contractBean);

				contractList = contractService.listContract();

				for (ContractBean contract : contractList) {
					if (contract.getSupplierId() == supplierId)
						contractList1.add(contract);
				}

				Map<String, Object> model = new HashMap<String, Object>();
				model.put("contractList", contractList1);
				model.put("editMessage", "Contract updated successfully");

				if (i != 0)
					mav = new ModelAndView("supplier", model);
				else
					mav = new ModelAndView("error");

			} catch (ApplicationException ae) {

				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");

			}

		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/deleteContract", method = RequestMethod.GET)
	public ModelAndView deleteContract(@RequestParam("contractId") int contractId,
			@RequestParam("supplierId") int supplierId, HttpSession session) {

		ModelAndView mav = null;

		if (session.getAttribute("supplierBean") != null) {

			List<ContractBean> contractList, contractList1 = new ArrayList<ContractBean>();
			int i = 0;

			try {
				if (session.getAttribute("supplierBean") == null) {
					mav = new ModelAndView("about");
				}

				i = contractService.deleteContract(contractId);
				contractList = contractService.listContract();

				for (ContractBean contract : contractList) {
					if (contract.getSupplierId() == supplierId)
						contractList1.add(contract);
				}

				if (i != 0) {
					if (contractList1.size() != 0)
						mav = new ModelAndView("supplier", "contractList", contractList1);
					else
						mav = new ModelAndView("supplier", "recordMessage", "No Records Found");
				} else
					mav = new ModelAndView("error");
				
			} catch (ApplicationException ae) {
				
				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");
				
			}
		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/viewContract")
	public ModelAndView viewContract(@RequestParam("supplierId") int supplierId, HttpSession session) {
		
		ModelAndView mav = null;
		
		if (session.getAttribute("supplierBean") != null) {
			
			SupplierBean supplierBean = new SupplierBean();
			List<ContractBean> contractList, contractList1 = new ArrayList<ContractBean>();
			ContractBean contractBean = new ContractBean();

			try {
				contractList = contractService.listContract();
				
				for (ContractBean contract : contractList) {
					if (contract.getSupplierId() == supplierId)
						contractList1.add(contract);
				}
				
				supplierBean = supplierService.fetchSupplier(supplierId);
				session.setAttribute("supplierBean", supplierBean);
				
				if (contractList1.size() != 0)
					mav = new ModelAndView("supplier", "contractList", contractList1);
				else
					mav = new ModelAndView("supplier", "recordMessage", "No Records Found");
				
			} catch (ApplicationException ae) {
				
				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");
				
			}
			
		} else {
			mav = new ModelAndView("about");
		}
		return mav;

	}

	@RequestMapping(value = "/updateContractStatus")
	public ModelAndView updateContractStatus(@ModelAttribute("command") ContractBean contractBean, BindingResult result,
			HttpSession session) {
		
		ModelAndView mav = null;
		
		if (session.getAttribute("adminBean") != null) {
			
			List contractList = new ArrayList<ContractBean>();
			Map<String, Object> model = new HashMap<String, Object>();

			try {
				contractService.updateContractStatus(contractBean);
				contractList = contractService.fetchAllContracts();
				
				model.put("contractList", contractList);
	
			} catch (ApplicationException ae) {
				
				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");
				
			}
			mav = new ModelAndView("manageContract", model);
			
		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/fetchContractUsingStatus")
	public ModelAndView fetchContractUsingStatus(@RequestParam("contractStatus") String contractStatus,
			HttpSession session) {
		
		ModelAndView mav = null;
		
		if (session.getAttribute("adminBean") != null) {
			
			List<ContractBean> contractList = new ArrayList<ContractBean>();
			try {
				contractList = contractService.fetchContractUsingStatus(contractStatus);
				
				if (contractList.size() != 0)
					mav = new ModelAndView("manageContract", "contractList", contractList);
				else
					mav = new ModelAndView("manageContract", "recordMessage", "No Records Found");
			
			} catch (ApplicationException ae) {
				
				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");
				
			}
		} else {
			mav = new ModelAndView("about");
		}
		return mav;
	}

	@RequestMapping(value = "/fetchContractForAdmin")
	public ModelAndView fetchContractForAdmin(HttpSession session) throws ApplicationException {
		
		ModelAndView mav = null;
		
		if (session.getAttribute("adminBean") != null) {
			
			List<ContractBean> contractBean = new ArrayList<ContractBean>();
			
			try {
				
				contractBean = contractService.listContract();
				
				if (contractBean.size() != 0)
					mav = new ModelAndView("manageContract", "contractList", contractBean);
				else
					mav = new ModelAndView("manageContract", "recordMessage", "No Records Found");
			
			} catch (ApplicationException ae) {
				
				log.info(ae.getMessage());
				mav = new ModelAndView("applicationError");
				
			}
		
		} else {
			mav = new ModelAndView("about");
		}

		return mav;
	}
}
