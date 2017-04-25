package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.ReplicationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.service.ReplicationService;

@Transactional
public class ReplicationServiceImpl implements ReplicationService {
	@Inject
	@Named(value = "messageSource")
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Inject
	private ReplicationDAO replicationDAO;

	public ReplicationDAO getReplicationDAO() {
		return replicationDAO;
	}

	public void setReplicationDAO(ReplicationDAO replicationDAO) {
		this.replicationDAO = replicationDAO;
	}

	@Override
	public List<Asset> getAllAssetDetails() {
		//System.out.println(replicationDAO + " Replication Dao");
		List<Asset> assetList = replicationDAO.getAllAssetDetails();
		return assetList;
	}

	@Override
	public Integer saveAssetReplication(String assetNumber,
			Integer numberOfReplication) {
		Integer value = replicationDAO.saveAssetReplication(assetNumber,
				numberOfReplication);
		return value;
	}

	@Override
	public Asset getSelectedAssetDetaills(String assetNumber) {
		Asset asset = replicationDAO.getSelectedAssetDetaills(assetNumber);
		return asset;
	}

	@Override
	public Asset getAssetDetailsToSave(String assetNumber) {
		Asset asset = replicationDAO.getAssetDetailsToSave(assetNumber);
		return asset;
	}
}
