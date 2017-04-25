package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.AmsDAO;
import com.experion.ams.dao.DashboardDao;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.entity.Role;

public class AMSHibernateDAO implements AmsDAO {
	MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Autowired
	private DashboardDao dashboardDao;

	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getEmployeeDeatails() {

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Employee> employeeList = session.createQuery("from Employee")
				.list();
		session.close();

		return employeeList;
	}

	@Override
	public List<Employee> getEmployeeById(Long empId) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Employee> emplyee = session.createQuery(
				"FROM Employee WHERE empId = " + empId).list();
		session.close();
		return emplyee;
	}

	@Override
	public List<Role> getDescription() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Role> roleList = session.createQuery("FROM Role").list();
		session.close();
		return roleList;
	}

	@Override
	public Role getRoleid(String desc) {
		Session session = sessionFactory.openSession();
		// Query role=
		// session.createQuery("FROM Role  WHERE description=?").setParameter(0,
		// desc);
		Role id = null;
		String hql1 = "FROM Role  WHERE description=:Description";
		Query query1 = this.sessionFactory.openSession().createQuery(hql1);
		query1.setParameter("Description", desc);
		@SuppressWarnings("unchecked")
		List<Role> list = query1.list();
		for (Role role : list) {
			id = (Role) list.get(0);
			System.out.println(id.getDescription());

		}

		session.close();
		return id;
	}

	@Override
	public List<EmployeeToRoleMapping> getEmCode(Long empcode) {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<EmployeeToRoleMapping> employee = session.createQuery(
				"FROM EmployeeToRoleMapping WHERE emprole_emp_code = "
						+ empcode).list();
		session.close();

		return employee;

	}

	@Override
	public void update(Long rolemapid, Employee empcode, Role roleId) {
		Session session = sessionFactory.openSession();
		EmployeeToRoleMapping empMap = new EmployeeToRoleMapping();
		List<Employee> checkEmpCode = getAllAuthScreensFromDB(empcode.getEmpCode());
		Employee emp= (Employee)checkEmpCode.get(0);
		int employeeCodeCheck = checkEmpCode.get(0).getEmpRoleMapping().size(); 
		System.out.println("size of mapping table"+employeeCodeCheck);
		if (employeeCodeCheck == 0) {
			empMap.setId(rolemapid);
			empMap.setEmpCode(emp);
			empMap.setRoleCode(roleId);
			empMap.setDefaultRoleCode(roleId.getId());
			session.save(empMap);
		} else {
			System.out.println("inside update");
			String hql = "UPDATE EmployeeToRoleMapping set roleCode = :roleid,defaultRoleCode = :droleid WHERE empCode = :empcode";
			Query query = session.createQuery(hql);
			query.setParameter("empcode", emp);
			query.setParameter("roleid", roleId);
			query.setParameter("droleid", roleId.getId());
			//query.setParameter("rolmapid", rolemapid);
			@SuppressWarnings("unused")
			int result = query.executeUpdate();
		}

		session.close();

	}

	@Override
	public List<EmployeeToRoleMapping> getRole(Role roleCode) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from EmployeeToRoleMapping where roleCode = :roleCode");
		query.setParameter("roleCode", roleCode);
		@SuppressWarnings("unchecked")
		List<EmployeeToRoleMapping> role = query.list();
		session.close();
		return role;
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeName,
			String employeeDesignation) {

		Session session = sessionFactory.openSession();

		String HQL = "from Employee where empName like :employeeName and empDesignation = :employeeDesignation";
		Query query = session.createQuery(HQL);
		query.setParameter("employeeName", "%"+employeeName+"%");
		query.setParameter("employeeDesignation", employeeDesignation);
		@SuppressWarnings("unchecked")
		List<Employee> empDetails = query.list();
		session.close();
		return empDetails;

	}

	@Override
	public List<Employee> searchEmpDetails(String employeeDesignation) {
		Session session = sessionFactory.openSession();
		String HQL = "from Employee where empDesignation = :employeeDesignation";
		Query query = session.createQuery(HQL);
		query.setParameter("employeeDesignation", employeeDesignation);
		@SuppressWarnings("unchecked")
		List<Employee> empDetails = query.list();
		session.close();
		return empDetails;
	}

	@Override
	public List<Employee> searchEmpDetails(String employeeDesignation,
			Long employeeRole) {

		Session session = sessionFactory.openSession();
		String HQL = "from Employee where empDesignation = :employeeDesignation and empCode =:employeeRole";
		Query query = session.createQuery(HQL);
		query.setParameter("employeeDesignation", employeeDesignation);
		query.setParameter("employeeRole", employeeRole);
		@SuppressWarnings("unchecked")
		List<Employee> empDetails = query.list();
		session.close();
		return empDetails;

	}

	@Override
	public List<Employee> searchEmpDetails(String employeeName,
			String employeeDesignation, Long employeeRole) {
		try {
			Session session = sessionFactory.openSession();
			employeeName = employeeName.toLowerCase();
			String HQL = "from Employee where empName like :employeeName and empDesignation = :employeeDesignation and empCode = :employeeRole";
			Query query = session.createQuery(HQL);
			query.setParameter("employeeName", "%"+employeeName+"%");
			query.setParameter("employeeDesignation", employeeDesignation);
			query.setParameter("employeeRole", employeeRole);
			@SuppressWarnings("unchecked")
			List<Employee> empDetails = query.list();
			sessionFactory.close();
			return empDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Employee> getAllAuthScreensFromDB(long empCode){
		List<Employee> empRoleMap = null;
		try {
			Session session = sessionFactory.openSession();
			String hql = "FROM Employee E WHERE E.empCode="+empCode;
			Query query = session.createQuery(hql);
			empRoleMap = query.list();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return empRoleMap;
	}
	
	public void saveAllEmployeesPMO(Employee employee){
		Session session = sessionFactory.openSession();
		try{
			
			session.save(employee);
			
		}catch(Exception e){
			System.out.println(e);
		}
		session.close();
	}
	
}
