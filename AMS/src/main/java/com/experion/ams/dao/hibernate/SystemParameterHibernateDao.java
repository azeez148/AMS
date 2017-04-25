package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.SystemParameterDAO;
import com.experion.ams.entity.SystemParametersCodeMaster;

public class SystemParameterHibernateDao implements SystemParameterDAO {
	MessageSource messageSource;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParametersCodeMaster> getSystemParameterList(String type,int count) {
		Session session=sessionFactory.openSession();

	

		
		 
		 
		 
		 Criteria crt=session.createCriteria(SystemParametersCodeMaster.class);
		 crt.add(Restrictions.eq("comType",type));
		 crt.add(Restrictions.ne("comCode",0));
		 crt.setFirstResult(count);
		 crt.setMaxResults(5);
		 @SuppressWarnings("rawtypes")
		List locationlist=crt.list();
	
		 session.close();
		 
		// System.out.println(locationlist);
		return locationlist;
		
	}

	@Override
	public void addSystemParameter(SystemParametersCodeMaster systemparametercodemaster) {
	
		//for(int i=0;i<systemparametercodemaster.;i++)
       // {

		if(systemparametercodemaster.getComId()==null)
		{
			Session session=sessionFactory.openSession();	
			@SuppressWarnings("unchecked")
			List<Integer> comcodequery=session.createQuery("SELECT comCode FROM SystemParametersCodeMaster  WHERE comType='"+systemparametercodemaster.getComType()+"' ORDER BY comCode DESC LIMIT 1 ").list();
		    int comcode=comcodequery.get(0)+1;
		    System.out.println("cccommmm codeee "+comcode);
			SystemParametersCodeMaster syscodemasterhib=new SystemParametersCodeMaster();
			syscodemasterhib.setComValue(systemparametercodemaster.getComValue());
			syscodemasterhib.setComDescription(systemparametercodemaster.getComDescription());
			syscodemasterhib.setComRemarks(systemparametercodemaster.getComRemarks());
			syscodemasterhib.setComType(systemparametercodemaster.getComType());
			syscodemasterhib.setComCode(comcode);
			syscodemasterhib.setComId(systemparametercodemaster.getComId());
			syscodemasterhib.setComUserEditable(0);
			syscodemasterhib.setComMenuOrder(null);
			syscodemasterhib.setComAddAttr1(null);
			syscodemasterhib.setComAddAttr2(null);
			syscodemasterhib.setComAddAttr3(null);
			
		    System.out.println("comid"+systemparametercodemaster.getComId());
			session.save(syscodemasterhib);
			session.close();
		}
		else
		{
			System.out.println("enterrrrrrrrrrrrrrrrr"+systemparametercodemaster.getComId());
			
//			SystemParametersCodeMaster syscodemasterhib=(SystemParametersCodeMaster) session.get(SystemParametersCodeMaster.class, systemparametercodemaster.getComId());
//			syscodemasterhib.setComValue(systemparametercodemaster.getComValue());
//			syscodemasterhib.setComDescription(systemparametercodemaster.getComDescription());
//			syscodemasterhib.setComRemarks(systemparametercodemaster.getComRemarks());
//			
//			
//			
//			
//			
//		    System.out.println("comid"+systemparametercodemaster.getComId());
//			session.update(syscodemasterhib);
			
			Session session2=sessionFactory.openSession();
			
			String hql = "UPDATE SystemParametersCodeMaster set comValue = :comvalue,comDescription = :comdescription,comRemarks = :comremarks WHERE comId = :comid";
			Query query = session2.createQuery(hql);
			query.setParameter("comvalue", systemparametercodemaster.getComValue());
			query.setParameter("comdescription", systemparametercodemaster.getComDescription());
			query.setParameter("comremarks", systemparametercodemaster.getComRemarks());
			query.setParameter("comid", systemparametercodemaster.getComId());
			@SuppressWarnings("unused")
			int result = query.executeUpdate();
			
			session2.close();
			
		}

		
      //  }
		
	}
	
	



	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParametersCodeMaster> getMasterValue() {
		Session session=sessionFactory.openSession();
	
		
		
		 Criteria crt=session.createCriteria(SystemParametersCodeMaster.class);
		 
		 crt.add(Restrictions.eq("comCode",0));
		 
		
		@SuppressWarnings("rawtypes")
		List masterlist=crt.list();
		
		session.close();
		return masterlist;
	
	}

	@Override
	public int getParameterSize(String type) {
		Session session=sessionFactory.openSession();

		

		
		 
		 
		 
		 Criteria crt=session.createCriteria(SystemParametersCodeMaster.class);
		 crt.add(Restrictions.eq("comType",type));
		 crt.add(Restrictions.ne("comCode",0));
		 @SuppressWarnings("rawtypes")
		int pagecount=crt.list().size();
	
		 session.close();
		 
		 return pagecount;
	}

	

}
