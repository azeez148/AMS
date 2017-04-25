package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.vo.AssetFormVO;

public interface AssetService {

	public List<Asset> getAllAssetDetails();

	public List<SystemParametersCodeMaster> getAllCodeValuesByType(String type);

	public List<AssetGroup> getAllGroupDetails();

	public List<Employee> getAllCustodianDetails();

	public boolean addAsset(AssetFormVO assetFormVO);

	public Asset getAssetsById(int assetId);

	public boolean editAsset(AssetFormVO assetFormVO);

	public int getCurrentlyAtId();

	public List<Asset> getAllAssetDetailsBycomId(Employee custodianId);

	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode);

	public List<Asset> getAllAssetDetailsforSearch(
			SystemParametersCodeMaster projectCode, Employee custodianId);

	public List<Asset> getAllAssetDetailsByLocation(
			SystemParametersCodeMaster locationCode);

	public List<Asset> getAllAssetDetailsforLocation(
			Employee custodianId,
			SystemParametersCodeMaster locationCode);

	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode);

	public List<Asset> getAllAssetDetailsforLocation(
			SystemParametersCodeMaster projectCode, Employee custodianId,
			SystemParametersCodeMaster locationCode);

	public List<Asset> getAllAssetDetailsByDepartment(
			SystemParametersCodeMaster deptCode);

	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode);

	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode);

	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode);

	public List<Asset> getSearchResults(String assetNumber,
			Employee custodianId, AssetGroup groupCode,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster locationCode,
			SystemParametersCodeMaster projectCode);

	public List<SystemParametersCodeMaster> getProjectIdByName(String comProject);

	public long getEmpIdByCode(long employeeCode);

	public Boolean checkAsset(String assetNumber);

	public ServiceInfo getServiceInfoByAsset(int assetId);

	
}
