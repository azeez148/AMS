package com.experion.ams.mvc.data;

import java.io.Serializable;

public class AssetApproveForm implements Serializable {
	
	/**
	 * Libin Lougine L
	 */
	private static final long serialVersionUID = -169626869927070996L;
	
	private String assetNo;
	private String assetStatus;
	private String rejectReason;
	
	public String getAssetNo() {
		return assetNo;
	}
	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}
	public String getAssetStatus() {
		return assetStatus;
	}
	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
}