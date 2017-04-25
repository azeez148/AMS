package com.experion.ams.mvc.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.SystemParameterService;
import com.experion.ams.util.AMSUtil;
@Transactional
@Controller
@RequestMapping("/login/*")
public class SystemParameterController  {
	private static final String HOME_PAGE = "/home";
	private static final String SYSTEM_PARAMETER = "/systemparameter";

	
	// private static final String HOME_PAGE = "/AMS_ManageEmployee";

	private static final Log log = LogFactory.getLog(SystemParameterController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	/**
	 * 
	 * @param request
	 * @return
	 * 
	 *         This method will be invoked at the initial time when the
	 *         application is loaded.
	 * 
	 */
	

	@Inject
	@Named(value = "systemparametersservice")
	private SystemParameterService systemparametersservice;

	
	
	
	

	public SystemParameterService getSystemparametersservice() {
		return systemparametersservice;
	}
	public void setSystemparametersservice(
			SystemParameterService systemparametersservice) {
		this.systemparametersservice = systemparametersservice;
	}
	/**
	 * 
	 * @param request
	 * @return
	 * 
	 *         This method will be invoked at the initial time when the
	 *         application is loaded.
	 * 
	 */
	
	public void getPagination(SystemParametersCodeMaster frmlocation,
			HttpServletRequest request) {
System.out.println(frmlocation.getComType());
		String next = request.getParameter("next");
		String prev = request.getParameter("pre");
		String last = request.getParameter("last");
		String first = request.getParameter("first");

		int i = frmlocation.getPagecountHidden();
		int totalPage = systemparametersservice.getParameterSize(frmlocation.getComType());
		totalPage = (int) Math.ceil((double) totalPage / 5);
		totalPage *= 5;

		if (next != null) {
			i = i + 5;
			frmlocation.setPageNum(frmlocation.getPageNum() + 1);
			if (totalPage <= i) {
				i = i - 5;
				frmlocation.setPageNum(frmlocation.getPageNum() - 1);
			}
			frmlocation.setPagecountHidden(i);

		}

		else if (prev != null) {
			i = frmlocation.getPagecountHidden();
			i = i - 5;
			frmlocation.setPageNum(frmlocation.getPageNum() - 1);
			if (i < 0) {
				i = 0;
				frmlocation.setPageNum(1);

			}
			frmlocation.setPagecountHidden(i);
		}

		else if (last != null) {
			frmlocation.setPagecountHidden(totalPage - 5);
			frmlocation.setPageNum(totalPage / 5);
		} else {
			frmlocation.setPagecountHidden(0);
			frmlocation.setPageNum(1);
		}

	}
	
	
	
	@RequestMapping(value = "/systemparameter")
	public ModelAndView Showsystemparameter(Model model,HttpServletRequest request,HttpSession session, SystemParametersCodeMaster frmlocation) {
		
		
		model.addAttribute("locationlist",systemparametersservice.getSystemParameterList("LC", frmlocation.getPagecountHidden()));
		model.addAttribute("departmentlist",systemparametersservice.getSystemParameterList("DPT",frmlocation.getPagecountHidden()));
		model.addAttribute("serviceprolist",systemparametersservice.getSystemParameterList("SP",frmlocation.getPagecountHidden()));
		model.addAttribute("projectlist",systemparametersservice.getSystemParameterList("PRJ",frmlocation.getPagecountHidden()));
		model.addAttribute("vendorslist",systemparametersservice.getSystemParameterList("VNDR",frmlocation.getPagecountHidden()));
		model.addAttribute("makelist",systemparametersservice.getSystemParameterList("MK",frmlocation.getPagecountHidden()));
		
		model.addAttribute("masterlist",systemparametersservice.getMasterValue());
	
	
		
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		return new ModelAndView(SYSTEM_PARAMETER);
	}

	
	@RequestMapping(value = "/addLocation")
	public ModelAndView addLocation(@ModelAttribute("command") SystemParametersCodeMaster frmlocation, HttpServletRequest request,HttpSession session, Model model) {
		
		  String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		  if(submit!=null||update!=null)
		  {
	
			    SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
			    systemparametercodemaster.setComValue(frmlocation.getComValue());
				systemparametercodemaster.setComDescription(frmlocation.getComDescription());
				systemparametercodemaster.setComRemarks(frmlocation.getComRemarks());
				systemparametercodemaster.setComType(frmlocation.getComType());
				systemparametercodemaster.setComId(frmlocation.getComId());
				systemparametersservice.addSystemParameter(systemparametercodemaster);
				  return Showsystemparameter(model,request,session,frmlocation);
		  }
		  
		  
		  getPagination(frmlocation,request);
		  return Showsystemparameter(model,request,session,frmlocation);
		
		    
	}
	
	
	
	@RequestMapping(value = "/addDepartment")
	public ModelAndView addDepartment(@ModelAttribute("command") SystemParametersCodeMaster frmdepartment, HttpServletRequest request,HttpSession session,Model model) {
		  String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		if(submit!=null||update!=null)
		  {
		SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
		systemparametercodemaster.setComValue(frmdepartment.getComValue());
		systemparametercodemaster.setComDescription(frmdepartment.getComDescription());
		systemparametercodemaster.setComRemarks(frmdepartment.getComRemarks());
		systemparametercodemaster.setComType(frmdepartment.getComType());
		systemparametercodemaster.setComId(frmdepartment.getComId());
		systemparametersservice.addSystemParameter(systemparametercodemaster);
		return  Showsystemparameter(model,request,session, frmdepartment);
		  }
		
		 getPagination(frmdepartment,request);
		  return Showsystemparameter(model,request,session,frmdepartment);
	  }
	

	@RequestMapping(value = "/addServicePro")
	public ModelAndView addServicePro(@ModelAttribute("command") SystemParametersCodeMaster frmservicepro, HttpServletRequest request,HttpSession session, Model model) {
		 String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		if(submit!=null||update!=null)
		  {
		SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
		systemparametercodemaster.setComValue(frmservicepro.getComValue());
		systemparametercodemaster.setComDescription(frmservicepro.getComDescription());
		systemparametercodemaster.setComRemarks(frmservicepro.getComRemarks());
		systemparametercodemaster.setComType(frmservicepro.getComType());
		systemparametercodemaster.setComId(frmservicepro.getComId());
		systemparametersservice.addSystemParameter(systemparametercodemaster);
		return  Showsystemparameter(model,request,session,frmservicepro);
		  }
		 getPagination(frmservicepro,request);
		  return Showsystemparameter(model,request,session,frmservicepro);
	}
	@RequestMapping(value = "/addProject")
	public ModelAndView addProject(@ModelAttribute("command") SystemParametersCodeMaster frmproject, HttpServletRequest request,HttpSession session, Model model) {
		 String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		if(submit!=null||update!=null)
		  {
		SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
		systemparametercodemaster.setComValue(frmproject.getComValue());
		systemparametercodemaster.setComDescription(frmproject.getComDescription());
		systemparametercodemaster.setComRemarks(frmproject.getComRemarks());
		systemparametercodemaster.setComType(frmproject.getComType());
		systemparametercodemaster.setComId(frmproject.getComId());
		systemparametersservice.addSystemParameter(systemparametercodemaster);
			
		return  Showsystemparameter(model,request,session,frmproject);
		  }
		 getPagination(frmproject,request);
		  return Showsystemparameter(model,request,session,frmproject);
	}
	
	
	@RequestMapping(value = "/addVendors")
	public ModelAndView addVendors(@ModelAttribute("command") SystemParametersCodeMaster frmvendors, HttpServletRequest request,HttpSession session,Model model) {
		 String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		if(submit!=null||update!=null)
		  {
		SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
		systemparametercodemaster.setComValue(frmvendors.getComValue());
		systemparametercodemaster.setComDescription(frmvendors.getComDescription());
		systemparametercodemaster.setComRemarks(frmvendors.getComRemarks());
		systemparametercodemaster.setComType(frmvendors.getComType());
		systemparametercodemaster.setComId(frmvendors.getComId());
		systemparametersservice.addSystemParameter(systemparametercodemaster);
			
		return  Showsystemparameter(model,request,session,frmvendors);
		  }
		 getPagination(frmvendors,request);
		  return Showsystemparameter(model,request,session,frmvendors);
	}
	
	@RequestMapping(value = "/addMake")
	public ModelAndView addMake(@ModelAttribute("command") SystemParametersCodeMaster frmmake, HttpServletRequest request,HttpSession session,Model model) {
		 String submit= request.getParameter("locationSubmit");
		  String update= request.getParameter("locationUpdate");
		if(submit!=null||update!=null)
		  {
		SystemParametersCodeMaster systemparametercodemaster=new SystemParametersCodeMaster();
		systemparametercodemaster.setComValue(frmmake.getComValue());
		systemparametercodemaster.setComDescription(frmmake.getComDescription());
		systemparametercodemaster.setComRemarks(frmmake.getComRemarks());
		systemparametercodemaster.setComType(frmmake.getComType());
		systemparametercodemaster.setComId(frmmake.getComId());
		systemparametersservice.addSystemParameter(systemparametercodemaster);
		 
	 return  Showsystemparameter(model,request,session,frmmake);
		  }
		 getPagination(frmmake,request);
		  return Showsystemparameter(model,request,session,frmmake);
	}
	
	
	
	



}
