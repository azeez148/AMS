package com.experion.ams.dao.hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.PhysicalVerificationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PhysicalVerification;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.util.AMSUtil;
import com.experion.ams.util.AssetVerificationJson;

public class PhysicalVerificationHibernateDAO implements PhysicalVerificationDAO {
	
	MessageSource messageSource;
	private static final Log log = LogFactory.getLog(PhysicalVerificationHibernateDAO.class);
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<PhysicalVerification> getAllVerifications() {
		Session session=sessionFactory.openSession();
		 Criteria crt=session.createCriteria(PhysicalVerification.class);
		 crt.addOrder(Order.desc("physId"));
		// crt.addOrder(Order.asc("physicalverificationAsset.assetId"));
		 //crt.addOrder(Order.desc("verifiedDate"));
		
		 @SuppressWarnings("rawtypes")
		List<PhysicalVerification> verificationlist=crt.list();
		 System.out.println("sizeeeeeeeeeeeeeeeeeeee "+verificationlist.size());
	
		 session.close();
		return verificationlist;
	}

	@Override
	public List<PhysicalVerification> getSearchResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssetVerificationJson getVerifiedAssetDetail(String assetnumber) {
		
		AssetVerificationJson assetverificationjson=new AssetVerificationJson();
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(Asset.class);  
		c.add(Restrictions.eq("assetNumber",assetnumber));
		List<Asset> assetslist=c.list();
		System.out.println("dinkuccc"+assetslist.get(0).getAssetId());
		
		

		
	
		Criteria c1=session.createCriteria(PhysicalVerification.class);  
		c1.add(Restrictions.eq("physicalverificationAsset.assetId",assetslist.get(0).getAssetId()));
		
	

		@SuppressWarnings("unchecked")
		List<PhysicalVerification> verifiedAssetsDetail=c1.list();
		if(verifiedAssetsDetail.isEmpty())
		{
			System.out.println("enter if empty");
			
			
			assetverificationjson.setModel(assetslist.get(0).getAssetModel());
			assetverificationjson.setAssetId(assetslist.get(0).getAssetId());
			assetverificationjson.setDepartment(assetslist.get(0).getAssetDeptCode().getComValue());
			assetverificationjson.setProject(assetslist.get(0).getAssetProjectCode().getComValue());
			assetverificationjson.setCustodian(assetslist.get(0).getAssetCustodianCode().getEmpName());
			Date d=new Date();
			DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = targetFormat.format(d);
			assetverificationjson.setVerificationdate(formattedDate);
			assetverificationjson.setLastveridate(formattedDate);
			
			return assetverificationjson;
			
		}
		else
		{
			String lastverificate ="from PhysicalVerification p  where p.physicalverificationAsset.assetId=:aid order by p.physId DESC LIMIT 1";
			Query query=session.createQuery(lastverificate);
			query.setParameter("aid",assetslist.get(0).getAssetId());
			 verifiedAssetsDetail = query.list();
			
			
		//DetachedCriteria maxId = DetachedCriteria.forClass(PhysicalVerification.class)
				    //.setProjection( Projections.max("physId") );

			
		
			//Criteria c11=session.createCriteria(PhysicalVerification.class);  
			
			//c11.add(Restrictions.eq("physicalverificationAsset.assetId",assetslist.get(0).getAssetId()));
			//c11.add(Property.forName("physId").eq(maxId));
			
		//	verifiedAssetsDetail=results.list();
			
			
			assetverificationjson.setModel(verifiedAssetsDetail.get(0).getPhysicalverificationAsset().getAssetModel());
			assetverificationjson.setAssetId(verifiedAssetsDetail.get(0).getPhysicalverificationAsset().getAssetId());
			assetverificationjson.setDepartment(verifiedAssetsDetail.get(0).getPhysicalverificationAsset().getAssetDeptCode().getComValue());
			assetverificationjson.setProject(verifiedAssetsDetail.get(0).getPhysicalverificationAsset().getAssetProjectCode().getComValue());
			assetverificationjson.setCustodian(verifiedAssetsDetail.get(0).getPhysicalverificationAsset().getAssetCustodianCode().getEmpName());
			try {
				assetverificationjson.setLastveridate(AMSUtil.getSimpleDateFormat(verifiedAssetsDetail.get(0).getVerifiedDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}Date d=new Date();
			DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = targetFormat.format(d);
			assetverificationjson.setVerificationdate(formattedDate);
			session.close();
			return assetverificationjson;
			
		}
		
	}

	@Override
	public void addPhysicalVerification(PhysicalVerification phyveri,Employee sessionid) {
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(Employee.class);  
		c.add(Restrictions.eq("empId",sessionid.getEmpId()));
		List<Asset> empid=c.list();
		
	
		
		session.save(phyveri);
		session.close();
	}

	@Override
	public Employee getEmpSessionId(long sessionId) {
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(Employee.class);  
		c.add(Restrictions.eq("empCode",sessionId));
		List<Employee> empid=c.list();
		Employee emp=new Employee();
		emp.setEmpId(empid.get(0).getEmpId());
		session.close();
		return emp;
	}

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
	public List<PhysicalVerification> getSearchResultsAssetnumber(
			String assetnumber) {
		Session session=sessionFactory.openSession();
		 Criteria crt=session.createCriteria(Asset.class);
		 
		 crt.add(Restrictions.like("assetNumber", assetnumber,MatchMode.ANYWHERE));
		
		 @SuppressWarnings("rawtypes")
		List<Asset> verificationlist=crt.list();
		 List<PhysicalVerification> verification = null;
		if(!verificationlist.isEmpty())
		{
			 verification=verificationlist.get(0).getPhysicalverification();
		}

		
		return verification;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<PhysicalVerification> getSearchResults(String assetNumber,
//			Employee custodianId, AssetGroup groupCode,
//			SystemParametersCodeMaster deptCode,
//			SystemParametersCodeMaster locationCode,
//			SystemParametersCodeMaster projectCode) {
//		//
//		log.info("method to get search results dynamically....");
//
//		Session session = sessionFactory.openSession();
//		List<Asset> verification = new ArrayList<Asset>();
//		List<PhysicalVerification> phyVer = new ArrayList<PhysicalVerification>();
////		List<PhysicalVerification> verification = new ArrayList<PhysicalVerification>();
//		try {
//			Criteria crt = session.createCriteria(Asset.class);
//
//			
//			
//			if (!StringUtils.EMPTY.equals(assetNumber)) {
//				
////				crt.add(Restrictions.like("assetNumber", "%LenovoE440%"));
//
////				crt.add(Restrictions.like("assetNumber", assetNumber,));
//				crt.add(Restrictions.like("assetNumber", assetNumber,MatchMode.ANYWHERE));
//				verification = crt.list();
//				
//				System.out.println("to to assetnumber "+verification.get(0).getPhysicalverification());
//				
//				phyVer = verification.get(0).getPhysicalverification();
//				
//				System.out.println("to to assetnumber"+phyVer);
//
//			}
//
//			if (!(custodianId.getEmpId() == 0)) {
//				System.out.println("custodian "+custodianId);
//
//				crt.add(Restrictions.eq("assetCustodianCode", custodianId));
//				verification = crt.list();
//				System.out.println("to to custodian "+verification.get(0).getPhysicalverification());
//				
//                phyVer = verification.get(0).getPhysicalverification();
//				
//				System.out.println("to to custodian "+phyVer);
//			}
//			if (!groupCode.getGroupId().equals(0)) {
//				
//				System.out.println("GGGG");
//				
//				
//				
//				
//				crt.add(Restrictions.eq("assetGroupCode", groupCode));
//				verification = crt.list();
//				
//			}
//			if (!deptCode.getComId().equals(0)) {
//				System.out.println("DEPARTMENT "+deptCode.getComId());
//
//				crt.add(Restrictions.eq("assetDeptCode", deptCode));
//				verification = crt.list();
//           System.out.println("to to department "+verification);
//				
//                phyVer = verification.get(0).getPhysicalverification();
//				
//				System.out.println("to to department "+phyVer);
//				
//				
//			} 
//			if (!locationCode.getComId().equals(0)) {
//				System.out.println("1111");
//
//				crt.add(Restrictions.eq("assetLocationCode", locationCode));
//				verification = crt.list();
//				 System.out.println("to to Location "+verification.get(0).getPhysicalverification());
//					
//	                phyVer = verification.get(0).getPhysicalverification();
//					
//					System.out.println("to to Location "+phyVer);
//				
//			}
//			if (!projectCode.getComId().equals(0)) {
//				System.out.println("4444");
//
//				crt.add(Restrictions.eq("assetProjectCode", projectCode));
//				verification = crt.list();
//				System.out.println("to to project "+verification.get(0).getPhysicalverification());
//				
//                phyVer = verification.get(0).getPhysicalverification();
//				
//				System.out.println("to to project "+phyVer);
//				
//				
//			}
//
//			////verification = crt.list();
////			for(int i=0;i<assets.size();i++)
////			{
////				Criteria c1=session.createCriteria(PhysicalVerification.class);  
////				c1.add(Restrictions.eq("physicalverificationAsset.assetId",assets.get(i).getAssetId()));
////				
////				verification=c1.list();
////				
////			}
//			
//			
//
//		} catch (HibernateException He) {
//			System.out.println(He);
//			He.printStackTrace();
//			log.error("error during fethcing assets......" + He);
//
//		} finally {
//
//			session.close();
//
//		}
//		//System.out.println("ithaaanu result   "+verification.size());
//		
//		
//		
//		
//		
//		return phyVer;
//	}
//
//	@Override
//	public List<SystemParametersCodeMaster> getProjectIdByName(String comProject) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	


}
