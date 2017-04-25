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

/**
 * Entity implementation class for Entity: Asset
 *
 */
@Entity
@Table(name = "ams_service_info")
public class ServiceInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "si_id")
	private Integer siId;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "si_asset_code", nullable = false)
	private Asset siAssetCode;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "si_service_provider_code", nullable = false, insertable = false, updatable = false)
	private SystemParametersCodeMaster siServiceProviderCode;

	@Column(name = "si_service_provider_code")
	private Integer siServiceProviderCd;

	@Column(name = "si_contract_number")
	private String siContractNumber;

	@Column(name = "si_no_of_services_year")
	private Integer siNoServicesYear;

	@Column(name = "si_last_service_date")
	private Date siLastServiceDate;

	@Column(name = "si_next_service_date")
	private Date siNextServiceDate;

	@Column(name = "si_warrant_period")
	private Integer siWarrantPeriod;

	@Column(name = "si_warranty_end_date")
	private Date siwarrantyEndDate;

	@Column(name = "si_created_by")
	private Integer siCreatedBy;

	@Column(name = "si_created_date")
	private Date siCreatedDate;

	@Column(name = "si_updated_by")
	private Integer siUpdatedBy;

	@Column(name = "si_updated_date")
	private Date siUpdatedDate;

	@Transient
	private String comValueSP;

	public ServiceInfo() {
		super();
	}

	public Integer getSiId() {
		return siId;
	}

	public void setSiId(Integer siId) {
		this.siId = siId;
	}

	public Asset getSiAssetCode() {
		return siAssetCode;
	}

	public void setSiAssetCode(Asset siAssetCode) {
		this.siAssetCode = siAssetCode;
	}

	public Integer getSiServiceProviderCd() {
		return siServiceProviderCd;
	}

	public void setSiServiceProviderCd(Integer siServiceProviderCd) {
		this.siServiceProviderCd = siServiceProviderCd;
	}

	public SystemParametersCodeMaster getSiServiceProviderCode() {
		return siServiceProviderCode;
	}

	public void setSiServiceProviderCode(
			SystemParametersCodeMaster siServiceProviderCode) {
		this.siServiceProviderCode = siServiceProviderCode;
	}

	public String getSiContractNumber() {
		return siContractNumber;
	}

	public void setSiContractNumber(String siContractNumber) {
		this.siContractNumber = siContractNumber;
	}

	public Integer getSiNoServicesYear() {
		return siNoServicesYear;
	}

	public void setSiNoServicesYear(Integer siNoServicesYear) {
		this.siNoServicesYear = siNoServicesYear;
	}

	public Date getSiLastServiceDate() {
		return siLastServiceDate;
	}

	public void setSiLastServiceDate(Date siLastServiceDate) {
		this.siLastServiceDate = siLastServiceDate;
	}

	public Date getSiNextServiceDate() {
		return siNextServiceDate;
	}

	public void setSiNextServiceDate(Date siNextServiceDate) {
		this.siNextServiceDate = siNextServiceDate;
	}

	public String getComValueSP() {
		return comValueSP;
	}

	public void setComValueSP(String comValueSP) {
		this.comValueSP = comValueSP;
	}

	public Integer getSiWarrantPeriod() {
		return siWarrantPeriod;
	}

	public void setSiWarrantPeriod(Integer siWarrantPeriod) {
		this.siWarrantPeriod = siWarrantPeriod;
	}

	public Integer getSiCreatedBy() {
		return siCreatedBy;
	}

	public Date getSiwarrantyEndDate() {
		return siwarrantyEndDate;
	}

	public void setSiwarrantyEndDate(Date siwarrantyEndDate) {
		this.siwarrantyEndDate = siwarrantyEndDate;
	}

	public void setSiCreatedBy(Integer siCreatedBy) {
		this.siCreatedBy = siCreatedBy;
	}

	public Date getSiCreatedDate() {
		return siCreatedDate;
	}

	public void setSiCreatedDate(Date siCreatedDate) {
		this.siCreatedDate = siCreatedDate;
	}

	public Integer getSiUpdatedBy() {
		return siUpdatedBy;
	}

	public void setSiUpdatedBy(Integer siUpdatedBy) {
		this.siUpdatedBy = siUpdatedBy;
	}

	public Date getSiUpdatedDate() {
		return siUpdatedDate;
	}

	public void setSiUpdatedDate(Date siUpdatedDate) {
		this.siUpdatedDate = siUpdatedDate;
	}

	@Override
	public String toString() {
		return "ServiceInfo [siId=" + siId + ", siAssetCode=" + siAssetCode
				+ ", siServiceProviderCode=" + siServiceProviderCode
				+ ", siServiceProviderCd=" + siServiceProviderCd
				+ ", siContractNumber=" + siContractNumber
				+ ", siNoServicesYear=" + siNoServicesYear
				+ ", siLastServiceDate=" + siLastServiceDate
				+ ", siNextServiceDate=" + siNextServiceDate
				+ ", siWarrantPeriod=" + siWarrantPeriod
				+ ", siwarrantyEndDate=" + siwarrantyEndDate + ", siCreatedBy="
				+ siCreatedBy + ", siCreatedDate=" + siCreatedDate
				+ ", siUpdatedBy=" + siUpdatedBy + ", siUpdatedDate="
				+ siUpdatedDate + ", comValueSP=" + comValueSP + "]";
	}

}