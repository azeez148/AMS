package com.experion.ams.dao.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.DashboardDao;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.SystemParametersCodeMaster;

/**
 * @author Libin Lougine L
 *
 */
public class DashboardHibernateDao implements DashboardDao {

	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Properties getAllAssetStatusFromDB() {
		Properties assetStatus = new Properties();
		Session session = sessionFactory.openSession();
		try {
			String hql = "SELECT DISTINCT A.assetCondition FROM Asset A";
			Query query = session.createQuery(hql);
			List<SystemParametersCodeMaster> AssetStatus = query.list();
			for (int i = 0; i < AssetStatus.size(); i++) {
				String hql1 = "SELECT count(*) FROM Asset A WHERE A.assetCondition=:Asset_Condition";
				Query query1 = session.createQuery(hql1);
				query1.setParameter("Asset_Condition", AssetStatus.get(i));
				String AssetStatusValue = query1.uniqueResult().toString();
				assetStatus.setProperty(AssetStatus.get(i).getComValue().toString(),
						AssetStatusValue);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return assetStatus;
	}

	@SuppressWarnings("unchecked")
	public Properties getAllAvailableAssetFromDB() {
		Properties availableAsset = new Properties();
		Session session = sessionFactory.openSession();
		try {
			String hql2 = "FROM AssetGroup AG";
			Query query2 = session.createQuery(hql2);
			List<AssetGroup> AvailAsset = query2.list();
			for (int i = 0; i < AvailAsset.size(); i++) {
				String AssetGroupName = AvailAsset.get(i).getGroupName()
						.toString();
				int AssetGroupSize = AvailAsset.get(i).getAsset().size();
				if(AssetGroupSize>0)
				{
					availableAsset.setProperty(AssetGroupName,
						Integer.toString(AssetGroupSize));
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return availableAsset;
	}

	@SuppressWarnings("unchecked")
	public Properties getAllServiceRemainderFromDB() {
		Properties serviceRemainder = new Properties();
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Asset A";
			Query query = session.createQuery(hql);
			List<Asset> ServiceRemainder = query.list();
			for (int i = 0; i < ServiceRemainder.size(); i++) {
				if (ServiceRemainder.get(i).getServiceInfo().size() > 0) {
					String assetNumber = ServiceRemainder.get(i)
							.getAssetNumber();
					String assetNotes = ServiceRemainder.get(i).getAssetNotes();
					Date serviceDate = ServiceRemainder.get(i).getServiceInfo()
							.get(0).getSiNextServiceDate();
					DateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
					String serDate = format.format(serviceDate);
					serviceRemainder.setProperty(
							assetNumber + " " + assetNotes, serDate);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return serviceRemainder;
	}

	/*
	 * public List<EmployeeToRoleMapping> getAllAuthScreensFromDB(Employee
	 * empCode){ List<EmployeeToRoleMapping> empRoleMap = null; try { String hql
	 * = "FROM EmployeeToRoleMapping ERM WHERE ERM.empCode="+empCode; Query
	 * query = this.sessionFactory.openSession().createQuery(hql); empRoleMap =
	 * query.list(); this.sessionFactory.close(); } catch (Exception e) {
	 * System.out.println(e); } return empRoleMap; }
	 */

	@SuppressWarnings("unchecked")
	public List<Employee> checkAuthorizedEmp(long EmployeeCode) {
		List<Employee> empRoleMap = null;
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Employee E WHERE E.empCode=" + EmployeeCode;
			Query query = session.createQuery(hql);
			empRoleMap = query.list();
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return empRoleMap;
	}

}
