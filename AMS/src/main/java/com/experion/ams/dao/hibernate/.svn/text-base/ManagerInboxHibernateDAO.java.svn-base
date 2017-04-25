package com.experion.ams.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.ManagerInboxDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.util.AMSUtil;

public class ManagerInboxHibernateDAO implements ManagerInboxDAO {
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

	public List<AssetWorkflow> getAllPendingAssets() {
		Session session = sessionFactory.openSession();
		String hql = "FROM AssetWorkflow AW where AW.workflowAssetStatus in (:assetStatus1, :assetStatus2, :assetStatus3)";
		Query query = session.createQuery(hql);
		query.setParameter("assetStatus1", "Pending Approval");
		query.setParameter("assetStatus2", "Write-off Request");
		query.setParameter("assetStatus3", "Re-Value Request");
		List<AssetWorkflow> reqAssets = query.list();
		session.close();
		return reqAssets;
	}

	@Override
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus) {
		Session session = sessionFactory.openSession();
		String hql = "FROM AssetWorkflow AW where AW.workflowAssetStatus =:assetStatus";
		Query query = session.createQuery(hql);
		query.setParameter("assetStatus", assetStatus);
		List<AssetWorkflow> searchValue = query.list();
		session.close();
		return searchValue;
	}

	@Override
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus,
			String assetNo) {
		List<AssetWorkflow> assetWorkflowList = searchAssetManagerInbox(assetStatus);
		System.out.println("asset work flow before iterate: "
				+ assetWorkflowList);
		for (Iterator<AssetWorkflow> iterator = assetWorkflowList.iterator(); iterator
				.hasNext();) {
			AssetWorkflow assetWorkflow = iterator.next();
			String assetNumber = assetWorkflow.getWorkflowAssetCode()
					.getAssetNumber().toLowerCase();
			if (!assetNumber.startsWith(assetNo.toLowerCase())) {
				// Remove the current element from the iterator and the list.
				System.out.println("going to remove : "
						+ assetWorkflow.getWorkflowAssetCode().getAssetNumber()
						+ " and " + assetWorkflowList);
				iterator.remove();
			}
		}
		System.out.println("asset work flow after iterate: "
				+ assetWorkflowList);
		return assetWorkflowList;
	}

	@Override
	public List<Asset> getApprovedAssets(Integer assetId) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Asset A where A.assetId =:assetId";
		Query query = session.createQuery(hql);
		query.setParameter("assetId", assetId);
		List<Asset> approvedAsset = query.list();
		session.close();
		return approvedAsset;
	}

	@Override
	public void approveAssetForWrite(Asset asset, AssetDisposal assetDisposal) {
		try {
			Session session = sessionFactory.openSession();
			Asset assetNew = (Asset) session.get(Asset.class,
					asset.getAssetId());
			assetNew.setAssetNumber(asset.getAssetNumber());
			assetNew.setAssetModel(asset.getAssetModel());
			assetNew.setAssetDescription(asset.getAssetDescription());
			assetNew.setAssetCapitalizationDate(AMSUtil.getSimpleDate(asset.getDate()));
			assetNew.getAssetDisposal().setAssetDispWriteOffAmount(
					assetDisposal.getAssetDispWriteOffAmount());
			assetNew.getAssetWorkflow().setWorkflowAssetStatus("Approved");
			session.merge(assetNew);
			session.flush();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void approveAssetForRevalue(Asset asset, AssetRevalue assetRevalue) {
		try {
			Session session = sessionFactory.openSession();
			Asset assetNew = (Asset) session.get(Asset.class,
					asset.getAssetId());
			assetNew.setAssetNumber(asset.getAssetNumber());
			assetNew.setAssetModel(asset.getAssetModel());
			assetNew.setAssetDescription(asset.getAssetDescription());
			assetNew.setAssetCapitalizationDate(AMSUtil.getSimpleDate(asset.getDate()));
			assetNew.getAssetRevalue().setRevRevalueAmount(
					assetRevalue.getRevRevalueAmount());
			assetNew.getAssetWorkflow().setWorkflowAssetStatus("Approved");
			session.merge(assetNew);
			session.flush();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void rejectAssetForWriteRevalue(Asset asset,
			AssetWorkflow assetWorkflow) {
		try {
			Session session = sessionFactory.openSession();
			Asset assetNew = (Asset) session.get(Asset.class,
					asset.getAssetId());
			assetNew.getAssetWorkflow().setWorkflowAssetStatus("Rejeted");
			assetNew.getAssetWorkflow().setWorkflowManagerRejectReason(
					assetWorkflow.getWorkflowManagerRejectReason());
			session.merge(assetNew);
			session.flush();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void approveRejectForAsset(Asset asset, AssetWorkflow assetWorkflow) {
		try
		{
		Session session = sessionFactory.openSession();
		Asset assetNew = (Asset) session.get(Asset.class, asset.getAssetId());
		assetNew.getAssetWorkflow().setWorkflowAssetStatus(
				assetWorkflow.getWorkflowAssetStatus());
		if (assetWorkflow.getWorkflowAssetStatus().startsWith("Rej")){
			assetNew.getAssetWorkflow().setWorkflowManagerRejectReason(
					assetWorkflow.getWorkflowManagerRejectReason());
			System.out.println("asset reject reason "+assetWorkflow.getWorkflowManagerRejectReason());
		}
		session.merge(assetNew);
		session.flush();
		session.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	}

	@Override
	public int updateAproveAssetValues(Asset asset, PurchaseInfo purchaseInfo) {
		int status =0;
		try {
			Session session = sessionFactory.openSession();
			Asset assetNew = (Asset) session.get(Asset.class,
					asset.getAssetId());
			
			/*Asset Information*/
			assetNew.setAssetMake(asset.getAssetMake());
			assetNew.setAssociatedAssetId(asset.getAssociatedAssetId());
			assetNew.setAssetGroupCode(asset.getAssetGroupCode());
			assetNew.setAssetDescription(asset.getAssetDescription());
			assetNew.setAssetModel(asset.getAssetModel());
			assetNew.setAssetModelNumber(asset.getAssetModelNumber());
			assetNew.setAssetSerialNumber(asset.getAssetSerialNumber());
			assetNew.setAssetNotes(asset.getAssetNotes());
			assetNew.setAssetWarrantyPeriod(asset.getAssetWarrantyPeriod());
			assetNew.setAssetWarrantyEndDate(AMSUtil.getSimpleDate(asset.getDate()));
			assetNew.setAssetType(asset.getAssetType());
			assetNew.setAssetCondition(asset.getAssetCondition());
			assetNew.setFileName(asset.getFileName());
			assetNew.setAssetCurrentlyAt(asset.getAssetCurrentlyAt());
			
			/*Purchase Information*/
			assetNew.getPurchaseinfo().setPiVender(purchaseInfo.getPiVender());
			assetNew.getPurchaseinfo().setPiInviceNo(purchaseInfo.getPiInviceNo());
			assetNew.getPurchaseinfo().setInvoiceDate(purchaseInfo.getInvoiceDate());
			assetNew.getPurchaseinfo().setPiPoNumber(purchaseInfo.getPiPoNumber());
			assetNew.getPurchaseinfo().setPipoDate(purchaseInfo.getPipoDate());
			assetNew.getPurchaseinfo().setPiDeliveryDate(AMSUtil.getSimpleDate(purchaseInfo.getDeliveryDate()));
			assetNew.getPurchaseinfo().setPiCaptialDate(purchaseInfo.getPiCaptialDate());
			assetNew.getPurchaseinfo().setPiPurchasecost(purchaseInfo.getPiPurchasecost());
			
			/*Purchase Request Order*/
			assetNew.setAssetPurchaseReqName(asset.getAssetPurchaseReqName());
			assetNew.setAssetPurchaseReqNumber(asset.getAssetPurchaseReqNumber());
			assetNew.setAssetPurchaseReqDate(AMSUtil.getSimpleDate(asset.getDate()));
			
			session.merge(assetNew);
			session.flush();
			session.close();
			status = 1;
		} catch (Exception e) {
			status = 0;
			System.out.println(e);
		}
		return status;
	}
}
