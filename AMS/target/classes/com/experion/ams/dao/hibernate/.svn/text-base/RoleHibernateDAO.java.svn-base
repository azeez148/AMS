package com.experion.ams.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.RoleDAO;
import com.experion.ams.entity.Role;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.entity.Screen;
import com.experion.ams.mvc.controller.LoginController;

public class RoleHibernateDAO implements RoleDAO {
	private static final Log log = LogFactory.getLog(LoginController.class);

	@Inject
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		Session session = sessionFactory.openSession();
		System.out.println(session);
		session.beginTransaction();

		List<Role> roleDetailsList = session.createQuery("from Role").list();

		session.close();
		return roleDetailsList;

	}

	@Override
	public List<Screen> getAllScreens() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Screen> screenList = session.createQuery("from Screen").list();

		session.close();
		return screenList;
	}

	@Override
	@Transactional
	public boolean addRole(Role role) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(role);
			tx.commit();
			session.close();
			return true;
		} catch (JDBCException jdbce) {
			log.info(jdbce);
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Screen> getIdByScreenName(String string) {

		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			List<Screen> screens = new ArrayList<Screen>();

			screens = session.createQuery("from Screen where screenName=?")
					.setParameter(0, string).list();
			tx.commit();
			session.close();

			return screens;
		} catch (HibernateException He) {
			log.info(He);
			return null;

		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Screen> getScreenDeatails(List<String> st) {

		Session session = sessionFactory.openSession();
		try {
			List<Screen> screens = new ArrayList<Screen>();

			screens = session
					.createQuery("from Screen where screenName IN (:st)")
					.setParameterList("st", st).list();
			session.close();

			return screens;
		} catch (HibernateException He) {
			log.info(He);
			return null;

		}
	}

	@Override
	public List<Role> getRoleDetailsById(long roleId) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Role> roleDetails = session
					.createQuery("from Role where id=?")
					.setParameter(0, roleId).list();
			tx.commit();
			session.close();

			return roleDetails;
		} catch (HibernateException He) {
			log.info(He);
			return null;

		}
	}

	@Override
	@Transactional
	public boolean editRole(Role role) {
		Session session = sessionFactory.openSession();
		System.out.println(role);
		Transaction tx = null;

		try {
		tx= session.beginTransaction();
				session.merge(role);
		
//			session.flush();
			tx.commit();
			session.close();
			return true;
		} catch (JDBCException jdbce) {
			log.info(jdbce);
			return false;
		}

	}

	@Override
	public List<Role> getRoleDetailsByName(String roleName) {
		Session session = sessionFactory.openSession();

		String HQL = "from Role where roleName like :roleName";
		Query query = session.createQuery(HQL);
		query.setParameter("roleName", "%"+roleName+"%");
		@SuppressWarnings("unchecked")
		List<Role> roleDetails = query.list();
		session.close();
		return roleDetails;
	}

	@Override
	public List<RoleToScreenMapping> getRoleToScreenId(Long id) {
		Transaction tx = null;
		Session session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<RoleToScreenMapping> toScreenMappings = session
					.createQuery("from RoleToScreenMapping where roleId=?")
					.setParameter(0, id).list();
			tx.commit();
			session.close();

			return toScreenMappings;
		} catch (HibernateException He) {
			log.info(He);
			return null;

		}
	}

	@Override
	public Role getroleById(long roleId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Role role = (Role)session.get(Role.class, roleId);
		session.close();
		return role;
	}

	@Override
	@Transactional
	public boolean deleteMappings(long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			String hql = "delete from RoleToScreenMapping where id= :id";
			session.createQuery(hql).setLong("id", id).executeUpdate();
			tx.commit();
//			session.flush();
			session.close();
			return true;
		} catch (JDBCException jdbce) {
			log.info(jdbce);
			return false;
	}}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean checkRole(String roleName) {
		Session session = sessionFactory.openSession();
		List<Role> roleList = new ArrayList<Role>();
		try {
			Criteria crt = session.createCriteria(Role.class);

			crt.add(Restrictions.eq("roleName", roleName));
			roleList = crt.list();
			if(roleList.size()==0){
				return true;
			}
			else{
				return false;
				
			}

		} catch (HibernateException He) {
			System.out.println(He);
			log.error("error during fethcing assets......" + He);
return false;


		} finally {

			session.close();

		}
	}

}
