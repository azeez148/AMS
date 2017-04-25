package com.experion.ams.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "ams_asset_transfer")
public class AssetTransfer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transfer_id")
	private Integer transferId;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "transfer_asset_code", nullable = false)
	private Asset transferAssetCode;

	@Column(name = "transfer_type")
	private String transferType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transfer_location_code", nullable = true, insertable = false, updatable = false)
	private SystemParametersCodeMaster transferLocationCode;

	@Column(name = "transfer_location_code")
	private Integer transferLocId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transfer_dept_code", nullable = true, insertable = false, updatable = false)
	private SystemParametersCodeMaster transferDeptCode;

	@Column(name = "transfer_dept_code")
	private Integer transferDeptId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transfer_project_code", nullable = true)
	private SystemParametersCodeMaster transferProjectCode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transfer_custodian_code", nullable = true, insertable = false, updatable = false)
	private Employee transferCustodianCode;

	@Column(name = "transfer_custodian_code")
	private Long transferCustId;

	@Column(name = "transfer_transferred_on")
	private Date transferTransferredOn;

	@Column(name = "transfer_transferred_upto")
	private Date transferTransferredUpto;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "transfer_created_by", insertable = false, updatable = false)
	private Employee transferCreatedBy;
	
	@Column(name = "transfer_created_by")
	private long transferCreatedById;

	public AssetTransfer() {
		super();
	}

	public Integer getTransferId() {
		return transferId;
	}

	public void setTransferId(Integer transferId) {
		this.transferId = transferId;
	}

	public Asset getTransferAssetCode() {
		return transferAssetCode;
	}

	public void setTransferAssetCode(Asset transferAssetCode) {
		this.transferAssetCode = transferAssetCode;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public SystemParametersCodeMaster getTransferLocationCode() {
		return transferLocationCode;
	}

	public void setTransferLocationCode(
			SystemParametersCodeMaster transferLocationCode) {
		this.transferLocationCode = transferLocationCode;
	}

	public SystemParametersCodeMaster getTransferDeptCode() {
		return transferDeptCode;
	}

	public void setTransferDeptCode(SystemParametersCodeMaster transferDeptCode) {
		this.transferDeptCode = transferDeptCode;
	}

	public Integer getTransferDeptId() {
		return transferDeptId;
	}

	public void setTransferDeptId(Integer transferDeptId) {
		this.transferDeptId = transferDeptId;
	}

	public SystemParametersCodeMaster getTransferProjectCode() {
		return transferProjectCode;
	}

	public void setTransferProjectCode(
			SystemParametersCodeMaster transferProjectCode) {
		this.transferProjectCode = transferProjectCode;
	}

	public Employee getTransferCustodianCode() {
		return transferCustodianCode;
	}

	public void setTransferCustodianCode(Employee transferCustodianCode) {
		this.transferCustodianCode = transferCustodianCode;
	}

	public Long getTransferCustId() {
		return transferCustId;
	}

	public void setTransferCustId(Long transferCustId) {
		this.transferCustId = transferCustId;
	}

	public Date getTransferTransferredOn() {
		return transferTransferredOn;
	}

	public void setTransferTransferredOn(Date transferTransferredOn) {
		this.transferTransferredOn = transferTransferredOn;
	}

	public Date getTransferTransferredUpto() {
		return transferTransferredUpto;
	}

	public void setTransferTransferredUpto(Date transferTransferredUpto) {
		this.transferTransferredUpto = transferTransferredUpto;
	}

	public Integer getTransferLocId() {
		return transferLocId;
	}

	public void setTransferLocId(Integer transferLocId) {
		this.transferLocId = transferLocId;
	}

	public Employee getTransferCreatedBy() {
		return transferCreatedBy;
	}

	public void setTransferCreatedBy(Employee transferCreatedBy) {
		this.transferCreatedBy = transferCreatedBy;
	}

	public long getTransferCreatedById() {
		return transferCreatedById;
	}

	public void setTransferCreatedById(long transferCreatedById) {
		this.transferCreatedById = transferCreatedById;
	}

}
