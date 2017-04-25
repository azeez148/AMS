package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

public interface AmsPurchaseInfoService {

	List<Asset> getPurchaseInfo();

	List<PurchaseInfo> getPurchaseInfoById(int i);

	void addPurchaseinfo(PurchaseInfo info);

	void updateInfo(PurchaseInfo purchaseInfo);

	List<Asset> searchAsset(String assetNumber);

	List<AssetGroupDepreciationMap> getDepriciation(Long integer);

	List<Asset> getAssetbyId(Integer assetId);

	List<AssetDepreciation> listDdepriciationDetails();

	List<SystemParametersCodeMaster> getVendor(String string);

	void assetApprove(AssetWorkflow assetWorkFlow);


}
