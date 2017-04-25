package com.experion.ams.dao.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.AssetDepreciationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.util.AMSUtil;
import com.experion.ams.util.DepreciationCalculationsJson;

public class AssetDepreciationHibernateDAO implements AssetDepreciationDAO {
	
	
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

	@Override
	public List<AssetDepreciation> asetdepreciationList(int assetid,int count) {
		
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(AssetDepreciation.class);  
		c.add(Restrictions.eq("asset.assetId",assetid));
		c.setFirstResult(count);
		 c.setMaxResults(3);
		@SuppressWarnings("unchecked")
		List<AssetDepreciation> assetDeprList=c.list();

		 session.close();
		
		return assetDeprList;
	
	}

	@Override
	public List<AssetWorkflow> assetList(AssetDepreciation assetdepr) {
		Session session = sessionFactory.openSession();
		
		 Criteria crt=session.createCriteria(AssetWorkflow.class);
		 crt.add(Restrictions.eq("workflowAssetStatus","Approved")); 
		 crt.add(Restrictions.eq("workflowAssetType","Asset Approve")); 
		crt.setFirstResult(assetdepr.getPagecountHidden());
		
		 crt.setMaxResults(5);
		
			List<AssetWorkflow> assetworkflow=crt.list();
		
	
		return assetworkflow;
	}

	@Override
	public List<AssetWorkflow> assetList(String assetnumber) {
		Session session = sessionFactory.openSession();
	    Query query = session
	      .createQuery("from AssetWorkflow  where workflowAssetCode.assetNumber like :assetNumber and workflowAssetStatus=:workflowstatus");
	    query.setString("assetNumber", "%" + assetnumber + "%");
	    query.setString("workflowstatus","Approved");
	    List<AssetWorkflow> assetList = query.list();
	    session.close();
		return assetList;
	}

	@Override
	public List<Asset> assetList(int assetid) {
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(Asset.class);  
		c.add(Restrictions.eq("assetId",assetid)); 
		@SuppressWarnings("unchecked")
		List<Asset> assetList=c.list();
		 session.close();
		return assetList;
	}

