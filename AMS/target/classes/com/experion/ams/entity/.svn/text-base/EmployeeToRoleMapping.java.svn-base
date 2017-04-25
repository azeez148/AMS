package com.experion.ams.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

/**
 * Entity implementation class for Entity: EmployeeToRoleMapping
 *
 */
@Entity
@Table(name = "ams_employee_role_map")
public class EmployeeToRoleMapping implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emprole_id")
	private Long id;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "emprole_emp_code", nullable = false)
	private Employee empCode;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "emprole_role_code", nullable = false)
	private Role roleCode;
	
	@Column(name = "emprole_default_role_code")
	private Long defaultRoleCode;
	
	public EmployeeToRoleMapping() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Employee empCode) {
		this.empCode = empCode;
	}

	public Role getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(Role roleCode) {
		this.roleCode = roleCode;
	}

	public Long getDefaultRoleCode() {
		return defaultRoleCode;
	}

	public void setDefaultRoleCode(Long defaultRoleCode) {
		this.defaultRoleCode = defaultRoleCode;
	}
   
}
