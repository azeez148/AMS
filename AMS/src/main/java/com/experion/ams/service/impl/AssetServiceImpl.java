package com.experion.ams.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.AssetDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.vo.AssetFormVO;
import com.experion.ams.service.AssetService;

public class AssetServiceImpl implements AssetService {

	private AssetDAO assetDAO;

	public AssetDAO getAssetDAO() {
		return assetDAO;
	}

	public void setAssetDAO(AssetDAO assetDAO) {
		this.assetDAO = assetDAO;
	}

	@Override
	public List<Asset> getAllAssetDetails() {
		return assetDAO.getAllAssetDetails();
	}

	@Override
	public List<SystemParametersCodeMaster> getAllCodeValuesByType(String type) {
		return assetDAO.getAllCodeValuesByType(type);
	}

	@Override
	public List<AssetGroup> getAllGroupDetails() {
		return assetDAO.getAllGroupDetails();
	}

	@Override
	public List<Employee> getAllCustodianDetails() {
		return assetDAO.getAllCustodianDetails();
	}

	@Override
	public boolean addAsset(AssetFormVO assetFormVO) {
		Asset asset = new Asset();
		asset.setAssetNumber(assetFormVO.getAssetNumber());
		asset.setAssetDescription(assetFormVO.getAssetDescription());
		asset.setAssociatedAssetId(assetFormVO.getAssociatedAssetId());
		asset.setAssetModel(assetFormVO.getAssetModel());
		asset.setAssetModelNumber(assetFormVO.getAssetModelNumber());
		asset.setAssetNotes(assetFormVO.getAssetNotes());
		asset.setAssetPurchaseReqName(assetFormVO.getAssetPurchaseReqName());
		asset.setAssetPurchaseReqNumber(assetFormVO.getAssetPurchaseReqNumber());
		asset.setAssetPurchaseReqDate(assetFormVO.getAssetPurchaseReqDate());
		asset.setAssetSerialNumber(assetFormVO.getAssetSerialNumber());
		asset.setAssetStatus(assetFormVO.getAssetStatus());
		asset.setAssetWarrantyPeriod(assetFormVO.getAssetWarrantyPeriod());
		asset.setAssetWarrantyEndDate(assetFormVO.getAssetWarrantyEndDate());
		asset.setFileName(assetFormVO.getFilename());

		asset.setAssetMake(assetFormVO.getAssetMake());
		asset.setAssetGroupCode(assetFormVO.getAssetGroupCode());
		asset.setAssetCondition(assetFormVO.getAssetCondition());
		asset.setAssetCurrentlyAt(assetFormVO.getAssetCurrentlyAt());
		
		asset.setAssetCustId(assetFormVO.getAssetCustId());
		asset.setAssetDeptCodeInt(assetFormVO.getAssetDeptCodeInt());
		asset.setAssetLocCode(assetFormVO.getAssetLocCode());
		asset.setAssetProjectCodeInt(assetFormVO.getAssetProjectCodeInt());
		asset.setAssetType(assetFormVO.getAssetType());

		asset.setAssetCreatedBy(assetFormVO.getAssetCreatedBy());
		asset.setAssetCreatedDate(assetFormVO.getAssetCreatedDate());
		asset.setAssetUpdatedBy(assetFormVO.getAssetUpdatedBy());
		asset.setAssetUpdatedDate(assetFormVO.getAssetUpdatedDate());

		
		AssetTransfer assetTransfer = new AssetTransfer();
/*
		assetTransfer.setTransferCustodianCode(assetFormVO
				.getAssetCustodianCode());
		assetTransfer.setTransferDeptCode(assetFormVO.getAssetDeptCode());
		assetTransfer.setTransferLocationCode(assetFormVO
				.getAssetLocationCode());*/

		assetTransfer.setTransferAssetCode(asset);
		
		assetTransfer.setTransferCustId(assetFormVO.getAssetCustId());
		assetTransfer.setTransferDeptId(assetFormVO.getAssetDeptCodeInt());
		assetTransfer.setTransferLocId(assetFormVO.getAssetLocCode());

		assetTransfer.setTransferTransferredOn(new Date());
		assetTransfer.setTransferCreatedById(assetFormVO.getAssetCreatedBy());
//		assetTransfer.setTransferTransferredOn(assetFormVO.getAssetCreatedDate());
		
		
		ServiceInfo serviceInfo=new ServiceInfo();
		serviceInfo.setSiAssetCode(asset);
		serviceInfo.setSiwarrantyEndDate(assetFormVO.getAssetWarrantyEndDate());
		serviceInfo.setSiWarrantPeriod(Integer.parseInt(assetFormVO.getAssetWarrantyPeriod()));
		
		
		return assetDAO.addAsset(asset,assetTransfer,serviceInfo);
	}

