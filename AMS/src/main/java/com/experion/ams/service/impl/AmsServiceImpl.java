package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

















import com.experion.ams.dao.AmsDAO;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.Role;
import com.experion.ams.service.AmsService;



@Service
//@Transactional
public class AmsServiceImpl implements AmsService{
	@Inject
	private AmsDAO amsDAO;
	public AmsDAO getAmsDAO() {
		return amsDAO;
	}

	public void setAmsDAO(AmsDAO amsDAO) {
		this.amsDAO = amsDAO;
	}

	MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public List<Employee> getEmployeeDetails() {
	
		
		return amsDAO.getEmployeeDeatails();
	}

	@Override
	public List<Employee> getEmployeeById(Long empId) {
	
		return amsDAO.getEmployeeById(empId);
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeName, String employeeDesignation,Long employeeRole) {
		
		return amsDAO.searchEmpDetails(employeeName, employeeDesignation,employeeRole);
	}

	

	@Override
	public List<Role> getDescription() {
		// TODO Auto-generated method stub
		return amsDAO.getDescription();
	}

	@Override
	public Role getRoleId(String desc) {
		// TODO Auto-generated method stub
		return amsDAO.getRoleid(desc);
	}

	
	@Override
	public List<EmployeeToRoleMapping> getEmpCode(Long empcode) {
	
		return amsDAO.getEmCode(empcode);
	}

	@Override
	public void update(Long empRoleMapId,Employee empCode,Role roleId) {
		 amsDAO.update(empRoleMapId, empCode,roleId);
		
	}

	@Override
	public List<EmployeeToRoleMapping> getRole(Role roleCode) {
		
		return amsDAO.getRole(roleCode);
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeName,
			String employeeDesignation) {
		
		return amsDAO.searchEmpDetails(employeeName, employeeDesignation);
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeDesignation) {
				return amsDAO.searchEmpDetails(employeeDesignation);
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeDesignation,
			Long employeeRole) {
				return amsDAO.searchEmpDetails(employeeDesignation,employeeRole);
	}
	
	public void saveAllEmployeesPMO(Employee employee){
		amsDAO.saveAllEmployeesPMO(employee);
	}

	}


	

	

