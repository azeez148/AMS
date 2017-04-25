package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.AssetTransferDAO;
import com.experion.ams.service.AssetTransferService;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
@Transactional
public class AssetTransferServiceImpl implements AssetTransferService {
	@Inject
	@Named(value="assetTransferDAO")
	private AssetTransferDAO assetTransferDAO;

	

	@Override
	public List<Employee> getCustodians() {
		// TODO Auto-generated method stub
		return assetTransferDAO.getCustodians();
	}
	
	@Override
	public PurchaseInfo getAsset(int assetId) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getAsset(assetId);
	}

	@Override
	public List<SystemParametersCodeMaster> getSystemParameters(String condition) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getSystemParameters(condition);
	}

	
	@Override
	public void save(AssetTransfer assetTransfer) {

		assetTransferDAO.save(assetTransfer);
		
	}

	@Override
	public void save(Asset asset) {
		assetTransferDAO.save(asset);
		
	}
	
	public AssetTransferDAO getAssetTransferDAO() {
		return assetTransferDAO;
	}

	public void setAssetTransferDAO(AssetTransferDAO assetTransferDAO) {
		this.assetTransferDAO = assetTransferDAO;
	}

	@Override
	public SystemParametersCodeMaster getSystemPrameter(Integer deptTo) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getSystemPrameter(deptTo);
	}

	@Override
	public Employee getEmployee(Long custTo) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getEmployee(custTo) ;
	}

	@Override
	public void save(AssetDisposal assetDisposal) {
		
		assetTransferDAO.save(assetDisposal);
		
	}

	@Override
	public void save(AssetRevalue assetRevalue) {
		assetTransferDAO.save(assetRevalue);
		
	}

	@Override
	public List<AssetWorkflow> getAllAvailAssets() {
		// TODO Auto-generated method stub
		return assetTransferDAO.getAllAvailAssets();
	}

	@Override
	public List<AssetWorkflow> getAssetByNumber(String assetNumber) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getAssetByNumber(assetNumber);
	}

	@Override
	public Employee getEmployeeByCode(long employeeCode) {
		// TODO Auto-generated method stub
		return assetTransferDAO.getEmployeeByCode(employeeCode);
	}

	

	

}
