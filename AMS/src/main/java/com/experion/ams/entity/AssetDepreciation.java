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
@Table(name="ams_asset_depreciation_map")
public class AssetDepreciation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "adm_id")
	private Integer depreciationId;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "adm_asset_code", nullable = false)
	private Asset asset;
	
	@Transient
	private String date;
	
	@Transient
	private int assetpagnId;
	
	public int getAssetpagnId() {
		return assetpagnId;
	}
	public void setAssetpagnId(int assetpagnId) {
		this.assetpagnId = assetpagnId;
	}
	@Transient
	private int pageNum;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPagecountHidden() {
		return pagecountHidden;
	}
	public void setPagecountHidden(int pagecountHidden) {
		this.pagecountHidden = pagecountHidden;
	}
	@Transient
	private int pagecountHidden;
	
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	@Transient
	private String fromdate;
	
	@Transient
	private String todate;
	

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Column(name = "adm_depr_from")  
    private Date depreciationFrom;
    
    public Integer getDepreciationId() {
		return depreciationId;
	}
	public void setDepreciationId(Integer depreciationId) {
		this.depreciationId = depreciationId;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	public Date getDepreciationFrom() {
		return depreciationFrom;
	}
	public void setDepreciationFrom(Date depreciationFrom) {
		this.depreciationFrom = depreciationFrom;
	}
	public Date getDepreciationTo() {
		return depreciationTo;
	}
	public void setDepreciationTo(Date depreciationTo) {
		this.depreciationTo = depreciationTo;
	}

	public String getDepreciationManual() {
		return depreciationManual;
	}
	public void setDepreciationManual(String depreciationManual) {
		this.depreciationManual = depreciationManual;
	}
	public Date getTransactionDate() {
		return TransactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		TransactionDate = transactionDate;
	}
	@Column(name = "adm_depr_to") 
    private Date depreciationTo;
    
    @Column(name = "adm_depr_bookvalue")
    private Double depreciationBookValue;
    
    @Column(name = "adm_depr_amount")
    private Double depreciationAmount;
    
    @Column(name = "adm_depr_accumulated_amount")
    private Double depreciationAccumulatedAmount;
    
    @Column(name = "adm_depr_days_aged")
    private Integer depreciationDaysAged;
    
    public Integer getDepreciationDaysAged() {
		return depreciationDaysAged;
	}
	public void setDepreciationDaysAged(Integer depreciationDaysAged) {
		this.depreciationDaysAged = depreciationDaysAged;
	}
	@Column(name = "adm_is_manual")
    private String depreciationManual;
    
  
	public Double getDepreciationBookValue() {
		return depreciationBookValue;
	}
	public void setDepreciationBookValue(Double depreciationBookValue) {
		this.depreciationBookValue = depreciationBookValue;
	}
	public Double getDepreciationAmount() {
		return depreciationAmount;
	}
	public void setDepreciationAmount(Double depreciationAmount) {
		this.depreciationAmount = depreciationAmount;
	}
	public Double getDepreciationAccumulatedAmount() {
		return depreciationAccumulatedAmount;
	}
	public void setDepreciationAccumulatedAmount(
			Double depreciationAccumulatedAmount) {
		this.depreciationAccumulatedAmount = depreciationAccumulatedAmount;
	}
	
	@Column(name = "adm_transaction_date")
    private Date TransactionDate;
}