	@Override
	public Asset getAssetsById(int assetId) {
		return assetDAO.getAssetsById(assetId);
	}

	@Override
	@Transactional
	public boolean editAsset(AssetFormVO assetFormVO) {
		Asset asset = new Asset();

		
		
		asset.setAssetId(assetFormVO.getAssetID());
		asset.setAssetNumber(assetFormVO.getAssetNumber());
		asset.setAssetDescription(assetFormVO.getAssetDescription());
		asset.setAssociatedAssetId(assetFormVO.getAssociatedAssetId());
		asset.setAssetModel(assetFormVO.getAssetModel());
		asset.setAssetModelNumber(assetFormVO.getAssetModelNumber());
		asset.setAssetNotes(assetFormVO.getAssetNotes());
		asset.setAssetPurchaseReqName(assetFormVO.getAssetPurchaseReqName());
		asset.setAssetPurchaseReqNumber(assetFormVO.getAssetPurchaseReqNumber());
		asset.setAssetPurchaseReqDate(assetFormVO.getAssetPurchaseReqDate());
		asset.setAssetSerialNumber(assetFormVO.getAssetSerialNumber());
		asset.setAssetStatus(assetFormVO.getAssetStatus());
		asset.setAssetWarrantyPeriod(assetFormVO.getAssetWarrantyPeriod());
		asset.setAssetWarrantyEndDate(assetFormVO.getAssetWarrantyEndDate());
		asset.setFileName(assetFormVO.getFilename());

		asset.setAssetMake(assetFormVO.getAssetMake());
		asset.setAssetType(assetFormVO.getAssetType());
		asset.setAssetGroupCode(assetFormVO.getAssetGroupCode());
		asset.setAssetCondition(assetFormVO.getAssetCondition());
		asset.setAssetCurrentlyAt(assetFormVO.getAssetCurrentlyAt());
		
		asset.setAssetCustId(assetFormVO.getAssetCustId());
		asset.setAssetDeptCodeInt(assetFormVO.getAssetDeptCodeInt());
		asset.setAssetLocCode(assetFormVO.getAssetLocCode());
		asset.setAssetProjectCodeInt(assetFormVO.getAssetProjectCodeInt());

		asset.setAssetCreatedBy(assetFormVO.getAssetCreatedBy());
		asset.setAssetCreatedDate(assetFormVO.getAssetCreatedDate());
		asset.setAssetUpdatedBy(assetFormVO.getAssetUpdatedBy());
		asset.setAssetUpdatedDate(assetFormVO.getAssetUpdatedDate());

		
		AssetTransfer assetTransfer = new AssetTransfer();
		/*
				assetTransfer.setTransferCustodianCode(assetFormVO
						.getAssetCustodianCode());
				assetTransfer.setTransferDeptCode(assetFormVO.getAssetDeptCode());
				assetTransfer.setTransferLocationCode(assetFormVO
						.getAssetLocationCode());*/

				assetTransfer.setTransferAssetCode(asset);
				
				assetTransfer.setTransferCustId(assetFormVO.getAssetCustId());
				assetTransfer.setTransferDeptId(assetFormVO.getAssetDeptCodeInt());
				assetTransfer.setTransferLocId(assetFormVO.getAssetLocCode());

				assetTransfer.setTransferTransferredOn(new Date());
				assetTransfer.setTransferCreatedById(assetFormVO.getAssetCreatedBy());
		
				ServiceInfo serviceInfo=new ServiceInfo();
				serviceInfo.setSiAssetCode(asset);
				//serviceInfo.setSiId(asset.getServiceInfo().get(0).getSiId());
				serviceInfo.setSiwarrantyEndDate(assetFormVO.getAssetWarrantyEndDate());
				serviceInfo.setSiWarrantPeriod(Integer.parseInt(assetFormVO.getAssetWarrantyPeriod()));
		
		
		return assetDAO.editAsset(asset,assetTransfer,serviceInfo);
	}

