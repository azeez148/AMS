package com.experion.ams.mvc.data;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.SystemParametersCodeMaster;

public class AssetForm implements Serializable {

	/**
	 * Abdul Azeez 28-07-2015
	 */
	private static final long serialVersionUID = -169626869927070996L;

	private Integer assetID;
	@NotEmpty
	@NotNull
	private String assetNumber;

	private Integer associatedAssetId;

	
	private SystemParametersCodeMaster assetMake;
	@NotEmpty
	@NotNull
	private String assetModel;
	@NotEmpty
	@NotNull
	private String assetModelNumber;
	@NotEmpty
	@NotNull
	private String assetSerialNumber;
	@NotEmpty
	@NotNull
	private String assetDescription;

	private String assetNotes;
	
	private AssetGroup assetGroupCode;
	
	private SystemParametersCodeMaster assetType;
	
	private SystemParametersCodeMaster assetCondition;
	
	private SystemParametersCodeMaster assetCurrentlyAt;

	private SystemParametersCodeMaster assetLocationCode;

	private SystemParametersCodeMaster assetDeptCode;

	private SystemParametersCodeMaster assetProjectCode;
	
	private String filename;	
		
		private MultipartFile file;	
	
	private Employee assetCustodianCode;
	@NotEmpty
	@NotNull
	private String assetPurchaseReqName;
	@NotEmpty
	@NotNull
	private String assetPurchaseReqNumber;
	@NotEmpty
	@NotNull
	private String assetPurchaseReqDate;

	private Date assetCapitalizationDate;

	private Double assetBookValueCost;

	private long assetCreatedBy;

	private Date assetCreatedDate;

	private long assetUpdatedBy;

	private Date assetUpdatedDate;
	
	private Integer assetLocCode;

	private Integer assetDeptCodeInt;

	private Integer assetProjectCodeInt;
	
	private Long assetCustId;
	
	private String assetStatus;
	@NotEmpty
	@NotNull
	private String assetWarrantyPeriod;
	@NotEmpty
	@NotNull
	private String assetWarrantyEndDate;

	private String rejectReason;
	
	public Integer getAssetID() {
		return assetID;
	}

	public void setAssetID(Integer assetID) {
		this.assetID = assetID;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}
/*
	public String getAssetMake() {
		return assetMake;
	}

	public void setAssetMake(String assetMake) {
		this.assetMake = assetMake;
	}*/

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public String getAssetModelNumber() {
		return assetModelNumber;
	}

	public void setAssetModelNumber(String assetModelNumber) {
		this.assetModelNumber = assetModelNumber;
	}

	public String getAssetSerialNumber() {
		return assetSerialNumber;
	}

	public void setAssetSerialNumber(String assetSerialNumber) {
		this.assetSerialNumber = assetSerialNumber;
	}

	public String getAssetDescription() {
		return assetDescription;
	}

	public void setAssetDescription(String assetDescription) {
		this.assetDescription = assetDescription;
	}

	public String getAssetNotes() {
		return assetNotes;
	}

	public void setAssetNotes(String assetNotes) {
		this.assetNotes = assetNotes;
	}

	public AssetGroup getAssetGroupCode() {
		return assetGroupCode;
	}

	public void setAssetGroupCode(AssetGroup assetGroupCode) {
		this.assetGroupCode = assetGroupCode;
	}

	/*public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetCondition() {
		return assetCondition;
	}

	public void setAssetCondition(String assetCondition) {
		this.assetCondition = assetCondition;
	}

	public String getAssetCurrentlyAt() {
		return assetCurrentlyAt;
	}

	public void setAssetCurrentlyAt(String assetCurrentlyAt) {
		this.assetCurrentlyAt = assetCurrentlyAt;
	}

	public String getAssetLocationCode() {
		return assetLocationCode;
	}

	public void setAssetLocationCode(String assetLocationCode) {
		this.assetLocationCode = assetLocationCode;
	}

	public String getAssetDeptCode() {
		return assetDeptCode;
	}

	public void setAssetDeptCode(String assetDeptCode) {
		this.assetDeptCode = assetDeptCode;
	}

	public String getAssetProjectCode() {
		return assetProjectCode;
	}

	public void setAssetProjectCode(String assetProjectCode) {
		this.assetProjectCode = assetProjectCode;
	}
*/
	public Employee getAssetCustodianCode() {
		return assetCustodianCode;
	}

