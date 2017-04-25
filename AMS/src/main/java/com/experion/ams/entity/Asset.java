package com.experion.ams.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Asset
 *
 */
@Entity
@Table(name = "ams_asset")
public class Asset implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(strategy="identity", name = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private Integer assetId;

	@Column(name = "asset_number")
	private String assetNumber;

	@ManyToOne
	@JoinColumn(name = "asset_make")
	private SystemParametersCodeMaster assetMake;

	@Column(name = "asset_model")
	private String assetModel;

	@Column(name = "asset_model_number")
	private String assetModelNumber;

	@Column(name = "asset_serial_number")
	private String assetSerialNumber;

	@Column(name = "asset_description")
	private String assetDescription;

	@Column(name = "asset_notes")
	private String assetNotes;

	@ManyToOne
	@JoinColumn(name = "asset_group_code", nullable = false)
	private AssetGroup assetGroupCode;

	@ManyToOne
	@JoinColumn(name = "asset_type")
	private SystemParametersCodeMaster assetType;

	@ManyToOne
	@JoinColumn(name = "asset_condition")
	private SystemParametersCodeMaster assetCondition;

	@ManyToOne
	@JoinColumn(name = "asset_currently_at")
	private SystemParametersCodeMaster assetCurrentlyAt;

	@ManyToOne
	@JoinColumn(name = "asset_location_code",insertable=false,updatable=false)
	private SystemParametersCodeMaster assetLocationCode;

	@Column(name = "asset_location_code")
	private Integer assetLocCode;

	@Column(name = "asset_dept_code")
	private Integer assetDeptCodeInt;

	@Column(name = "asset_project_code")
	private Integer assetProjectCodeInt;
	
	@Column(name = "asset_custodian_code")
	private Long assetCustId;

	@ManyToOne
	@JoinColumn(name = "asset_dept_code",insertable=false,updatable=false)
	private SystemParametersCodeMaster assetDeptCode;

	@ManyToOne
	@JoinColumn(name = "asset_project_code",insertable=false,updatable=false)
	private SystemParametersCodeMaster assetProjectCode;

	@ManyToOne
	@JoinColumn(name = "asset_custodian_code",insertable=false,updatable=false)
	private Employee assetCustodianCode;

	@Column(name = "asset_purchase_req_name")
	private String assetPurchaseReqName;

	@Column(name = "asset_purchase_req_number")
	private String assetPurchaseReqNumber;

	@Column(name = "asset_purchase_req_date")
	private Date assetPurchaseReqDate;

	@Column(name = "asset_capitalization_date")
	private Date assetCapitalizationDate;

	@Column(name = "asset_created_by")
	private long assetCreatedBy;
	
	@Column(name = "asset_created_date")
	private Date assetCreatedDate;
	
	@Column(name = "asset_updated_by")
	private long assetUpdatedBy;
	
	@Column(name = "asset_updated_date")
	private Date assetUpdatedDate;

	@Column(name = "asset_status")
	private String assetStatus;

	@Column(name = "asset_associated_id")
	private Integer associatedAssetId;

	@Column(name = "asset_image_name")
	private String fileName;

	@Column(name = "asset_warranty_period")
	private String assetWarrantyPeriod;

	@Column(name = "asset_warranty_end_date")
	private Date assetWarrantyEndDate;

	@JsonBackReference
	@OneToMany(mappedBy = "siAssetCode",fetch=FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ServiceInfo> serviceInfo;

	@JsonBackReference
	@OneToOne(mappedBy = "assetDispAssetCode", fetch = FetchType.LAZY)
	private AssetDisposal assetDisposal;

	@JsonBackReference
	@OneToOne(mappedBy = "revAssetCode", fetch = FetchType.LAZY)
	private AssetRevalue assetRevalue;

	@JsonBackReference
	@OneToOne(mappedBy = "workflowAssetCode", fetch = FetchType.LAZY)
	private AssetWorkflow assetWorkflow;

	@JsonBackReference
	@OneToMany(mappedBy = "transferAssetCode", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AssetTransfer> assetTransfer;
	 
	/* @OneToMany(mappedBy = "transferLocCode")  
		@LazyCollection(LazyCollectionOption.FALSE)
		private List<AssetTransfer> assetTransferloc;
	 @OneToMany(mappedBy = "transferDepartmentCode")  
		@LazyCollection(LazyCollectionOption.FALSE)
		private List<AssetTransfer> assetTransferdept;
	 @OneToMany(mappedBy = "transferCustCode")  
		@LazyCollection(LazyCollectionOption.FALSE)
		private List<AssetTransfer> assetTransfercusto;*/

	/*@OneToOne(mappedBy = "asset", cascade = CascadeType.ALL)
	private PurchaseInfo purchaseinfo;*/

	
	@JsonBackReference
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="physicalverificationAsset")
	private List<PhysicalVerification> physicalverification;

	public List<PhysicalVerification> getPhysicalverification() {
		return physicalverification;
	}

	public void setPhysicalverification(
			List<PhysicalVerification> physicalverification) {
		this.physicalverification = physicalverification;
	}

	@JsonBackReference
	@OneToOne(mappedBy = "asset", cascade = CascadeType.ALL)
	private PurchaseInfo purchaseinfo;

	@JsonBackReference
	@OneToMany(mappedBy = "asset")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<AssetDepreciation> assetDepreciation;

	@Transient
	private String date;

	@Transient
	private String comValueDpt;

	@Transient
	private String comValuePrj;

	public Asset() {
		super();
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public SystemParametersCodeMaster getAssetMake() {
		return assetMake;
	}

	public void setAssetMake(SystemParametersCodeMaster assetMake) {
		this.assetMake = assetMake;
	}

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

	/*public Integer getAssetDeptCodeInt() {
		return assetDeptCodeInt;
	}

	public void setAssetDeptCode(Integer assetDeptCodeInt) {
		this.assetDeptCodeInt = assetDeptCodeInt;
	}

	public Integer getAssetProjectCodeInt() {
		return assetProjectCodeInt;
	}

	public void setAssetProjectCodeInt(Integer assetProjectCodeInt) {
		this.assetProjectCodeInt = assetProjectCodeInt;
	}*/

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

	public Date getAssetPurchaseReqDate() {
		return assetPurchaseReqDate;
	}

	public void setAssetPurchaseReqDate(Date assetPurchaseReqDate) {
		this.assetPurchaseReqDate = assetPurchaseReqDate;
	}

	public Date getAssetCapitalizationDate() {
		return assetCapitalizationDate;
	}

	public void setAssetCapitalizationDate(Date assetCapitalizationDate) {
		this.assetCapitalizationDate = assetCapitalizationDate;
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

	public List<ServiceInfo> getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(List<ServiceInfo> serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public AssetDisposal getAssetDisposal() {
		return assetDisposal;
	}

	public void setAssetDisposal(AssetDisposal assetDisposal) {
		this.assetDisposal = assetDisposal;
	}

	public AssetRevalue getAssetRevalue() {
		return assetRevalue;
	}

	public void setAssetRevalue(AssetRevalue assetRevalue) {
		this.assetRevalue = assetRevalue;
	}

	public AssetWorkflow getAssetWorkflow() {
		return assetWorkflow;
	}

	public void setAssetWorkflow(AssetWorkflow assetWorkflow) {
		this.assetWorkflow = assetWorkflow;
	}

	public List<AssetTransfer> getAssetTransfer() {
		return assetTransfer;
	}

	public void setAssetTransfer(List<AssetTransfer> assetTransfer) {
		this.assetTransfer = assetTransfer;
	}

	public PurchaseInfo getPurchaseinfo() {
		return purchaseinfo;
	}

	public void setPurchaseinfo(PurchaseInfo purchaseinfo) {
		this.purchaseinfo = purchaseinfo;
	}

	public String getComValueDpt() {
		return comValueDpt;
	}

	public void setComValueDpt(String comValueDpt) {
		this.comValueDpt = comValueDpt;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComValuePrj() {
		return comValuePrj;
	}

	public void setComValuePrj(String comValuePrj) {
		this.comValuePrj = comValuePrj;
	}

	public Integer getAssociatedAssetId() {
		return associatedAssetId;
	}

	public void setAssociatedAssetId(Integer associatedAssetId) {
		this.associatedAssetId = associatedAssetId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getAssetWarrantyPeriod() {
		return assetWarrantyPeriod;
	}

	public void setAssetWarrantyPeriod(String assetWarrantyPeriod) {
		this.assetWarrantyPeriod = assetWarrantyPeriod;
	}

	public Date getAssetWarrantyEndDate() {
		return assetWarrantyEndDate;
	}

	public void setAssetWarrantyEndDate(Date assetWarrantyEndDate) {
		this.assetWarrantyEndDate = assetWarrantyEndDate;
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

	public List<AssetDepreciation> getAssetDepreciation() {
		return assetDepreciation;
	}

	public void setAssetDepreciation(List<AssetDepreciation> assetDepreciation) {
		this.assetDepreciation = assetDepreciation;
	}

	/*public List<AssetTransfer> getAssetTransferloc() {
		return assetTransferloc;
	}

	public void setAssetTransferloc(List<AssetTransfer> assetTransferloc) {
		this.assetTransferloc = assetTransferloc;
	}

	public List<AssetTransfer> getAssetTransferdept() {
		return assetTransferdept;
	}

	public void setAssetTransferdept(List<AssetTransfer> assetTransferdept) {
		this.assetTransferdept = assetTransferdept;
	}

	public List<AssetTransfer> getAssetTransfercusto() {
		return assetTransfercusto;
	}

	public void setAssetTransfercusto(List<AssetTransfer> assetTransfercusto) {
		this.assetTransfercusto = assetTransfercusto;
	}*/
}