package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.Role;

public interface AmsService {

	List<Employee> getEmployeeDetails();

	List<Employee> getEmployeeById(Long long1);

	List<Employee> searchEmpDetails(String employeeName, String employeeDesignation,Long employeeRole);



	List<Role> getDescription();

	Role getRoleId(String desc);

	List<EmployeeToRoleMapping> getEmpCode(Long empcode);

	void update(Long empRoleMapId,Employee employee,Role rolelst);

	List<EmployeeToRoleMapping> getRole(Role roleCode);

	List<Employee> searchEmpDetails(String employeeName, String employeeDesignation);

	List<Employee> searchEmpDetails(String employeeDesignation);

	List<Employee> searchEmpDetails(String employeeDesignation, Long employeeRole);
	
	public void saveAllEmployeesPMO(Employee employee);

}