	public void setAssetCustodianCode(Employee assetCustodianCode) {
		this.assetCustodianCode = assetCustodianCode;
	}

	public String getAssetPurchaseReqName() {
		return assetPurchaseReqName;
	}

	public void setAssetPurchaseReqName(String assetPurchaseReqName) {
		this.assetPurchaseReqName = assetPurchaseReqName;
	}

	public String getAssetPurchaseReqNumber() {
		return assetPurchaseReqNumber;
	}

	public void setAssetPurchaseReqNumber(String assetPurchaseReqNumber) {
		this.assetPurchaseReqNumber = assetPurchaseReqNumber;
	}

	public String getAssetPurchaseReqDate() {
		return assetPurchaseReqDate;
	}

	public void setAssetPurchaseReqDate(String assetPurchaseReqDate) {
		this.assetPurchaseReqDate = assetPurchaseReqDate;
	}

	public Date getAssetCapitalizationDate() {
		return assetCapitalizationDate;
	}

	public void setAssetCapitalizationDate(Date assetCapitalizationDate) {
		this.assetCapitalizationDate = assetCapitalizationDate;
	}

	public Double getAssetBookValueCost() {
		return assetBookValueCost;
	}

	public void setAssetBookValueCost(Double assetBookValueCost) {
		this.assetBookValueCost = assetBookValueCost;
	}

	public long getAssetCreatedBy() {
		return assetCreatedBy;
	}

	public void setAssetCreatedBy(long assetCreatedBy) {
		this.assetCreatedBy = assetCreatedBy;
	}

	public Date getAssetCreatedDate() {
		return assetCreatedDate;
	}

	public void setAssetCreatedDate(Date assetCreatedDate) {
		this.assetCreatedDate = assetCreatedDate;
	}

	public long getAssetUpdatedBy() {
		return assetUpdatedBy;
	}

	public void setAssetUpdatedBy(long assetUpdatedBy) {
		this.assetUpdatedBy = assetUpdatedBy;
	}

	public Date getAssetUpdatedDate() {
		return assetUpdatedDate;
	}

	public void setAssetUpdatedDate(Date assetUpdatedDate) {
		this.assetUpdatedDate = assetUpdatedDate;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public SystemParametersCodeMaster getAssetMake() {
		return assetMake;
	}

	public void setAssetMake(SystemParametersCodeMaster assetMake) {
		this.assetMake = assetMake;
	}

	public SystemParametersCodeMaster getAssetType() {
		return assetType;
	}

	public void setAssetType(SystemParametersCodeMaster assetType) {
		this.assetType = assetType;
	}

	public SystemParametersCodeMaster getAssetCondition() {
		return assetCondition;
	}

	public void setAssetCondition(SystemParametersCodeMaster assetCondition) {
		this.assetCondition = assetCondition;
	}

	public SystemParametersCodeMaster getAssetCurrentlyAt() {
		return assetCurrentlyAt;
	}

	public void setAssetCurrentlyAt(SystemParametersCodeMaster assetCurrentlyAt) {
		this.assetCurrentlyAt = assetCurrentlyAt;
	}

	public SystemParametersCodeMaster getAssetLocationCode() {
		return assetLocationCode;
	}

	public void setAssetLocationCode(SystemParametersCodeMaster assetLocationCode) {
		this.assetLocationCode = assetLocationCode;
	}

	public SystemParametersCodeMaster getAssetDeptCode() {
		return assetDeptCode;
	}

	public void setAssetDeptCode(SystemParametersCodeMaster assetDeptCode) {
		this.assetDeptCode = assetDeptCode;
	}

	public SystemParametersCodeMaster getAssetProjectCode() {
		return assetProjectCode;
	}

	public void setAssetProjectCode(SystemParametersCodeMaster assetProjectCode) {
		this.assetProjectCode = assetProjectCode;
	}

	public Integer getAssociatedAssetId() {
		return associatedAssetId;
	}

	public void setAssociatedAssetId(Integer associatedAssetId) {
		this.associatedAssetId = associatedAssetId;
	}

	public String getAssetWarrantyPeriod() {
		return assetWarrantyPeriod;
	}

	public void setAssetWarrantyPeriod(String assetWarrantyPeriod) {
		this.assetWarrantyPeriod = assetWarrantyPeriod;
	}

	public String getAssetWarrantyEndDate() {
		return assetWarrantyEndDate;
	}

	public void setAssetWarrantyEndDate(String assetWarrantyEndDate) {
		this.assetWarrantyEndDate = assetWarrantyEndDate;
	}

	

	

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}
	
