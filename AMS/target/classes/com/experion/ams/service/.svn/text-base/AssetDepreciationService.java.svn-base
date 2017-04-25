package com.experion.ams.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.util.DepreciationCalculationsJson;

public interface AssetDepreciationService {
	List<AssetDepreciation> asetdepreciationList(int assetid,int count);
	List<AssetWorkflow> assetList(AssetDepreciation assetdepr);
	List<AssetWorkflow> assetList(String assetnumber);
	List<Asset> assetList(int assetid);
	DepreciationCalculationsJson depreciationAgeCalaculate(String date,int assetid);
	void addDepreciation(AssetDepreciation assetdepr);
	int getAssetSize();
	int getAssetDeprSize(int assetid);
}
