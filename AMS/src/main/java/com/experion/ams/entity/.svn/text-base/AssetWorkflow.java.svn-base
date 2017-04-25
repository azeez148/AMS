package com.experion.ams.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="ams_asset_workflow")
public class AssetWorkflow implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "workflow_id")
	private Integer workflowId;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "workflow_asset_code", nullable = false)
	private Asset workflowAssetCode;
	
	@Column(name = "workflow_asset_status")
	private String workflowAssetStatus;
	
	@Column(name = "workflow_asset_type")
	private String workflowAssetType;
	
	@Column(name = "workflow_email_status")
	private String workflowEmailStatus;
	
	@Column(name = "workflow_manager_code")
	private String workflowManagerCode;
	
	@Column(name = "workflow_manager_reject_reason")
	private String workflowManagerRejectReason;

	
	public AssetWorkflow() {
		super();
	}
	
	public Integer getWorkflowIdId() {
		return workflowId;
	}

	public void setAssetId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	
	public Asset getWorkflowAssetCode() {
		return workflowAssetCode;
	}

	public void setWorkflowAssetCode(Asset workflowAssetCode) {
		this.workflowAssetCode = workflowAssetCode;
	}
	
	public String getWorkflowAssetStatus() {
		return workflowAssetStatus;
	}

	public void setWorkflowAssetStatus(String workflowAssetStatus) {
		this.workflowAssetStatus = workflowAssetStatus;
	}
	public String getWorkflowAssetType() {
		return workflowAssetType;
	}

	public void setWorkflowAssetType(String workflowAssetType) {
		this.workflowAssetType = workflowAssetType;
	}
	public String getWorkflowEmailStatus() {
		return workflowEmailStatus;
	}

	public void setWorkflowEmailStatus(String workflowEmailStatus) {
		this.workflowEmailStatus = workflowEmailStatus;
	}
	public String getWorkflowManagerCode() {
		return workflowManagerCode;
	}

	public void setWorkflowManagerCode(String workflowManagerCode) {
		this.workflowManagerCode = workflowManagerCode;
	}
	public String getWorkflowManagerRejectReason() {
		return workflowManagerRejectReason;
	}

	public void setWorkflowManagerRejectReason(String workflowManagerRejectReason) {
		this.workflowManagerRejectReason = workflowManagerRejectReason;
	}
}
