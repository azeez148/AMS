package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.Role;

public interface AmsDAO {

	List<Employee> getEmployeeDeatails();

	List<Employee> getEmployeeById(Long empId);

	List<Employee> searchEmpDetails(String employeeName,
			String employeeDesignation,Long employeeRole);

	//void addEmployee(Long empid, Long roleId);

	List<Role> getDescription();

	Role getRoleid(String desc);

	List<EmployeeToRoleMapping> getEmCode(Long empcode);

	void update(Long empRoleMapId,Employee empCode,Role roleId);

	List<EmployeeToRoleMapping> getRole(Role roleCode);

	List<Employee> searchEmpDetails(String employeeName,
			String employeeDesignation);

	List<Employee> searchEmpDetails(String employeeDesignation);

	List<Employee> searchEmpDetails(String employeeDesignation,
			Long employeeRole);
	public void saveAllEmployeesPMO(Employee employee);
}
