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
@Table(name="ams_asset_revalue")
public class AssetRevalue  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rev_id")
	private Integer revId;
	
	@JsonManagedReference
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rev_asset_code", nullable = false)
	private Asset revAssetCode;
	
	@Column(name = "rev_revalue_amount")
	private Double revRevalueAmount;
	
	@Column(name = "rev_revalue_date")
	private Date revRevalueDate;
	
	public AssetRevalue() {
		super();
	}
	
	public Integer getRevId() {
		return revId;
	}

	public void setRevId(Integer revId) {
		this.revId = revId;
	}
	
	public Asset getRevAssetCode() {
		return revAssetCode;
	}

	public void setRevAssetCode(Asset revAssetCode) {
		this.revAssetCode = revAssetCode;
	}
	
	public Double getRevRevalueAmount() {
		return revRevalueAmount;
	}

	public void setRevRevalueAmount(Double revRevalueAmount) {
		this.revRevalueAmount = revRevalueAmount;
	}
	public Date getRevRevalueDate() {
		return revRevalueDate;
	}

	public void setRevRevalueDate(Date revRevalueDate) {
		this.revRevalueDate = revRevalueDate;
	}
}
