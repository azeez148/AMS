package com.experion.ams.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;

import com.experion.ams.dao.AssetDepreciationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.service.AssetDepreciationService;
import com.experion.ams.util.DepreciationCalculationsJson;

public class AssetDepreciationServiceImpl implements AssetDepreciationService {
	
	MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	@Inject
	AssetDepreciationDAO assetdepreciationdao;

	public AssetDepreciationDAO getAssetdepreciationdao() {
		return assetdepreciationdao;
	}

	public void setAssetdepreciationdao(AssetDepreciationDAO assetdepreciationdao) {
		this.assetdepreciationdao = assetdepreciationdao;
	}

	@Override
	public List<AssetDepreciation> asetdepreciationList(int assetid,int count) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.asetdepreciationList(assetid,count);
	}

	@Override
	public List<AssetWorkflow> assetList(AssetDepreciation depr) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.assetList(depr);
	}

	@Override
	public List<AssetWorkflow> assetList(String assetnumber) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.assetList(assetnumber);
	}

	@Override
	public List<Asset> assetList(int assetid) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.assetList(assetid);
	}

	@Override
	public  DepreciationCalculationsJson depreciationAgeCalaculate(String date,int assetid) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.depreciationAgeCalaculate(date,assetid);
	}

	@Override
	public void addDepreciation(AssetDepreciation assetdepr) {
		// TODO Auto-generated method stub
		assetdepreciationdao.addDepreciation(assetdepr);
	}

	@Override
	public int getAssetSize() {
		// TODO Auto-generated method stub
		return assetdepreciationdao.getAssetSize();
	}

	@Override
	public int getAssetDeprSize(int assetid) {
		// TODO Auto-generated method stub
		return assetdepreciationdao.getAssetDeprSize(assetid);
	}

}