	public String getRejectReason(){
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Integer getAssetLocCode() {
		return assetLocCode;
	}

	public void setAssetLocCode(Integer assetLocCode) {
		this.assetLocCode = assetLocCode;
	}

	public Integer getAssetDeptCodeInt() {
		return assetDeptCodeInt;
	}

	public void setAssetDeptCodeInt(Integer assetDeptCodeInt) {
		this.assetDeptCodeInt = assetDeptCodeInt;
	}

	public Integer getAssetProjectCodeInt() {
		return assetProjectCodeInt;
	}

	public void setAssetProjectCodeInt(Integer assetProjectCodeInt) {
		this.assetProjectCodeInt = assetProjectCodeInt;
	}

	public Long getAssetCustId() {
		return assetCustId;
	}

	public void setAssetCustId(Long assetCustId) {
		this.assetCustId = assetCustId;
	}

	@Override
	public String toString() {
		return "AssetForm [assetID=" + assetID + ", assetNumber=" + assetNumber
				+ ", associatedAssetId=" + associatedAssetId + ", assetMake="
				+ assetMake + ", assetModel=" + assetModel
				+ ", assetModelNumber=" + assetModelNumber
				+ ", assetSerialNumber=" + assetSerialNumber
				+ ", assetDescription=" + assetDescription + ", assetNotes="
				+ assetNotes + ", assetGroupCode=" + assetGroupCode
				+ ", assetType=" + assetType + ", assetCondition="
				+ assetCondition + ", assetCurrentlyAt=" + assetCurrentlyAt
				+ ", assetLocationCode=" + assetLocationCode
				+ ", assetDeptCode=" + assetDeptCode + ", assetProjectCode="
				+ assetProjectCode + ", filename=" + filename + ", file="
				+ file + ", assetCustodianCode=" + assetCustodianCode
				+ ", assetPurchaseReqName=" + assetPurchaseReqName
				+ ", assetPurchaseReqNumber=" + assetPurchaseReqNumber
				+ ", assetPurchaseReqDate=" + assetPurchaseReqDate
				+ ", assetCapitalizationDate=" + assetCapitalizationDate
				+ ", assetBookValueCost=" + assetBookValueCost
				+ ", assetCreatedBy=" + assetCreatedBy + ", assetCreatedDate="
				+ assetCreatedDate + ", assetUpdatedBy=" + assetUpdatedBy
				+ ", assetUpdatedDate=" + assetUpdatedDate + ", assetLocCode="
				+ assetLocCode + ", assetDeptCodeInt=" + assetDeptCodeInt
				+ ", assetProjectCodeInt=" + assetProjectCodeInt
				+ ", assetCustId=" + assetCustId + ", assetStatus="
				+ assetStatus + ", assetWarrantyPeriod=" + assetWarrantyPeriod
				+ ", assetWarrantyEndDate=" + assetWarrantyEndDate
				+ ", rejectReason=" + rejectReason + "]";
	}

}