package com.experion.ams.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="ams_employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empId;
	
	@Column(name = "emp_code")
	private Long empCode;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_contact")
	private String empContact;
	
	@Column(name = "emp_designation")
	private String empDesignation;

	@Column(name = "emp_email")
	private String empEmail;
	
	@Column(name = "emp_gender")
	private String empGender;
	
	@Column(name = "emp_joining_date")
	private String joiningDate;

	@Column(name = "EMP_STATUS")
	private String empStatus;
	
	@Column(name = "emp_updated_by")
	private Long updatedBy;
	
	@OneToMany(mappedBy="physicalverificationcreatedby")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PhysicalVerification> physicalverificationcreatedby;
	
	@OneToMany(mappedBy="physicalverificationupdatedby")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PhysicalVerification> physicalverificationupdatedby;
	
	/*@Column(name = "emp_updated_date")
	private String updatedDate;*/
	@JsonBackReference
	@OneToMany(mappedBy = "empCode", fetch=FetchType.EAGER)
	private List<EmployeeToRoleMapping> empRoleMapping;
	
	public Employee() {
		super();
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public Long getEmpCode() {
		return empCode;
	}


	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpContact() {
		return empContact;
	}


	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}


	public String getEmpDesignation() {
		return empDesignation;
	}


	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getEmpGender() {
		return empGender;
	}


	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}


	public String getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getEmpStatus() {
		return empStatus;
	}


	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}


	public Long getUpdatedBy() {
		return updatedBy;
	}


	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}


/*	public String getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}*/
	
	public List<EmployeeToRoleMapping> getEmpRoleMapping() {
		return empRoleMapping;
	}


	public void setEmpRoleMapping(List<EmployeeToRoleMapping> empRoleMapping) {
		this.empRoleMapping = empRoleMapping;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empCode=" + empCode
				+ ", empName=" + empName + ", empContact=" + empContact
				+ ", empDesignation=" + empDesignation + ", empEmail="
				+ empEmail + ", empGender=" + empGender + ", joiningDate="
				+ joiningDate + ", empStatus=" + empStatus + ", updatedBy="
				+ updatedBy + ", physicalverificationcreatedby="
				+ physicalverificationcreatedby
				+ ", physicalverificationupdatedby="
				+ physicalverificationupdatedby + ", empRoleMapping="
				+ empRoleMapping + "]";
	}

}