	@Override
	public int getCurrentlyAtId() {
		//
		return assetDAO.getCurrentlyAtId();
	}

	@Override
	public List<Asset> getAllAssetDetailsBycomId(Employee custodianId) {
		// TODO Auto-generated method stub
		return assetDAO.getAllAssetDetailsBycomId(custodianId);
	}

	@Override
	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode) {
		return assetDAO.getAllAssetDetailsByProject(projectCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsforSearch(
			SystemParametersCodeMaster projectCode, Employee custodianId) {
		return assetDAO.getAllAssetDetailsforSearch(projectCode, custodianId);

	}

	@Override
	public List<Asset> getAllAssetDetailsByLocation(
			SystemParametersCodeMaster locationCode) {
		return assetDAO.getAllAssetDetailsByLocation(locationCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsforLocation(Employee custodianId,
			SystemParametersCodeMaster locationCode) {
		return assetDAO
				.getAllAssetDetailsforLocation(custodianId, locationCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsByProject(
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode) {
		return assetDAO.getAllAssetDetailsByProject(projectCode, locationCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsforLocation(
			SystemParametersCodeMaster projectCode, Employee custodianId,
			SystemParametersCodeMaster locationCode) {
		return assetDAO.getAllAssetDetailsforLocation(projectCode, custodianId,
				locationCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsByDepartment(
			SystemParametersCodeMaster deptCode) {
		return assetDAO.getAllAssetDetailsByDepartment(deptCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode) {
		return assetDAO.getAllAssetDetailsByDepartment(custodianId, deptCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode) {
		return assetDAO.getAllAssetDetailsByDepartment(custodianId, deptCode,
				projectCode);
	}

	@Override
	public List<Asset> getAllAssetDetailsByDepartment(Employee custodianId,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster projectCode,
			SystemParametersCodeMaster locationCode) {
		return assetDAO.getAllAssetDetailsByDepartment(custodianId, deptCode,
				projectCode, locationCode);
	}

	@Override
	public List<Asset> getSearchResults(String assetNumber,
			Employee custodianId, AssetGroup groupCode,
			SystemParametersCodeMaster deptCode,
			SystemParametersCodeMaster locationCode,
			SystemParametersCodeMaster projectCode) {
		return assetDAO.getSearchResults(assetNumber, custodianId, groupCode,
				deptCode, locationCode, projectCode);
	}

	@Override
	public List<SystemParametersCodeMaster> getProjectIdByName(String comProject) {
		return assetDAO.getProjectIdByName(comProject);
	}

	@Override
	public long getEmpIdByCode(long employeeCode) {
		return assetDAO.getEmpIdByCode(employeeCode);

	}

	@Override
	public Boolean checkAsset(String assetNumber) {
		return assetDAO.checkAsset(assetNumber);
	}

	@Override
	public ServiceInfo getServiceInfoByAsset(int assetId) {
		return assetDAO.getServiceInfoByAsset(assetId);
	}

}
