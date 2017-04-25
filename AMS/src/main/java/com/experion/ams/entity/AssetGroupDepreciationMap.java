package com.experion.ams.entity;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ams_group_depreciation_map")
//@Table(name = "ams_group_depreciation_map", catalog = "ams")
public class AssetGroupDepreciationMap implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ams_asset_group"))
//	@GeneratedValue(generator = "generator")
	@Column(name="gdm_id")
	
	
	private Long deprecateId;
//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ams_asset_group"))
//	@Id
//	@GeneratedValue(generator = "generator")
////	@Column(name = "gdm_id", unique = true, nullable = false)	
//	@Column(name="gdm_asset_code")
//	private Integer assetCode;
	
	@Column(name="gdm_depreciation_type")
	private String deprecateType;
	
	@Column(name="gdm_depreciation_value")
	private String depriciateValue;
	
	@Column(name="gdm_date_from")
	private Date depreicateDateFrom;
	
	@Column(name="gdm_date_to")
	private Date depricateDateTo;

//	@OneToOne(fetch = FetchType.LAZY)
////@PrimaryKeyJoinColumn
//@JoinColumn(name="group_id")
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "gdm_group_code")
	private AssetGroup groupMaster;

	public Long getDeprecateId() {
		return deprecateId;
	}

	public void setDeprecateId(Long deprecateId) {
		this.deprecateId = deprecateId;
	}

//	public Integer getAssetCode() {
//		return assetCode;
//	}

//	public void setAssetCode(Integer assetCode) {
//		this.assetCode = assetCode;
//	}

	public String getDeprecateType() {
		return deprecateType;
	}

	public void setDeprecateType(String deprecateType) {
		this.deprecateType = deprecateType;
	}

	public String getDepriciateValue() {
		return depriciateValue;
	}

	public void setDepriciateValue(String depriciateValue) {
		this.depriciateValue = depriciateValue;
	}

	public Date getDepreicateDateFrom() {
		return depreicateDateFrom;
	}

	public void setDepreicateDateFrom(Date depreicateDateFrom) {
		this.depreicateDateFrom = depreicateDateFrom;
	}

	public Date getDepricateDateTo() {
		return depricateDateTo;
	}

	public void setDepricateDateTo(Date depricateDateTo) {
		this.depricateDateTo = depricateDateTo;
	}


	public AssetGroup getGroupMaster() {
		return groupMaster;
	}

	public void setGroupMaster(AssetGroup groupMaster) {
		this.groupMaster = groupMaster;
	}
	

}
