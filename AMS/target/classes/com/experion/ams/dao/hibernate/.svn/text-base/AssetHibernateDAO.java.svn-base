package com.experion.ams.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.experion.ams.dao.AssetDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

public class AssetHibernateDAO implements AssetDAO {

	private static final Log log = LogFactory.getLog(AssetHibernateDAO.class);
	private static final String COM_CURRENTLYAT = "CAT";
	private static final String COM_CURRENTLYAT_InProject = "In-Project";

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
	public List<Asset> getAllAssetDetails() {
		log.info("method to retrieve assets....");

		Session session = sessionFactory.openSession();
		try {
			List<Asset> assets = session.createQuery("from Asset").list();
			session.close();

			log.info("successfully retrieved assets....");
			return assets;
		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);
			return null;
		}

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<SystemParametersCodeMaster> getAllCodeValuesByType(String type) {
		Session session = sessionFactory.openSession();
		List<SystemParametersCodeMaster> codeValues = new ArrayList<SystemParametersCodeMaster>();
		try {
			Criteria crt = session
					.createCriteria(SystemParametersCodeMaster.class);

			crt.add(Restrictions.eq("comType", type));
			crt.add(Restrictions.ne("comCode", 0));
			codeValues = crt.list();
			return codeValues;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return codeValues;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetGroup> getAllGroupDetails() {

		log.info("method to retrieve groups....");

		Session session = sessionFactory.openSession();
		try {
			List<AssetGroup> assetGroups = session.createQuery(
					"from AssetGroup").list();
			log.info("successfully retrieved groups....");
			return assetGroups;
		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);
			return null;
		} finally {

			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllCustodianDetails() {
		log.info("method to retrieve groups....");

		Session session = sessionFactory.openSession();
		try {
			List<Employee> employees = session.createQuery("from Employee")
					.list();
			log.info("successfully retrieved groups....");
			return employees;
		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......", He);
			return null;
		} finally {

			session.close();
		}
	}

	@Override
	public boolean addAsset(Asset asset,AssetTransfer assetTransfer,ServiceInfo serviceInfo) {
		Session session = sessionFactory.openSession();
		log.info("inside add method....");
		try {
			session.save(asset);
			session.save(assetTransfer);
			session.save(serviceInfo);
			log.info("successfully saved asset....");
			return true;
		} catch (HibernateException he) {
			log.error("error during adding assets......", he);
			return false;
		} finally {
			session.close();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Asset getAssetsById(int assetId) {
		Session session = sessionFactory.openSession();
		try {
			/*
			 * List<Asset> assets =
			 * session.createQuery("from Asset where assetId = ?")
			 * .setParameter(0, assetId).list();
			 */
			Asset assets = (Asset) session.get(Asset.class, assetId);

			log.info("successfully retrieved assets of id ...." + assetId);
			return assets;
		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);
			return null;
		} finally {
			session.close();

		}
	}

	@Override
	public boolean editAsset(Asset asset,AssetTransfer assetTransfer,ServiceInfo serviceInfo) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		log.info("inside update method....");
		try {
			log.info(asset);
			session.merge(asset);
			session.save(assetTransfer);
			session.merge(serviceInfo);
			
			tx.commit();
			log.info("successfully updated asset....");
			return true;
		} catch (HibernateException he) {
			log.error("error during updating assets......", he);
			System.out.println(he);
			return false;

		} finally {
			session.close();
		}

	}

	@Override
	public int getCurrentlyAtId() {
		Session session = sessionFactory.openSession();
		// List<SystemParametersCodeMaster> codeValues = new
		// ArrayList<SystemParametersCodeMaster>();
		try {

			Query id = session
					.createQuery(
							"select comId from SystemParametersCodeMaster  where comType=? and comValue=?")
					.setParameter(0, COM_CURRENTLYAT)
					.setParameter(1, COM_CURRENTLYAT_InProject);

			return id.executeUpdate();
		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();

			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return 0;

	}

	// get search results
	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getSearchResults(String assetNumber,
			Employee custodianId, AssetGroup groupCode,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster locationCode,
			SystemParametersCodeMaster projectCode) {
		//
		log.info("method to get search results dynamically....");

		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			
			System.out.println(assetNumber);
			if (!StringUtils.EMPTY.equals(assetNumber)) {
//				crt.add(Restrictions.like("assetNumber", "%LenovoE440%"));

//				crt.add(Restrictions.like("assetNumber", assetNumber,));
				crt.add(Restrictions.like("assetNumber", assetNumber,MatchMode.ANYWHERE));

			}

			if (!(custodianId.getEmpId() == 0)) {
				System.out.println("SSS");

				crt.add(Restrictions.eq("assetCustodianCode", custodianId));

			}
			if (!groupCode.getGroupId().equals(0)) {
				
				System.out.println("GGGG");
				
				
				
				
				crt.add(Restrictions.eq("assetGroupCode", groupCode));

			}
			if (!deptCode.getComId().equals(0)) {
				System.out.println("HHHH");

				crt.add(Restrictions.eq("assetDeptCode", deptCode));

			} 
			if (!locationCode.getComId().equals(0)) {
				System.out.println("1111");

				crt.add(Restrictions.eq("assetLocationCode", locationCode));

			}
			if (!projectCode.getComId().equals(0)) {
				System.out.println("4444");

				crt.add(Restrictions.eq("assetPrjctCode", projectCode));

			}
System.out.println(crt);
			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsBycomId(Employee custodianId) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetCustodianCode", custodianId));
			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsforSearch(
			SystemParametersCodeMaster projectCode, Employee custodianId) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			crt.add(Restrictions.eq("assetCustodianCode", custodianId));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByLocation(
			SystemParametersCodeMaster locationCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetLocationCode", locationCode));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsforLocation(Employee custodianId,
			SystemParametersCodeMaster locationCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetCustodianCode", custodianId));
			crt.add(Restrictions.eq("assetLocationCode", locationCode));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			crt.add(Restrictions.eq("assetLocationCode", locationCode));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsforLocation(
			SystemParametersCodeMaster projectCode, Employee custodianId,
			SystemParametersCodeMaster locationCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			crt.add(Restrictions.eq("assetLocationCode", locationCode));
			crt.add(Restrictions.eq("assetCustodianCode", custodianId));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByDepartment(
			SystemParametersCodeMaster deptCode) {

		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetDeptCode", deptCode));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetDeptCode", deptCode));
			crt.add(Restrictions.eq("assetCustodianCode", custodianId));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetDeptCode", deptCode));
			crt.add(Restrictions.eq("assetCustodianCode", custodianId));
			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetDeptCode", deptCode));
			crt.add(Restrictions.eq("assetCustodianCode", custodianId));
			crt.add(Restrictions.eq("assetPrjctCode", projectCode));
			crt.add(Restrictions.eq("assetLocationCode", locationCode));

			assets = crt.list();
			return assets;

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return assets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParametersCodeMaster> getProjectIdByName(String comProject) {
		Session session = sessionFactory.openSession();
		List<SystemParametersCodeMaster> projectId = new ArrayList<SystemParametersCodeMaster>();
		try {
			Criteria crt = session.createCriteria(SystemParametersCodeMaster.class);

			crt.add(Restrictions.eq("comType", COM_CURRENTLYAT));
			crt.add(Restrictions.eq("comValue", COM_CURRENTLYAT_InProject));


			projectId = crt.list();
			return projectId;
			
			
			/*
			Query id = session
					.createQuery(
							"select comId from SystemParametersCodeMaster  where comType=? and comValue=?")
					.setParameter(0, COM_CURRENTLYAT)
					.setParameter(1, COM_CURRENTLYAT_InProject);

			return id.executeUpdate();*/
			
			

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing assets......" + He);

		} finally {

			session.close();

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long getEmpIdByCode(long employeeCode) {
		Session session = sessionFactory.openSession();
		List<Employee> employees=new ArrayList<Employee>();
		try {
			Criteria crt = session.createCriteria(Employee.class);

			crt.add(Restrictions.eq("empCode", employeeCode));
			employees = crt.list();
			return employees.get(0).getEmpId();

		} catch (HibernateException He) {
			System.out.println(He);
			He.printStackTrace();
			log.error("error during fethcing employeeId......" + He);

		} finally {

			session.close();

		}
				return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean checkAsset(String assetNumber) {
		Session session = sessionFactory.openSession();
		List<Asset> assets = new ArrayList<Asset>();
		try {
			Criteria crt = session.createCriteria(Asset.class);

			crt.add(Restrictions.eq("assetNumber", assetNumber));
			assets = crt.list();
			if(assets.size()==0){
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

	@SuppressWarnings("unchecked")
	@Override
	public ServiceInfo getServiceInfoByAsset(int assetId) {
		Session session = sessionFactory.openSession();
		List<ServiceInfo>  infos = new ArrayList<ServiceInfo>();
		try {
			Criteria crt = session.createCriteria(ServiceInfo.class);

			crt.add(Restrictions.eq("siAssetCode", assetId));
			
			infos = crt.list();
			for(ServiceInfo serviceInfo:infos){
				return serviceInfo;
			}
			

		} catch (HibernateException He) {
			System.out.println(He);
			log.error("error during fethcing assets......" + He);
return null;

		} finally {

			session.close();

		}
		return null;
	}

	

	
}
