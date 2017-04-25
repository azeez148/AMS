package com.experion.ams.dao;


import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.util.DepreciationCalculationsJson;

public interface AssetDepreciationDAO {
	List<AssetDepreciation> asetdepreciationList(int assetid,int count);
	List<AssetWorkflow> assetList(AssetDepreciation assetdepr);
	List<Asset> assetList(int assetid);
	List<AssetWorkflow> assetList(String assetnumber);
	DepreciationCalculationsJson depreciationAgeCalaculate(String date,int assetid);
	void addDepreciation(AssetDepreciation assetdepr);
	int getAssetSize();
	int getAssetDeprSize(int assetid);
	
	

}
