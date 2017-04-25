package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.experion.ams.dao.TransferHistDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.service.TransferHistService;

public class TransferHistServiceImpl implements TransferHistService {

	@Inject
	@Named(value = "transferHistDAO")
	private TransferHistDAO transferHistDAO;
	
	public TransferHistDAO getTransferHistDAO() {
		return transferHistDAO;
	}

	public void setTransferHistDAO(TransferHistDAO transferHistDAO) {
		this.transferHistDAO = transferHistDAO;
	}

	@Override
	public List<Asset> getAllAvailAssets() {
		List<Asset> assetList = transferHistDAO.getAllAvailAssets();
		return assetList;
	}

	@Override
	public List<AssetTransfer> getAllTranHistAssets(int assetId) {
		List<AssetTransfer> assetTranList = transferHistDAO.getAllTranHistAssets(assetId);
		return assetTranList;
	}

}
