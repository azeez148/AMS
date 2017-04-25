package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.ServiceInfoDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

/**
 * 
 * @author surya
 *
 */
public class ServiceInfoHibernateDAO implements ServiceInfoDAO {
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private MessageSource messageSource;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public List<Asset> getAssetList() {
		Session session = sessionFactory.openSession();
		List<Asset> asset = session.createQuery("from Asset").list();
	/*	for (Asset a : asset) {
			
			Integer deptCode = a.getAssetDeptCodeInt();
			Integer projectCode = a.getAssetProjectCodeInt();
			Query queryProject = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='PRJ' and code.comId=:projectCode");
			Query queryDept = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='DPT' and code.comId=:deptCode");
			queryProject.setInteger("projectCode", projectCode);
			queryDept.setInteger("deptCode", deptCode);
			a.setComValuePrj((String) queryProject.uniqueResult());
			a.setComValueDpt((String) queryDept.uniqueResult());

		}*/
		return asset;
	}

	public List<Asset> getAssetByNumber(String assetNumber) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Asset a where a.assetNumber like :assetNumber");
		query.setString("assetNumber", "%" + assetNumber + "%");
		List<Asset> asset = query.list();
		/*for (Asset a : asset) {
			Integer deptCode = a.getAssetDeptCodeInt();
			Integer projectCode = a.getAssetProjectCodeInt();
			Query queryProject = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='PRJ' and code.comId=:projectCode ");
			Query queryDept = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='DPT' and code.comId=:deptCode ");
			queryProject.setInteger("projectCode", projectCode);
			queryDept.setInteger("deptCode", deptCode);
			a.setComValuePrj((String) queryProject.uniqueResult());
			a.setComValueDpt((String) queryDept.uniqueResult());

		}*/
		session.close();
		return asset;
	}

	public ServiceInfo getServiceInfoByAssetCode(Integer assetCode) {
		ServiceInfo serviceinfo = null;
		try {
			Session session = sessionFactory.openSession();
			Query query = session
					.createQuery("from ServiceInfo where siAssetCode=:siAssetCode");
			query.setInteger("siAssetCode", assetCode);
			serviceinfo = (ServiceInfo) query.uniqueResult();
			/*Integer serviceProviderCode = serviceinfo
					.getSiServiceProviderCd();
			Query querySP = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='SP' and code.comId=:serviceProviderCode ");
			querySP.setInteger("serviceProviderCode", serviceProviderCode);
			serviceinfo.setComValueSP((String) querySP.uniqueResult());*/
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceinfo;
	}

	public Long getEmployeeId(Long EmployeeCode){
		Session session =sessionFactory.openSession();
		Long EmployeeId=null;
		try{
		Query queryId=session.createQuery("SELECT empId from Employee as emp where emp.empCode=:empCode");
		queryId.setLong("empCode", EmployeeCode);
		 EmployeeId=(Long)queryId.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
		}
		return EmployeeId;
		
	}
	public void updateServiceInfo(ServiceInfo serviceinfo) {
		try {
			Session session = sessionFactory.openSession();
			Integer siId = serviceinfo.getSiId();
			ServiceInfo serviceinf = (ServiceInfo) session.get(
					ServiceInfo.class, siId);
			serviceinf.setSiServiceProviderCd(serviceinfo
					.getSiServiceProviderCd());
			serviceinf.setSiContractNumber(serviceinfo.getSiContractNumber());
			serviceinf.setSiNoServicesYear(serviceinfo.getSiNoServicesYear());
			serviceinf.setSiLastServiceDate(serviceinfo.getSiLastServiceDate());
			serviceinf.setSiNextServiceDate(serviceinfo.getSiNextServiceDate());
			serviceinf.setSiUpdatedBy(serviceinfo.getSiUpdatedBy());
			serviceinf.setSiUpdatedDate(serviceinfo.getSiUpdatedDate());
			//session.update(serviceinf);
			session.merge(serviceinf);
			session.flush();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<SystemParametersCodeMaster> getServiceProvider() {

		Session session = sessionFactory.openSession();

		List<SystemParametersCodeMaster> codemaster = session.createQuery("from SystemParametersCodeMaster as code where code.comType='SP' and code.comCode!=0").list();

		return codemaster;
	}
	
	

}
