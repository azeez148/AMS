package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

public interface AssetTransferService {

	public List<Employee> getCustodians();

	public PurchaseInfo getAsset(int assetId);


	public List<SystemParametersCodeMaster> getSystemParameters(String condition);

	

	public void save(AssetTransfer assetTransfer);

	public void save(Asset asset);

	public SystemParametersCodeMaster getSystemPrameter(Integer deptTo);

	public Employee getEmployee(Long custTo);

	public void save(AssetDisposal assetDisposal);

	public void save(AssetRevalue assetRevalue);

	public List<AssetWorkflow> getAllAvailAssets();

	public List<AssetWorkflow> getAssetByNumber(String assetNumber);

	public Employee getEmployeeByCode(long employeeCode);

}
