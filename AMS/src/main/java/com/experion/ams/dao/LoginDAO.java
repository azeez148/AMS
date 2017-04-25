/**
 * 
 */
package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.RoleToScreenMapping;

/**
 * @author Aneesh Chandran
 *
 */
public interface LoginDAO {
	public Employee getEmployeByCode(String empCode);

	public List<EmployeeToRoleMapping> getEmployeeToRoleMapping(String empCode);

	public List<RoleToScreenMapping> getScreensByRole(Long roleCode);

}
