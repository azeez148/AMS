package com.experion.ams.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ams_asset_group")
// @Table(name = "ams_asset_group", catalog = "ams", uniqueConstraints = {
// @UniqueConstraint(columnNames = "group_id") })
public class AssetGroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8291508329602039496L;

	@Id
	@GenericGenerator(strategy = "identity", name = "identity")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_description")
	private String groupDesc;

	@Column(name = "group_created_by")
	private Long groupCreatedBy;

	@Column(name = "group_created_date")
	private Date groupCreatedDate;

	@Column(name = "group_updated_by")
	private Integer groupUpdatedBy;

	@Column(name = "group_updated_date")
	private Date groupUpadatedDate;

	@Column(name = "group_status")
	private String groupStatus;

	// @OneToOne(fetch = FetchType.LAZY, mappedBy = "groupMaster", cascade =
	// CascadeType.ALL)
	@JsonBackReference
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy ="groupMaster")
	//@OneToOne(mappedBy = "groupMaster", fetch = FetchType.LAZY)
	private AssetGroupDepreciationMap groupDepreciation;

	@JsonBackReference
	@OneToMany(mappedBy = "assetGroupCode", fetch = FetchType.LAZY)
	@OrderBy("assetNumber ASC")
	private List<Asset> asset;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Long getGroupCreatedBy() {
		return groupCreatedBy;
	}

	public void setGroupCreatedBy(Long groupCreatedBy) {
		this.groupCreatedBy = groupCreatedBy;
	}

	public Date getGroupCreatedDate() {
		return groupCreatedDate;
	}

	public void setGroupCreatedDate(Date groupCreatedDate) {
		this.groupCreatedDate = groupCreatedDate;
	}

	public Integer getGroupUpdatedBy() {
		return groupUpdatedBy;
	}

	public void setGroupUpdatedBy(Integer groupUpdatedBy) {
		this.groupUpdatedBy = groupUpdatedBy;
	}

	public Date getGroupUpadatedDate() {
		return groupUpadatedDate;
	}

	public void setGroupUpadatedDate(Date groupUpadatedDate) {
		this.groupUpadatedDate = groupUpadatedDate;
	}

	public String getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}

	public AssetGroupDepreciationMap getGroupDepreciation() {
		return groupDepreciation;
	}

	public void setGroupDepreciation(AssetGroupDepreciationMap groupDepreciation) {
		this.groupDepreciation = groupDepreciation;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public List<Asset> getAsset() {
		return asset;
	}

	public void setAsset(List<Asset> asset) {
		this.asset = asset;
	}

}
