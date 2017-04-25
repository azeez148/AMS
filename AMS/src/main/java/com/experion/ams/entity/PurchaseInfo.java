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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name = "ams_purchase_info")
public class PurchaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pi_id")
	private Integer piId;

	@ManyToOne
	@JoinColumn(name = "pi_vendor_code")
	private SystemParametersCodeMaster piVender;

	@JsonManagedReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pi_asset_code")
	private Asset asset;


	@Column(name = "pi_invoice_date")
	private String invoiceDate;

	@Column(name = "pi_invoice_number")
	private String piInviceNo;

	@Column(name = "pi_purchase_cost")
	private Double piPurchasecost;
	
	@Column(name = "pi_delivery_date")
	private Date piDeliveryDate;

	@Column(name = "pi_capitalization_date")
	private String piCaptialDate;

	@Column(name = "pi_po_number")
	private String piPoNumber;

	@Column(name = "pi_po_date")
	private String pipoDate;

	@Column(name = "pi_created_by")
	private Long purchaseCreatedBy;

	@Column(name = "pi_created_date")
	private Date purchaseCreatedate;

	@Column(name = "pi_updated_by")
	private Long purchaseUpdateBy;

	@Column(name = "pi_updated_date")
	private Date purchaseUpdateDate;
	
	@Transient
	private String deliveryDate;
	
	@Transient
	private String assetNumber;

	public String getAssetNumber() {
		return assetNumber;
	}

	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public SystemParametersCodeMaster getPiVender() {
		return piVender;
	}

	public void setPiVender(SystemParametersCodeMaster piVender) {
		this.piVender = piVender;
	}

	public Double getPiPurchasecost() {
		return piPurchasecost;
	}

	public void setPiPurchasecost(Double piPurchasecost) {
		this.piPurchasecost = piPurchasecost;
	}

	public String getPiInviceNo() {
		return piInviceNo;
	}

	public void setPiInviceNo(String piInviceNo) {
		this.piInviceNo = piInviceNo;
	}

	public Integer getPiId() {
		return piId;
	}

	public void setPiId(Integer piId) {
		this.piId = piId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getPiDeliveryDate() {
		return piDeliveryDate;
	}

	public void setPiDeliveryDate(Date piDeliveryDate) {
		this.piDeliveryDate = piDeliveryDate;
	}

	public String getPiCaptialDate() {
		return piCaptialDate;
	}

	public void setPiCaptialDate(String piCaptialDate) {
		this.piCaptialDate = piCaptialDate;
	}

	public String getPiPoNumber() {
		return piPoNumber;
	}

	public void setPiPoNumber(String piPoNumber) {
		this.piPoNumber = piPoNumber;
	}

	public String getPipoDate() {
		return pipoDate;
	}

	public void setPipoDate(String pipoDate) {
		this.pipoDate = pipoDate;
	}

	public Long getPurchaseCreatedBy() {
		return purchaseCreatedBy;
	}

	public void setPurchaseCreatedBy(Long purchaseCreatedBy) {
		this.purchaseCreatedBy = purchaseCreatedBy;
	}

	public Date getPurchaseCreatedate() {
		return purchaseCreatedate;
	}

	public void setPurchaseCreatedate(Date currentDate) {
		this.purchaseCreatedate = currentDate;
	}

	public Long getPurchaseUpdateBy() {
		return purchaseUpdateBy;
	}

	public void setPurchaseUpdateBy(Long purchaseUpdateBy) {
		this.purchaseUpdateBy = purchaseUpdateBy;
	}

	public Date getPurchaseUpdateDate() {
		return purchaseUpdateDate;
	}

	public void setPurchaseUpdateDate(Date purchaseUpdateDate) {
		this.purchaseUpdateDate = purchaseUpdateDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
