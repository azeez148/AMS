/**
 * 
 */
package com.experion.ams.mvc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.mvc.controller.pmo.PMONTLMSchemeFactory;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.AmsService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.LoginService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author Libin Lougine L
 * 
 */

//@Controller
@RequestMapping("/login/*")
public class HomeController {

	private static final String HOME_PAGE = "/home";
	private static final String TEST_PAGE = "/test";
	private static final String LOGIN_PAGE = "/login";

	private static final String ERR_MESSAGE_1 = "Unauthorized access";
	private static final String ERR_MESSAGE_2 = "Username/Password not correct";

	private static final Log log = LogFactory.getLog(LoginController.class);

	private String username="";
	private String password="";
	
	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "loginService")
	LoginService loginService;

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
	
	ObjectMapper mapper = new ObjectMapper();
	/**
	 * 
	 * @param request
	 * @return
	 * 
	 *         This method will be invoked dashboard.
	 * 
	 */

	/*
	 * @RequestMapping(value = "/login") public ModelAndView
	 * processLogin(HttpServletRequest request, LoginForm loginForm) {
	 * System.out.println("Reached Login method................"); Employee
	 * employee = loginService.getEmployeByCode(loginForm.getEmployeeCode());
	 * return new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm()); }
	 */
	// private long EmployeeCode = 0;

	public List<Employee> getAuthScreens(long employeeCode) {
		List<Employee> authScreens = dashboardService
				.checkAuthorizedEmp(employeeCode);
		return authScreens;
	}

	@RequestMapping(value = "/home")
	public ModelAndView viewDashboard(HttpServletRequest request,
			@ModelAttribute("logForm") LoginForm loginForm, BindingResult result)
			throws Exception {
		ModelAndView mav = null;
		/*String username = "";
		String password = "";*/
		Gson gson = new Gson();
		try {
			if ((request.getSession().getAttribute("empCode").equals(""))
					|| (request.getSession().getAttribute("empCode")
							.equals(null))) {
				username = request.getParameter("employeeCode");
				password = request.getParameter("password");
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				loginService.validate(loginForm, result);
				if (result.hasErrors()) {
					request.getSession().setAttribute("empCode", "1");
				} else {
					DefaultHttpClient httpclient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(
							"http://pmo.experionglobal.com:6060/pmoservice/PMOService.svc/Login");
					httpPost.setHeader("Content-Type", "application/json");
					StringEntity se = new StringEntity("{\"UserName\": \""
							+ username + "\",\"Password\": \"" + password
							+ "\"}");
					httpPost.setEntity(se);
					httpclient.getAuthSchemes().register("NTLM",
							new PMONTLMSchemeFactory());
					httpclient.getCredentialsProvider().setCredentials(
							new AuthScope(AuthScope.ANY_HOST,
									AuthScope.ANY_PORT),
							new NTCredentials(username, password, "", ""));
					List<String> authtypes = new ArrayList<String>();
					authtypes.add(AuthPolicy.NTLM);
					httpclient.getParams().setParameter(
							AuthPNames.TARGET_AUTH_PREF, authtypes);
					HttpResponse response = httpclient.execute(httpPost);
					String employeeDetails = EntityUtils.toString(response
							.getEntity());
					if (employeeDetails.startsWith("{")) {
						// String EmpCode =
						// employeeDetails.split(",")[2].split(":")[1];
						JsonObject jObj = (new JsonParser()).parse(
								employeeDetails).getAsJsonObject();
						request.getSession().setAttribute("empCode",
								jObj.get("EmployeeCode"));
						System.out.println("Response....: " + employeeDetails);
						System.out.println("Employee code: "
								+ jObj.get("EmployeeCode"));
					} else {
						request.getSession().setAttribute("empCode", "0");
					}
				}

			}
			// request.getSession().setAttribute("empCode", "1018");
		} catch (Exception e) {
			/*
			 * return new ModelAndView(LOGIN_PAGE, "LoginForm", new
			 * LoginForm());
			 */
			return new ModelAndView("redirect:/login/index");
		}
		if (request.getSession().getAttribute("empCode").equals("0")) {
			mav = new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());
			request.getSession().setAttribute("empCode", "");
			mav.addObject("ErrMsg", ERR_MESSAGE_2);
		} else if (request.getSession().getAttribute("empCode").equals("1")) {
			mav = new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());
			request.getSession().setAttribute("empCode", "");
		} else {
			long EmployeeCode = Long.parseLong(request.getSession()
					.getAttribute("empCode").toString());
			if (getAuthScreens(EmployeeCode).isEmpty()) {
				mav = new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());
				request.getSession().setAttribute("empCode", "");
				mav.addObject("ErrMsg", ERR_MESSAGE_1);

			} else {
				mav = new ModelAndView(HOME_PAGE, "LoginForm", new LoginForm());
				Properties assetStatus = dashboardService.getAllAssetStatus();
				Properties availableAsset = dashboardService
						.getAllAvailableAsset();
				Properties serviceRemainder = dashboardService
						.getAllServiceRemainder();
				mav.addObject("AssetStatus", assetStatus);
				mav.addObject("AvailableAsset", availableAsset);
				mav.addObject("ServiceRemainder", serviceRemainder);
				mav.addObject("AuthScreens", getAuthScreens(EmployeeCode));
			}

		}
		return mav;
		//return new ModelAndView("redirect:index");
	}

	/*
	 * @RequestMapping(value = "/asset") public ModelAndView
	 * test(HttpServletRequest request) { ModelAndView mav = new
	 * ModelAndView(TEST_PAGE, "LoginForm", new LoginForm()); long EmployeeCode
	 * = Long.parseLong(request.getSession()
	 * .getAttribute("empCode").toString()); mav.addObject("AuthScreens",
	 * getAuthScreens(EmployeeCode)); return mav; }
	 */
	public void getAllEmployeesPMO() {
		//System.out.println("hitting of the trigger of the ams: "+getSchedulerForm().getUsername() +"---"+getSchedulerForm().getPassword());
		System.out.println("Scheduler starts updating employee table......."+username+"---"+password);
		try {
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(
					"http://pmo.experionglobal.com:6060/pmoservice/PMOService.svc/GetAllEmployee");
			httpGet.setHeader("Content-Type", "application/json");
			StringEntity se = new StringEntity("{\"UserName\": \""+username+ "\",\"Password\": \""+password+ "\"}");
			// httpGet.setEntity(se);
			httpclient.getAuthSchemes().register("NTLM",
					new PMONTLMSchemeFactory());
			httpclient.getCredentialsProvider().setCredentials(
					new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
					new NTCredentials(username,password,"", ""));
			List<String> authtypes = new ArrayList<String>();
			authtypes.add(AuthPolicy.NTLM);
			httpclient.getParams().setParameter(AuthPNames.TARGET_AUTH_PREF,
					authtypes);
			HttpResponse response = httpclient.execute(httpGet);
			String allEmployeeDetails = EntityUtils.toString(response
					.getEntity());
			JsonNode rootNode = mapper.readTree(allEmployeeDetails);
			JsonNode Employee = rootNode.path("Employees");
			JsonNode EmployeeCode = Employee.path("EmployeeCode");
			Iterator<JsonNode> ite = Employee.getElements();

			while (ite.hasNext()) {
				String temp = ite.next().toString();
				JsonObject jObj = (new JsonParser()).parse(temp)
						.getAsJsonObject();
				// System.out.println("libin check : "+jObj.get("EmployeeCode")+" "+jObj.get("EmployeeName"));
				Employee employee = new Employee();
				Long employeeCode = Long.parseLong(jObj.get("EmployeeCode")
						.toString());
				List<Employee> authScreens = dashboardService
						.checkAuthorizedEmp(employeeCode);
				if (authScreens.isEmpty()) {
					employee.setEmpCode(employeeCode);
					employee.setEmpName(jObj.get("EmployeeName").toString()
							.replaceAll("\"", ""));
					employee.setEmpContact(jObj.get("ContactNo").toString()
							.replaceAll("\"", ""));
					employee.setEmpDesignation(jObj.get("Designation")
							.toString().replaceAll("\"", ""));
					employee.setEmpEmail(jObj.get("Email").toString()
							.replaceAll("\"", ""));
					employee.setEmpGender(jObj.get("Gender").toString()
							.replaceAll("\"", ""));
					String DOJ = jObj.get("DOJ").toString().replace("T", " ");
					employee.setJoiningDate(DOJ.replaceAll("\"", ""));
					employee.setEmpStatus(jObj.get("Status").toString()
							.replaceAll("\"", ""));
					amsservice.saveAllEmployeesPMO(employee);
				}
			}
			System.out.println("Scheduler ends updation of employee table.......");;

		} catch (Exception e) {
		}
	}

}
