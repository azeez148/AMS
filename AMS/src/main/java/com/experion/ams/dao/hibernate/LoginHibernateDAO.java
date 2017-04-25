/**
 * 
 */
package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.experion.ams.dao.LoginDAO;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.RoleToScreenMapping;

/**
 * @author Aneesh Chandran
 *
 */
public class LoginHibernateDAO implements LoginDAO {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Employee getEmployeByCode(String empCode) {
		// Open the hibernate session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Employee.class);
		
		if(StringUtils.isNotBlank(empCode)){
			criteria.add(Restrictions.eq("empCode",empCode));
		}
		criteria.setMaxResults(1);
		List<Employee> employeeList = (List<Employee>) criteria.list();
		session.close();
		
		return employeeList.get(0);
	}

	@Override
	public List<EmployeeToRoleMapping> getEmployeeToRoleMapping(String empCode) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(EmployeeToRoleMapping.class);
		if(StringUtils.isNotBlank(empCode)){
			criteria.add(Restrictions.eq("empCode",empCode));
		}
		List<EmployeeToRoleMapping> employeeToRoleMappingList = (List<EmployeeToRoleMapping>) criteria.list();
		session.close();
		return employeeToRoleMappingList;
	}

	
	@Override
	public List<RoleToScreenMapping> getScreensByRole(Long roleCode) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(RoleToScreenMapping.class);
		if(roleCode!=0){
			criteria.add(Restrictions.eq("roleCode",roleCode));
		}
		List<RoleToScreenMapping> roleToScreenMappingList = (List<RoleToScreenMapping>) criteria.list();
		session.close();
		return roleToScreenMappingList;
	}

}