	@Override
	public  DepreciationCalculationsJson depreciationAgeCalaculate(String date,int assetid) {
		// TODO Auto-generated method stub
		
		//Date d=AMSUtil.getSimpleDate(date);
		
		//AMSUtil.getDaysBetweenDates(date, toDate)
		DepreciationCalculationsJson depreciationCalculationsJson = new DepreciationCalculationsJson();
		
		
		double Bookvalue;
		double depramount;
		Date deliverydate = null;
		Session session = sessionFactory.openSession();
		Criteria c=session.createCriteria(AssetDepreciation.class);  
		c.add(Restrictions.eq("asset.assetId",assetid));

		@SuppressWarnings("unchecked")
		List<AssetDepreciation> assetDeprList=c.list();
		
		
		
		
		
		
		if(assetDeprList.isEmpty())
		{
			Date currentdate=AMSUtil.getSimpleDate(date);
			System.out.println("if.....current date "+currentdate);
			
			double dbbookvalue = 0;
			double dbdeprvalue = 0;
			Criteria cr=session.createCriteria(Asset.class);  
			cr.add(Restrictions.eq("assetId",assetid));

			List<Asset> assetDeliverydate=cr.list();
			
		
		
			try {
			String deliveryDbdate=AMSUtil.getSimpleDateFormat(assetDeliverydate.get(0).getPurchaseinfo().getPiDeliveryDate());
			deliverydate=AMSUtil.getSimpleDate(deliveryDbdate);
			System.out.println("delivery date is from date  "+deliverydate );
		     dbbookvalue=assetDeliverydate.get(0).getPurchaseinfo().getPiPurchasecost();
		     String dpvalue[] =assetDeliverydate.get(0).getAssetGroupCode().getGroupDepreciation().getDepriciateValue().split("%");
			 dbdeprvalue=Double.parseDouble(dpvalue[0]);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int days=AMSUtil.getDaysBetweenDates(deliverydate,currentdate );
			System.out.println(" if days...."+days);
			depramount=AMSUtil.getDeprAmount(dbbookvalue, dbdeprvalue,days);
			Bookvalue=dbbookvalue-depramount;
			depreciationCalculationsJson.setDays(days);
			depreciationCalculationsJson.setDepramount(depramount);
			
			
			
			depreciationCalculationsJson.setAccumulated(depramount);
			depreciationCalculationsJson.setBookvalue(Bookvalue);
			depreciationCalculationsJson.setAssetid(assetid);
			try {
				depreciationCalculationsJson.setFromdate(AMSUtil.getSimpleDateFormat(assetDeliverydate.get(0).getPurchaseinfo().getPiDeliveryDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			  
			  
			 session.close();
			  
			  
		}
		else
		{
			
			Session session1 = sessionFactory.openSession();
			
			Criteria cr=session.createCriteria(Asset.class);  
			cr.add(Restrictions.eq("assetId",assetid));

			List<Asset> assetDeliverydate=cr.list();
			String deliveryDbdate = null;
			try {
				deliveryDbdate = AMSUtil.getSimpleDateFormat(assetDeliverydate.get(0).getPurchaseinfo().getPiDeliveryDate());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			deliverydate=AMSUtil.getSimpleDate(deliveryDbdate);
			
			
			
			
//			Criteria c1=session.createCriteria(AssetDepreciation.class);  
//			c1.add(Restrictions.eq("asset.assetId",assetid));
//			@SuppressWarnings("unchecked")
//			List<AssetDepreciation> assetDeprList1=c.list();
			DetachedCriteria maxId = DetachedCriteria.forClass(AssetDepreciation.class)
				    .setProjection( Projections.max("depreciationId") );
			@SuppressWarnings("unchecked")
			List<AssetDepreciation> assetDeprList1=	session.createCriteria(AssetDepreciation.class)
				    .add( Property.forName("depreciationId").eq(maxId) )
				    .list();
			
			System.out.println("depreciationnnnn iddd..."+assetDeprList1.get(0).getDepreciationId());
			
			Date currentdate=AMSUtil.getSimpleDate(date);
			System.out.println("else.....current date "+currentdate);
			Date Fromdate = null;
			double dbbookvalue = 0;
			double dbdeprvalue = 0;
			
			
			
				try {
					
					
					
					String fromDbdate=AMSUtil.getSimpleDateFormat(assetDeprList1.get(0).getDepreciationTo());
					Fromdate=AMSUtil.getSimpleDate(fromDbdate);
					System.out.println("from date from db "+Fromdate);
				     dbbookvalue=assetDeprList1.get(0).getDepreciationBookValue();
				     String dpvalue[] =assetDeprList1.get(0).getAsset().getAssetGroupCode().getGroupDepreciation().getDepriciateValue().split("%");
					 dbdeprvalue=Double.parseDouble(dpvalue[0]);
					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	
		
			
			
			int days=AMSUtil.getDaysBetweenDates(deliverydate,currentdate);
			System.out.println("days...."+days);
			depramount=AMSUtil.getDeprAmount(dbbookvalue, dbdeprvalue,days);
			Bookvalue=dbbookvalue-depramount;
			depreciationCalculationsJson.setDays(days);
			depreciationCalculationsJson.setDepramount(depramount);
			
			
			Criteria accumulatedcriteria=session.createCriteria(AssetDepreciation.class);  
			accumulatedcriteria.add(Restrictions.eq("asset.assetId",assetid));
			accumulatedcriteria.setProjection(Projections.sum("depreciationAccumulatedAmount"));
			@SuppressWarnings("unchecked")
			List<AssetDepreciation> accumulatedvalue=c.list();
			
			for(int i=0;i<accumulatedvalue.size();i++)
			{
				depreciationCalculationsJson.setAccumulated(accumulatedvalue.get(i).getDepreciationAccumulatedAmount()+depramount);	
			}
			
			
			
			depreciationCalculationsJson.setBookvalue(Bookvalue);
			depreciationCalculationsJson.setAssetid(assetid);
			try {
				depreciationCalculationsJson.setFromdate(AMSUtil.getSimpleDateFormat(assetDeprList1.get(0).getDepreciationTo()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session1.close();
			
			
		}
		
		
		
		
		
		
		return depreciationCalculationsJson;
		
	}

	@Override
	public void addDepreciation(AssetDepreciation assetdepr) {
		Session session=sessionFactory.openSession();	
		session.save(assetdepr);
		session.close();
		
	}

	@Override
	public int getAssetSize() {
		Session session=sessionFactory.openSession();

		

		
		 
		 
		 
		 Criteria crt=session.createCriteria(Asset.class);
		
		 @SuppressWarnings("rawtypes")
		int pagecount=crt.list().size();
	
		 session.close();
		 
		 return pagecount;
	}

	@Override
	public int getAssetDeprSize(int assetid) {
		Session session=sessionFactory.openSession();

		

		
		 
		 
		 
		 Criteria crt=session.createCriteria(AssetDepreciation.class);
		 crt.add(Restrictions.eq("asset.assetId",assetid));
		 @SuppressWarnings("rawtypes")
		int pagecount=crt.list().size();
	
		 session.close();
		 
		 return pagecount;
	}

}
