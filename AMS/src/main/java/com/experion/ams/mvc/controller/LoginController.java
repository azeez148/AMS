/**
 * 
 */
package com.experion.ams.mvc.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.LoginService;

/**
 * @author AneeshChandran
 * 
 */

@Controller
@RequestMapping("/login/*")
public class LoginController {

	private static final String HOME_PAGE = "/home";
	private static final String LOGIN_PAGE = "/login";

	private static final Log log = LogFactory.getLog(LoginController.class);
	
	@Inject
	@Named(value = "loginService")
	LoginService loginService;

	
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
	
	@RequestMapping(value = "/index")
	public ModelAndView loginAction(HttpServletRequest request, LoginForm loginForm) {
		ModelAndView mav = new ModelAndView(LOGIN_PAGE, "logForm", new LoginForm());
		request.getSession().setAttribute("empCode", "");
		/*mav.addObject("logForm", new LoginForm());*/
		return mav;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView processLogin(HttpServletRequest request, LoginForm loginForm) {
		System.out.println("Reached Login method................");
		Employee employee = loginService.getEmployeByCode(loginForm.getEmployeeCode());
		return new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());
	}
	

}
