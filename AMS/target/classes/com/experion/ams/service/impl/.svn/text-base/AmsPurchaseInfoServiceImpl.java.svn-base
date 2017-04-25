package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.dao.AmsPurchaseInfoDAO;
import com.experion.ams.service.AmsPurchaseInfoService;

@Service
public class AmsPurchaseInfoServiceImpl implements AmsPurchaseInfoService {
	
	@Inject
	private AmsPurchaseInfoDAO purchaseDAO;

	public AmsPurchaseInfoDAO getPurchaseDAO() {
		return purchaseDAO;
	}

	public void setPurchaseDAO(AmsPurchaseInfoDAO purchaseDAO) {
		this.purchaseDAO = purchaseDAO;
	}
	MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	

	@Override
	public List<Asset> getPurchaseInfo() {
		
		return purchaseDAO.getPurchaseInfo();
	}

	@Override
	public List<PurchaseInfo> getPurchaseInfoById(int i) {
		
		return purchaseDAO.getPurchaseInfoById(i);
	}

	@Override
	public void addPurchaseinfo(PurchaseInfo info) {
       purchaseDAO.addPurchaseinfo(info);
		
	}

	@Override
	public void updateInfo(PurchaseInfo purchaseInfo) {
		
	       purchaseDAO.updateInfo(purchaseInfo);
	}

	@Override
	public List<Asset> searchAsset(String assetNumber) {
		
		return purchaseDAO.searchAsset(assetNumber);
	}

	@Override
	public List<AssetGroupDepreciationMap> getDepriciation(
			Long assetGroupCode) {
		 return purchaseDAO.getDepriciation(assetGroupCode);
	}

	@Override
	public List<Asset> getAssetbyId(Integer assetId) {
		
		return purchaseDAO.getAssetbyId(assetId);
	}

	@Override
	public List<AssetDepreciation> listDdepriciationDetails() {
		
		return purchaseDAO.listDdepriciationDetails();
	}

	@Override
	public List<SystemParametersCodeMaster> getVendor(String string) {
		
		return purchaseDAO.getVendor(string);
	}

	@Override
	public void assetApprove(AssetWorkflow assetWorkFlow) {
		 purchaseDAO.assetApprove(assetWorkFlow);
		
	}

	

}
