package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;

import com.experion.ams.dao.AmsServiceInfoHistoryDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.service.AmsServiceInfoHistoryService;

public class AmsServiceInfoHistoryServiceImpl implements
		AmsServiceInfoHistoryService {

	@Inject
	private AmsServiceInfoHistoryDAO serviceInfoHistoryDAO;

	MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public AmsServiceInfoHistoryDAO getServiceInfoHistoryDAO() {
		return serviceInfoHistoryDAO;
	}

	public void setServiceInfoHistoryDAO(
			AmsServiceInfoHistoryDAO serviceInfoHistoryDAO) {
		this.serviceInfoHistoryDAO = serviceInfoHistoryDAO;
	}

	@Override
	public List<AssetWorkflow> getAssets() {
		
		return serviceInfoHistoryDAO.getAssets();
	}

	@Override
	public List<Asset> getHistoryById(Integer assetId) {

		return serviceInfoHistoryDAO.getHistoryById(assetId);
	}

	@Override
	public List<ServiceInfo> getServiceinfoHistory(int assetId) {
		
		return serviceInfoHistoryDAO.getServiceinfoHistory(assetId);
	}

	@Override
	public List<ServiceInfo> getServiceinfoHistory() {
	
		return serviceInfoHistoryDAO.getServiceinfoHistory();
	}

	@Override
	public List<AssetWorkflow> searchAsset(String assetNumber) {
	
		return serviceInfoHistoryDAO.searchAsset(assetNumber);
	}

}
