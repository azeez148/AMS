package com.experion.ams.dao;

import java.util.List;
import java.util.Properties;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
/**
 * @author Libin Lougine L
 *
 */
public interface DashboardDao {
	public Properties getAllAssetStatusFromDB();
	public Properties getAllAvailableAssetFromDB();
	public Properties getAllServiceRemainderFromDB();
	public List<Employee> checkAuthorizedEmp(long EmployeeCode);
}
