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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "ams_physical_verification")
public class PhysicalVerification implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phys_ver_id")
	private Integer physId;
	
	public Integer getPhysId() {
		return physId;
	}

	public void setPhysId(Integer physId) {
		this.physId = physId;
	}

	public Asset getPhysicalverificationAsset() {
		return physicalverificationAsset;
	}

	public void setPhysicalverificationAsset(Asset physicalverificationAsset) {
		this.physicalverificationAsset = physicalverificationAsset;
	}

	public Date getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}



	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "phys_ver_asset_code", nullable = false)
	private Asset physicalverificationAsset;
	
	@Column(name = "phys_ver_verified_date")
	private Date verifiedDate;
	
	@Column(name = "phys_ver_last_verified_on")
	private Date lastDate;
	
	@Column(name = "phys_ver_verified")
	private String verified;
	
	@Column(name = "phys_ver_remarks")
	private String remarks;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "phys_ver_created_by", nullable = false)
	private Employee physicalverificationcreatedby;
	
	public Employee getPhysicalverificationcreatedby() {
		return physicalverificationcreatedby;
	}

	public void setPhysicalverificationcreatedby(
			Employee physicalverificationcreatedby) {
		this.physicalverificationcreatedby = physicalverificationcreatedby;
	}



	@Column(name = "phys_ver_created_date")
	private Date createddate;
	
	@Column(name = "phys_ver_updated_date")
	private Date updatedDate;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "phys_ver_updated_by", nullable = false)
	private Employee physicalverificationupdatedby;
	public Employee getPhysicalverificationupdatedby() {
		return physicalverificationupdatedby;
	}

	public void setPhysicalverificationupdatedby(
			Employee physicalverificationupdatedby) {
		this.physicalverificationupdatedby = physicalverificationupdatedby;
	}

	@Transient
	private String lastdatetrans;
	
	@Transient
	private String verifiedtrans;
	
	public String getVerifiedtrans() {
		return verifiedtrans;
	}

	public void setVerifiedtrans(String verifiedtrans) {
		this.verifiedtrans = verifiedtrans;
	}

	public String getLastdatetrans() {
		return lastdatetrans;
	}

	public void setLastdatetrans(String lastdatetrans) {
		this.lastdatetrans = lastdatetrans;
	}
	

}
