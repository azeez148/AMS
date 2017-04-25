package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.DashboardDao;
import com.experion.ams.dao.ManagerInboxDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.service.ManagerInboxService;

public class ManagerInboxServiceImpl implements ManagerInboxService{
	@Inject
	private ManagerInboxDAO managerInboxDAO;
	
	public ManagerInboxDAO getManagerInboxDAO() {
		return managerInboxDAO;
	}

	public void setManagerInboxDAO(ManagerInboxDAO managerInboxDAO) {
		this.managerInboxDAO = managerInboxDAO;
	}

	MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public List<AssetWorkflow> getAllPendingAssets(){
		List<AssetWorkflow> mngAssets = managerInboxDAO.getAllPendingAssets();
		return mngAssets;
	}

	@Override
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus) {
		List<AssetWorkflow> searchValue = managerInboxDAO.searchAssetManagerInbox(assetStatus);
		return searchValue;
	}

	@Override
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus,
			String assetNo) {
		List<AssetWorkflow> searchValue = managerInboxDAO.searchAssetManagerInbox(assetStatus,assetNo);
		return searchValue;
	}

	@Override
	public List<Asset> getApprovedAssets(Integer assetId) {
		List<Asset> approvedAsset = managerInboxDAO.getApprovedAssets(assetId);
		return approvedAsset;
	}

	@Override
	public void approveAssetForWrite(Asset assetId, AssetDisposal assetDisposal) {
		managerInboxDAO.approveAssetForWrite(assetId, assetDisposal);
	}

	@Override
	public void approveAssetForRevalue(Asset assetId, AssetRevalue assetRevalue) {
		managerInboxDAO.approveAssetForRevalue(assetId, assetRevalue);	
	}

	@Override
	public void rejectAssetForWriteRevalue(Asset asset, AssetWorkflow assetWorkflow) {
		managerInboxDAO.rejectAssetForWriteRevalue(asset, assetWorkflow);	
	}

	@Override
	public void approveRejectForAsset(Asset asset, AssetWorkflow assetWorkflow) {
		managerInboxDAO.approveRejectForAsset(asset, assetWorkflow);
	}

	@Override
	public int updateAproveAssetValues(Asset asset, PurchaseInfo purchaseInfo) {
		int status = managerInboxDAO.updateAproveAssetValues(asset,purchaseInfo);
		return status;
	}
}
