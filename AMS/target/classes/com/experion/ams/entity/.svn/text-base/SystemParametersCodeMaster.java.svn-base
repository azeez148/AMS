package com.experion.ams.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ams_code_master")
public class SystemParametersCodeMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "com_id")
	private Integer comId;

	@Column(name = "com_code")
	private Integer comCode;

	@Column(name = "com_type")
	private String comType;

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		this.comType = comType;
	}

	public String getComValue() {
		return comValue;
	}

	public void setComValue(String comValue) {
		this.comValue = comValue;
	}

	public String getComDescription() {
		return comDescription;
	}

	public void setComDescription(String comDescription) {
		this.comDescription = comDescription;
	}

	public String getComRemarks() {
		return comRemarks;
	}

	public void setComRemarks(String comRemarks) {
		this.comRemarks = comRemarks;
	}

	@Column(name = "com_value")
	private String comValue;

	@Column(name = "com_description")
	private String comDescription;

	@Column(name = "com_remarks")
	private String comRemarks;

	@Column(name = "com_user_editable")
	private Integer comUserEditable;

	@Transient
	private int pageNum=1;
	@Transient
	private int pagecountHidden=0;

	public int getPagecountHidden() {
		return pagecountHidden;
	}

	public void setPagecountHidden(int pagecountHidden) {
		this.pagecountHidden = pagecountHidden;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public Integer getComCode() {
		return comCode;
	}

	public void setComCode(Integer comCode) {
		this.comCode = comCode;
	}

	public Integer getComUserEditable() {
		return comUserEditable;
	}

	public void setComUserEditable(Integer comUserEditable) {
		this.comUserEditable = comUserEditable;
	}

	public String getComMenuOrder() {
		return comMenuOrder;
	}

	public void setComMenuOrder(String comMenuOrder) {
		this.comMenuOrder = comMenuOrder;
	}

	public String getComAddAttr1() {
		return comAddAttr1;
	}

	public void setComAddAttr1(String comAddAttr1) {
		this.comAddAttr1 = comAddAttr1;
	}

	public String getComAddAttr2() {
		return comAddAttr2;
	}

	public void setComAddAttr2(String comAddAttr2) {
		this.comAddAttr2 = comAddAttr2;
	}

	public String getComAddAttr3() {
		return comAddAttr3;
	}

	public void setComAddAttr3(String comAddAttr3) {
		this.comAddAttr3 = comAddAttr3;
	}

	public String getComStatus() {
		return comStatus;
	}

	public void setComStatus(String comStatus) {
		this.comStatus = comStatus;
	}

	@Column(name = "com_menu_order")
	private String comMenuOrder;

	@Column(name = "com_addl_attr1")
	private String comAddAttr1;

	@Column(name = "com_addl_attr2")
	private String comAddAttr2;

	@Column(name = "com_addl_attr3")
	private String comAddAttr3;

	@Column(name = "com_status")
	private String comStatus;

}
