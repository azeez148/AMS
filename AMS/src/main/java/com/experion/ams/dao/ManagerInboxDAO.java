package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;

public interface ManagerInboxDAO {

	public List<AssetWorkflow> getAllPendingAssets();
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus);
	public List<AssetWorkflow> searchAssetManagerInbox(String assetStatus,String assetNo);
	public List<Asset> getApprovedAssets(Integer assetId);
	public void approveAssetForWrite(Asset asset, AssetDisposal assetDisposal);
	public void approveAssetForRevalue(Asset asset, AssetRevalue assetRevalue);
	public void rejectAssetForWriteRevalue(Asset asset, AssetWorkflow assetWorkflow);
	public void approveRejectForAsset(Asset asset, AssetWorkflow assetWorkflow);
	public int updateAproveAssetValues(Asset asset, PurchaseInfo purchaseInfo);
}
