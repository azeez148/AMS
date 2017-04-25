package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.AmsServiceInfoHistoryDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.ServiceInfo;

public class AmsServiceInfoHistoryHibernateDAO implements AmsServiceInfoHistoryDAO {
	MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}



	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<AssetWorkflow> getAssets() {
	
		Session session = sessionFactory.openSession();
		
		 Criteria crt=session.createCriteria(AssetWorkflow.class);
		 crt.add(Restrictions.eq("workflowAssetStatus","Approved")); 
		 crt.add(Restrictions.eq("workflowAssetType","Asset Approve")); 
		 @SuppressWarnings("unchecked")
		List<AssetWorkflow> assetworkflow=crt.list();
		return assetworkflow;
	}

	@Override
	public List<Asset> getHistoryById(Integer assetId) {
		
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Asset> info  = session.createQuery(
				"FROM Asset where assetId = "+assetId).list();
		session.close();

		return info;
	}

	@Override
	public List<ServiceInfo> getServiceinfoHistory(int assetId) {
	
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<ServiceInfo> info  = session.createQuery(
				"FROM ServiceInfo where siAssetCode.assetId = "+assetId).list();
		session.close();

		return info;
	}

	@Override
	public List<ServiceInfo> getServiceinfoHistory() {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<ServiceInfo> info = session.createQuery(
				"FROM ServiceInfo").list();
		
		session.close();
		return info;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetWorkflow> searchAsset(String assetNumber) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from AssetWorkflow  where workflowAssetCode.assetNumber like :assetNumber and workflowAssetStatus=:workflowstatus");
		query.setString("assetNumber", "%" + assetNumber + "%");
		query.setString("workflowstatus","Approved");
		List<AssetWorkflow> asset = query.list();
		session.close();
		return asset;
	}

	

}
