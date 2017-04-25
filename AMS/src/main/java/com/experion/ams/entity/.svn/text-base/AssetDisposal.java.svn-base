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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="ams_asset_disposal")
public class AssetDisposal  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_disp_id")
	private Integer assetDispId;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "asset_disp_asset_code", nullable = false)
	private Asset assetDispAssetCode;
	
	@Column(name = "asset_disp_write_off_amount")
	private Float assetDispWriteOffAmount;
	
	@Column(name = "asset_disp_write_off_date")
	private Date assetDispWriteOffDate;
	
	public AssetDisposal() {
		super();
	}
	
	public Integer getAssetDispId() {
		return assetDispId;
	}

	public void setassetDispId(Integer assetDispId) {
		this.assetDispId = assetDispId;
	}
	
	public Asset getAssetDispAssetCode() {
		return assetDispAssetCode;
	}

	public void setAssetDispAssetCode(Asset assetDispAssetCode) {
		this.assetDispAssetCode = assetDispAssetCode;
	}
	
	public Float getAssetDispWriteOffAmount() {
		return assetDispWriteOffAmount;
	}

	public void setAssetDispWriteOffAmount(Float assetDispWriteOffAmount) {
		this.assetDispWriteOffAmount = assetDispWriteOffAmount;
	}
	public Date getAssetDispWriteOffDate() {
		return assetDispWriteOffDate;
	}

	public void setAssetDispWriteOffDate(Date assetDispWriteOffDate) {
		this.assetDispWriteOffDate = assetDispWriteOffDate;
	}
}
