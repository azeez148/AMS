package com.experion.ams.mvc.data;

import java.io.Serializable;

public class AssetListData implements Serializable{
	
	private static final long serialVersionUID = -169626869927070996L;
	
	private String assetNumber;
	private String assetModel;
	private String Department;
	private String Projects;
	private String Custodian;
	public String getAssetNumber() {
		return assetNumber;
	}
	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}
	public String getAssetModel() {
		return assetModel;
	}
	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getProjects() {
		return Projects;
	}
	public void setProjects(String projects) {
		Projects = projects;
	}
	public String getCustodian() {
		return Custodian;
	}
	public void setCustodian(String custodian) {
		Custodian = custodian;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
