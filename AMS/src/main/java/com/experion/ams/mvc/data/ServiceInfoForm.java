package com.experion.ams.mvc.data;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ServiceInfoForm {

	private Integer siId;

	private Integer siAssetCode;


	private Integer siServiceProviderCode;

	@NotEmpty(message = "not empty")
	private String siContractNumber;

	@NotNull
	@Min(1)
	private Integer siNoServicesYear;

	@NotEmpty(message = "not empty")
	private String siLastServiceDate;

	@NotEmpty(message = "not empty")
	private String siNextServiceDate;

	private Integer siWarrantPeriod;

	private String siwarrantyEndDate;

	private Long siCreatedBy;

	private Date siCreatedDate;

	private Integer siUpdatedBy;

	private Date siUpdatedDate;

	private String siComValue;

	private String assetNo;

	private String message;

	public Integer getSiId() {
		return siId;
	}

	public void setSiId(Integer siId) {
		this.siId = siId;
	}

	public Integer getSiAssetCode() {
		return siAssetCode;
	}

	public void setSiAssetCode(Integer siAssetCode) {
		this.siAssetCode = siAssetCode;
	}

	public Integer getSiServiceProviderCode() {
		return siServiceProviderCode;
	}

	public void setSiServiceProviderCode(Integer siServiceProviderCode) {
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

	public String getSiLastServiceDate() {
		return siLastServiceDate;
	}

	public void setSiLastServiceDate(String siLastServiceDate) {
		this.siLastServiceDate = siLastServiceDate;
	}

	public String getSiNextServiceDate() {
		return siNextServiceDate;
	}

	public void setSiNextServiceDate(String siNextServiceDate) {
		this.siNextServiceDate = siNextServiceDate;
	}

	public Integer getSiWarrantPeriod() {
		return siWarrantPeriod;
	}

	public void setSiWarrantPeriod(Integer siWarrantPeriod) {
		this.siWarrantPeriod = siWarrantPeriod;
	}

	public String getSiwarrantyEndDate() {
		return siwarrantyEndDate;
	}

	public void setSiwarrantyEndDate(String siwarrantyEndDate) {
		this.siwarrantyEndDate = siwarrantyEndDate;
	}

	public Long getSiCreatedBy() {
		return siCreatedBy;
	}

	public void setSiCreatedBy(Long siCreatedBy) {
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

	public String getSiComValue() {
		return siComValue;
	}

	public void setSiComValue(String siComValue) {
		this.siComValue = siComValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAssetNo() {
		return assetNo;
	}

	public void setAssetNo(String assetNo) {
		this.assetNo = assetNo;
	}

}
