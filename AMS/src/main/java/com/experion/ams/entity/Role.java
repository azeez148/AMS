package com.experion.ams.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name="ams_role")
public class Role implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ar_id")
	private Long id;
	
	@Column(name = "ar_name")
	private String roleName;
	
	@Column(name = "ar_description")
	private String description;
	
	@Column(name = "ar_status")
	private String status;
	
	@OneToMany(mappedBy = "role", fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<RoleToScreenMapping> roleScreenMap;
	
	public Role() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<RoleToScreenMapping> getRoleScreenMap() {
		return roleScreenMap;
	}

	public void setRoleScreenMap(List<RoleToScreenMapping> roleScreenMap) {
		this.roleScreenMap = roleScreenMap;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", description="
				+ description + ", status=" + status + ", roleScreenMap="
				+ roleScreenMap + "]";
	}
   
}
