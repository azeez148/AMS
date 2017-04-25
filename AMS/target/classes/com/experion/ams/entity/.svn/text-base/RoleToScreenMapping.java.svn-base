package com.experion.ams.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: RoleToScreenMapping
 *
 */
@Entity
@Table(name = "ams_role_screen_map")
public class RoleToScreenMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rsm_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rsm_role_code")
	private Role role;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "rsm_screen_code",insertable=false,updatable=false)
	private Screen screen;
	
//	@Column(name = "rsm_role_code")
//	private Long roleId;
	
	@Column(name = "rsm_screen_code")
	private Long screenId;

	public RoleToScreenMapping() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/*public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}*/

	public Long getScreenId() {
		return screenId;
	}

	public void setScreenId(Long screenId) {
		this.screenId = screenId;
	}

	/*@Override
	public String toString() {
		return "RoleToScreenMapping [id=" + id + ", role=" + role + ", screen="
				+ screen + ", roleId=" + roleId + ", screenId=" + screenId
				+ "]";
	}*/
}
