package com.experion.ams.mvc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.Role;
import com.experion.ams.mvc.controller.pmo.PMONTLMSchemeFactory;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.AmsService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.util.AMSUtil;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Transactional
@Controller
@RequestMapping("/login/*")
public class EmployeeController {
	private static final String HOME_PAGE = "/home";
	private static final String EMPLOYEE_PAGE = "/employee";

	private static String employeeName = null;
	private static String employeeDesignation = null;
	private static Long employeeRole = null;
	private static int searchCondition = 0;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(EmployeeController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	@Inject
	@Named(value = "amsservice")
	private AmsService amsservice;

	public AmsService getAmsservice() {
		return amsservice;
	}

	public void setAmsservice(AmsService amsservice) {
		this.amsservice = amsservice;
	}

	@RequestMapping(value = "/showEmployees")
	public ModelAndView listAllEmployees(HttpServletRequest request,
			Model model, Employee employee, Role role, HttpSession session) {

		model.addAttribute("employeeDetails", amsservice.getEmployeeDetails());
		model.addAttribute("getRole", amsservice.getDescription());
		model.addAttribute("section", "Employee List");
		request.setAttribute("section", "Employee List");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(EMPLOYEE_PAGE);

	}

	// Edit the employee details
	@RequestMapping(value = "/editemployee", method = RequestMethod.GET)
	public ModelAndView edit(Model model, HttpServletRequest request,
			Employee employee, Role role, HttpSession session) {
		List<Employee> employeeList = amsservice.getEmployeeById(employee
				.getEmpId());
		model.addAttribute("employee", employeeList.get(0));
		model.addAttribute("getRole", amsservice.getDescription());
		model.addAttribute("section", "Manage Employee");
		request.setAttribute("section", "Manage Employee");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		if (searchCondition > 0) {
			if (searchCondition == 1) {
				model.addAttribute("employeeDetails",
						amsservice.searchEmpDetails(employeeDesignation));
			} else if (searchCondition == 2) {
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeName, employeeDesignation));
			} else if (searchCondition == 3) {
				System.out.println("Employee Role: " + employeeRole);
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeDesignation, employeeRole));
			} else if (searchCondition == 4) {
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeName, employeeDesignation,
								employeeRole));
			}

		} else {
			model.addAttribute("employeeDetails",
					amsservice.getEmployeeDetails());
		}
		return new ModelAndView(EMPLOYEE_PAGE);
	}

	@RequestMapping("/addemployee")
	public ModelAndView add(@ModelAttribute("command") Employee employee,
			HttpServletRequest request, Model model, Role role) {

		model.addAttribute("section", "Manage Employee");
		request.setAttribute("section", "Manage Employee");
		List<Employee> employeeList = amsservice.getEmployeeById(employee
				.getEmpId());
		Long empcode = employeeList.get(0).getEmpCode();
		String desc = role.getDescription();
		// Role rolelst = (Role)amsservice.getRoleId(desc);
		Role rolelst = amsservice.getRoleId(desc);
		List<EmployeeToRoleMapping> empRoleList = amsservice
				.getEmpCode(empcode);
		Long empRoleMapId = null;
		Long empCode = null;
		if (empRoleList.isEmpty()) {

			empRoleMapId = (long) 1;
			empCode = empcode;
		} else {
			/* empCode = empRoleList.get(0).getEmpCode(); */
			empRoleMapId = empRoleList.get(0).getId();
		}

		amsservice.update(empRoleMapId, employee, rolelst);
		return new ModelAndView("redirect:../login/showEmployees");
	}

	@RequestMapping(value = "/searchresultforaddemployee")
	public ModelAndView searchEmployeeForAdd(
			@ModelAttribute("command") Role role, BindingResult result,
			Model model, HttpServletRequest request, Employee addEmployeeForm,
			HttpSession session) {
		model.addAttribute("section", "Employee List");
		request.setAttribute("section", "Employee List");
		model.addAttribute("getRole", amsservice.getDescription());
		String desc = role.getDescription();
		// List<Role> rolelst = amsservice.getRoleId(desc);
		Role rolelst = amsservice.getRoleId(desc);
		// Long roleId = rolelst.get(0).getId();
		employeeName = addEmployeeForm.getEmpName();
		employeeDesignation = addEmployeeForm.getEmpDesignation();
		List<EmployeeToRoleMapping> erole = amsservice.getRole(rolelst);
		if (erole.isEmpty()) {
			if (employeeName == "") {
				searchCondition = 1;
				model.addAttribute("employeeDetails",
						amsservice.searchEmpDetails(employeeDesignation));
			} else {
				searchCondition = 2;
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeName, employeeDesignation));
			}

		} else {
			employeeRole = erole.get(0).getEmpCode().getEmpCode();
			if (employeeName == "") {
				searchCondition = 3;
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeDesignation, employeeRole));
			} else {
				searchCondition = 4;
				model.addAttribute("employeeDetails", amsservice
						.searchEmpDetails(employeeName, employeeDesignation,
								employeeRole));
			}

		}

		/*
		 * if (!erole.isEmpty()) {
		 * System.out.println("inside condition is empty erole"); if
		 * ((employeeName != "") && ((employeeDesignation != ""))) {
		 * 
		 * model.addAttribute("employeeDetails", amsservice
		 * .searchEmpDetails(employeeName, employeeDesignation)); } else
		 * if(employeeDesignation != ""){
		 * 
		 * model.addAttribute("employeeDetails",
		 * amsservice.searchEmpDetails(employeeDesignation)); }
		 * 
		 * } else { if (employeeName != "") { Long employeeRole =
		 * erole.get(0).getEmpCode(); model.addAttribute("employeeDetails",
		 * amsservice .searchEmpDetails(employeeName, employeeDesignation,
		 * employeeRole)); } else {
		 * 
		 * Long employeeRole = erole.get(0).getEmpCode();
		 * model.addAttribute("employeeDetails", amsservice
		 * .searchEmpDetails(employeeDesignation, employeeRole));
		 * 
		 * } }
		 */
		/*
		 * long employeeCode = Long.parseLong(request.getSession()
		 * .getAttribute("empCode").toString());
		 */
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(EMPLOYEE_PAGE);
	}
	
	/*@RequestMapping(value = "/getAllEmployeePMO", method = RequestMethod.GET)
	public void getAllEmployeesPMO(HttpServletRequest request){
		try{
		DefaultHttpClient httpclient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(
				"http://pmo.experionglobal.com:6060/pmoservice/PMOService.svc/GetAllEmployee");
		httpGet.setHeader("Content-Type", "application/json");
		StringEntity se = new StringEntity("{\"UserName\": \""
				+ request.getSession().getAttribute("username").toString() + "\",\"Password\": \"" + request.getSession().getAttribute("password").toString()
				+ "\"}");
		//httpGet.setEntity(se);
		httpclient.getAuthSchemes().register("NTLM",
				new PMONTLMSchemeFactory());
		httpclient.getCredentialsProvider().setCredentials(
				new AuthScope(AuthScope.ANY_HOST,
						AuthScope.ANY_PORT),
				new NTCredentials(request.getSession().getAttribute("username").toString(), request.getSession().getAttribute("password").toString(), "", ""));
		List<String> authtypes = new ArrayList<String>();
		authtypes.add(AuthPolicy.NTLM);
		httpclient.getParams().setParameter(
				AuthPNames.TARGET_AUTH_PREF, authtypes);
		HttpResponse response = httpclient.execute(httpGet);
		String allEmployeeDetails = EntityUtils.toString(response.getEntity());
			JsonNode rootNode = mapper.readTree(allEmployeeDetails);
			JsonNode Employee = rootNode.path("Employees");
			System.out.println("libin check "+Employee);
			JsonNode EmployeeCode = Employee.path("EmployeeCode");
			System.out.println("libin check employecode : "+EmployeeCode);
			Iterator<JsonNode> ite = Employee.getElements();

			while (ite.hasNext()) {
				String temp = ite.next().toString();
				JsonObject jObj = (new JsonParser()).parse(temp).getAsJsonObject();
				//System.out.println("libin check : "+jObj.get("EmployeeCode")+" "+jObj.get("EmployeeName"));
				Employee employee = new Employee();
				Long employeeCode = Long.parseLong(jObj.get("EmployeeCode").toString());
				List<Employee> authScreens = dashboardService.checkAuthorizedEmp(employeeCode);
				if(authScreens.isEmpty())
				{
				employee.setEmpCode(employeeCode);
				employee.setEmpName(jObj.get("EmployeeName").toString().replaceAll("\"", ""));
				employee.setEmpContact(jObj.get("ContactNo").toString().replaceAll("\"", ""));
				employee.setEmpDesignation(jObj.get("Designation").toString().replaceAll("\"", ""));
				employee.setEmpEmail(jObj.get("Email").toString().replaceAll("\"", ""));
				employee.setEmpGender(jObj.get("Gender").toString().replaceAll("\"", ""));
				System.out.println("libin check doj 2015-02-04T00:00:00:"+jObj.get("DOJ"));
				String DOJ = jObj.get("DOJ").toString().replace("T", " ");
				System.out.println("libin check doj :"+DOJ);
				employee.setJoiningDate(DOJ.replaceAll("\"", ""));
				employee.setEmpStatus(jObj.get("Status").toString().replaceAll("\"", ""));
				amsservice.saveAllEmployeesPMO(employee);
				}
			}
			
		}catch(Exception e){}	
	}*/

}
