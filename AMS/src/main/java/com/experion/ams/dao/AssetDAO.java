package com.experion.ams.dao;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

public interface AssetDAO {

	List<Asset> getAllAssetDetails();

	List<SystemParametersCodeMaster> getAllCodeValuesByType(String type);

	List<AssetGroup> getAllGroupDetails();

	List<Employee> getAllCustodianDetails();


	boolean addAsset(Asset asset,AssetTransfer assetTransfer, ServiceInfo serviceInfo);
	Asset getAssetsById(int assetId);

	boolean editAsset(Asset asset, AssetTransfer assetTransfer, ServiceInfo serviceInfo);

	int getCurrentlyAtId();

	List<Asset> getAllAssetDetailsBycomId(Employee custodianId);

	List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode);

	List<Asset> getAllAssetDetailsforSearch(
			SystemParametersCodeMaster projectCode, Employee custodianId);

	List<Asset> getAllAssetDetailsByLocation(
			SystemParametersCodeMaster locationCode);

	List<Asset> getAllAssetDetailsforLocation(
			Employee custodianId,
			SystemParametersCodeMaster locationCode);

	List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode);

	List<Asset> getAllAssetDetailsforLocation(
			SystemParametersCodeMaster projectCode, Employee custodianId,
			SystemParametersCodeMaster locationCode);

	List<Asset> getAllAssetDetailsByDepartment(
			SystemParametersCodeMaster deptCode);

	List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode);

	List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode);

	List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode);

	List<Asset> getSearchResults(String assetNumber, Employee custodianId,
			AssetGroup groupCode, SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster locationCode,
			SystemParametersCodeMaster projectCode);

	List<SystemParametersCodeMaster> getProjectIdByName(String comProject);

	long getEmpIdByCode(long employeeCode);

	Boolean checkAsset(String assetNumber);

	ServiceInfo getServiceInfoByAsset(int assetId);

}
