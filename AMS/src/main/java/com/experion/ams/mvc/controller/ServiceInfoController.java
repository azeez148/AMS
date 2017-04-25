package com.experion.ams.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.data.ServiceInfoForm;
import com.experion.ams.service.AmsService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.ServiceInfoService;
import com.experion.ams.util.AMSUtil;
import com.google.gson.Gson;

/**
 * 
 * @author surya
 * 
 */
@Controller
@RequestMapping("/login/*")
public class ServiceInfoController {
	private String message = "";
	private static final String SERVICEINFO_PAGE = "/AMS_ServiceInfo";
	private static final Log log = LogFactory
			.getLog(ServiceInfoController.class);

	@Inject
	@Named(value = "serviceinfoService")
	private ServiceInfoService serviceinfoService;

	@Inject
	@Named(value = "messageSource")
	private MessageSource messageSource;

	public ServiceInfoService getServiceInfoService() {
		return serviceinfoService;
	}

	public void setServiceInfoService(ServiceInfoService serviceinfoService) {
		this.serviceinfoService = serviceinfoService;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	/**
	 * This method will be invoked at the initial time when we click the service
	 * info tab.
	 * 
	 * @param serviceInfoForm
	 * @param result
	 * @param request
	 * @param model
	 * @return
	 */
	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;
	
	@RequestMapping(value = "serviceInfo", method = RequestMethod.GET)
	public ModelAndView serviceInfo(
			@ModelAttribute("serviceInfoForm") ServiceInfoForm serviceInfoForm,
			BindingResult result, HttpServletRequest request,HttpSession session,Model model) {
		String message = "";
		List<Asset> asset = serviceinfoService.getAssetList();
		List<SystemParametersCodeMaster> codemaster = serviceinfoService.getServiceProvider();
		model.addAttribute("assetData", asset);
		model.addAttribute("codemaster", codemaster);
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		if (!this.message.equals("")) {

			message = this.message;
			this.message = "";
			if ("Updated Successfully".trim().equals(message)) {
				return new ModelAndView(SERVICEINFO_PAGE, "successmessage",
						message);
			} else {
				return new ModelAndView(SERVICEINFO_PAGE, "failuremessage",
						message);
			}
		} else {

			return new ModelAndView(SERVICEINFO_PAGE);
		}

	}
	
	/**
	 *  This method is loaded when we click the search button in service info page
	 * @param serviceInfoForm
	 * @param request
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/searchAssetNumber", method = RequestMethod.POST)
	public ModelAndView searchAssetNumber(
			@ModelAttribute("serviceInfoForm") ServiceInfoForm serviceInfoForm,
			HttpServletRequest request,HttpSession session,Model model) {
		String assetNumber = serviceInfoForm.getAssetNo();
		if (!"".equals(assetNumber)) {
			List<Asset> asset = serviceinfoService
					.getAssetByNumber(assetNumber);
			model.addAttribute("assetData", asset);
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(SERVICEINFO_PAGE);
	}
	
	/**
	 *  This method is invoked when the service info link is clicked. Corresponding service info details
	 *  	are fetched from database
	 * @param serviceInfoForm
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/fetchServiceData", method = RequestMethod.GET)
	public @ResponseBody
	String getServiceInfoDetails(
			@ModelAttribute("serviceInfoForm") ServiceInfoForm serviceInfoForm,
			HttpServletRequest request) {
		Gson gson = new Gson();
		ServiceInfo serviceinfo = serviceinfoService
				.getServiceInfoByAssetCode(Integer.parseInt(request
						.getParameter("assetid")));
		ServiceInfoForm serviceinfoform = serviceInfoFormConvertor(serviceinfo);
		String json = gson.toJson(serviceinfoform);
		return json;
	}

	@RequestMapping(value = "/searchAssetNumber", method = RequestMethod.GET)
	public @ResponseBody
	String fetchData(HttpServletRequest request) {

		Gson gson = new Gson();
		List<SystemParametersCodeMaster> codemaster = serviceinfoService.getServiceProvider();
		String json = gson.toJson(codemaster);
		return json;
	}

	/**
	 * This controller is used to upadte service info details in
	 * ams_service_info table
	 * 
	 * @param request
	 * @return
	 */

	@RequestMapping(value = "/saveServiceInfo", method = RequestMethod.POST)
	public ModelAndView saveServiceInfo(
			@Valid @ModelAttribute("serviceInfoForm") ServiceInfoForm serviceInfoForm,
			BindingResult result, Model model, HttpServletRequest request,HttpSession session) {
		long EmployeeCode = Long.parseLong(request.getSession().getAttribute("empCode").toString());
		//Integer EmployeeId=(int)(long)serviceinfoService.getEmployeeId(EmployeeCode);
		
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		Integer EmployeeId = (int)employeeCode;
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		if (result.hasErrors()) {
			message = "Upadation failed no feild should be empty";
			return new ModelAndView("redirect:/login/serviceInfo.html");

		} else {
			try {
			
				serviceInfoForm.setSiUpdatedBy(EmployeeId);
				ServiceInfo serviceInfo = serviceInfoConvertor(serviceInfoForm);
				/*System.out.println(serviceInfoForm.getSiServiceProviderCode()
						+ "dsdsd");*/
				serviceinfoService.updateServiceInfo(serviceInfo);
				message = "Updated Successfully";
			} catch (Exception e) {
				message = "Upadation Failed";
			}

			return new ModelAndView("redirect:/login/serviceInfo.html");
		}
	}

	/**
	 *  		Method convert ServiceInfoForm class to ServiceInfo
	 * @param serviceInfoForm
	 * @return
	 */
	private ServiceInfo serviceInfoConvertor(ServiceInfoForm serviceInfoForm) {
		ServiceInfo serviceinfo = new ServiceInfo();
		
		serviceinfo.setSiId((serviceInfoForm.getSiId()));

		serviceinfo.setSiServiceProviderCd(serviceInfoForm
				.getSiServiceProviderCode());
		serviceinfo.setSiContractNumber(serviceInfoForm.getSiContractNumber());
		serviceinfo.setSiNoServicesYear(serviceInfoForm.getSiNoServicesYear());

		serviceinfo.setSiLastServiceDate(stringToDateConversion(serviceInfoForm
				.getSiLastServiceDate()));
		serviceinfo.setSiNextServiceDate(stringToDateConversion(serviceInfoForm
				.getSiNextServiceDate()));
		
		serviceinfo.setSiUpdatedBy(serviceInfoForm.getSiUpdatedBy());
		serviceinfo.setSiUpdatedDate(new Date());
		return serviceinfo;
	}

	/**
	 * 		Method convert string to date
	 * @param dateString
	 * @return
	 */
	private Date stringToDateConversion(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateString);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 				Method convert ServiceInfo class to ServiceInfoForm
	 * @param serviceinfo
	 * @return
	 */
	private ServiceInfoForm serviceInfoFormConvertor(ServiceInfo serviceinfo) {

		ServiceInfoForm serviceinfoform = new ServiceInfoForm();
		serviceinfoform.setSiId(serviceinfo.getSiId());
		serviceinfoform.setSiComValue(serviceinfo.getComValueSP());
		serviceinfoform.setSiServiceProviderCode(serviceinfo
				.getSiServiceProviderCd());
		serviceinfoform.setSiContractNumber(serviceinfo.getSiContractNumber());
		serviceinfoform.setSiNoServicesYear(serviceinfo.getSiNoServicesYear());
		serviceinfoform.setSiLastServiceDate(dateToString(serviceinfo
				.getSiLastServiceDate()));
		serviceinfoform.setSiNextServiceDate(dateToString(serviceinfo
				.getSiNextServiceDate()));
		return serviceinfoform;
	}

	/**
	 * 			Method convert date to string
	 * @param indate
	 * @return
	 */
	private String dateToString(Date indate) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-MM-dd");

		try {
			dateString = sdfr.format(indate);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
