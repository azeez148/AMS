package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.MessageSource;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.dao.AmsPurchaseInfoDAO;

public class AmsPurchaseInfoHibernateDAO implements AmsPurchaseInfoDAO {
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
	public List<Asset> getPurchaseInfo() {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Asset> asset = session.createQuery(
				"FROM Asset").list();
		
		session.close();
		
		//System.out.println("Asset in DAO ....... "+asset);
		return asset;
		
	}

	
	@Override
	public List<PurchaseInfo> getPurchaseInfoById(int i) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<PurchaseInfo> info  = session.createQuery(
				"FROM PurchaseInfo where pi_asset_code = "+i).list();
		session.close();
		//System.out.println("PurchaseInfo in DAO with id....... "+info);
		return info;
	}

	@Override
	public void addPurchaseinfo(PurchaseInfo info) {
	Session session = sessionFactory.openSession();
	
	System.out.println("save purchase info in dao........."+info.toString());
	session.save(info);
	session.close();
		
	}

	@Override
	public void updateInfo(PurchaseInfo purchaseInfo) {
	   
		System.out.println(purchaseInfo.toString());
		Session session = sessionFactory.openSession();
      //  purchaseInfo.setVendorCode(purchaseInfo.getVendorCode());
   
	    System.out.println("Correct update in db"+purchaseInfo.toString());
	    session.merge(purchaseInfo);
	    session.flush();
	   session.close();
	
	    
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> searchAsset(String assetNumber) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Asset a where a.assetNumber like :assetNumber");
		query.setString("assetNumber", "%" + assetNumber + "%");
		List<Asset> asset = query.list();
		session.close();
		return asset;
	
	}

	@Override
	public List<AssetGroupDepreciationMap> getDepriciation(
			Long assetGroupCode) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<AssetGroupDepreciationMap> info  = session.createQuery(
				"FROM AssetGroupDepreciationMap where groupMaster.groupId = "+assetGroupCode).list();
		session.close();
		//System.out.println("PurchaseInfo in DAO with id....... "+info);
		return info;
		
	}

	@Override
	public List<Asset> getAssetbyId(Integer assetId) {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Asset> info  = session.createQuery(
				"FROM Asset where assetId = "+assetId).list();
		session.close();
		//System.out.println("PurchaseInfo in DAO with id....... "+info);

		return info;
	}

	@Override
	public List<AssetDepreciation> listDdepriciationDetails() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<AssetDepreciation> depr = session.createQuery(
				"FROM AssetDepreciation").list();
		
		session.close();
		return depr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParametersCodeMaster> getVendor(String string) {
		Session session=sessionFactory.openSession();
		 
		 Criteria crt=session.createCriteria(SystemParametersCodeMaster.class);
		 crt.add(Restrictions.eq("comType",string));
		 crt.add(Restrictions.ne("comCode",0));
		 @SuppressWarnings("rawtypes")
		List vendorlist=crt.list();
	
		 session.close();
		 
		System.out.println(vendorlist);
		return vendorlist;
	
	}

	@Override
	public void assetApprove(AssetWorkflow assetWorkFlow) {
		Session session = sessionFactory.openSession();
		
		session.save(assetWorkFlow);
		session.close();
		
	}

	

}
