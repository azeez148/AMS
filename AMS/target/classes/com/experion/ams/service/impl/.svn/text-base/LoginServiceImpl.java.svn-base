/**
 * 
 */
package com.experion.ams.service.impl;

import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.experion.ams.dao.LoginDAO;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.LoginService;

/**
 * @author Aneesh Chandran
 *
 */
public class LoginServiceImpl implements LoginService, Validator {

	private LoginDAO loginDAO;
	
	private static final String USERNAME_BLANK_ERR = "Enter Your Username";
	private static final String PASSWORD_BLANK_ERR = "Enter Your Password";
	
	public boolean supports(Class clazz) {
		return LoginForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object model, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeCode",
				"required.employeeCode", USERNAME_BLANK_ERR);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", PASSWORD_BLANK_ERR);
	}
	
	@Override
	public Employee getEmployeByCode(String empCode) {
		Employee employee = loginDAO.getEmployeByCode(empCode);
		
		List<EmployeeToRoleMapping> employeeToRoleMappings = loginDAO.getEmployeeToRoleMapping(empCode);
		if(employeeToRoleMappings!=null && !employeeToRoleMappings.isEmpty()){
			for(EmployeeToRoleMapping empToRole : employeeToRoleMappings){
				//Long roleCode = empToRole.getRoleCode();
				//List<RoleToScreenMapping> roleToScreenMappings = loginDAO.getScreensByRole(roleCode);
			}
		}
		
		return employee;
	}
	

	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

}
