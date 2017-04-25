package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

public interface AmsPurchaseInfoDAO {

	List<Asset> getPurchaseInfo();

	List<PurchaseInfo> getPurchaseInfoById(int i);

	void addPurchaseinfo(PurchaseInfo info);

	void updateInfo(PurchaseInfo purchaseInfo);

	List<Asset> searchAsset(String assetNumber);

	List<AssetGroupDepreciationMap> getDepriciation(Long assetGroupCode);

	List<Asset> getAssetbyId(Integer assetId);

	List<AssetDepreciation> listDdepriciationDetails();

	List<SystemParametersCodeMaster> getVendor(String string);

	void assetApprove(AssetWorkflow assetWorkFlow);


	

}
