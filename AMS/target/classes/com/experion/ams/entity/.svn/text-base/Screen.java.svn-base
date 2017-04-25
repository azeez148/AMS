package com.experion.ams.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Screen
 *
 */
@Entity
@Table(name="ams_screen")
public class Screen implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "scr_id")
	private Long id;
	
	@Column(name = "scr_name")
	private String screenName;
	
	@Column(name = "scr_description")
	private String description;
	
/*	@Column(name = "scr_url")
	private String screenURL;*/
	
	@Column(name = "scr_status")
	private String status;
	
	
	public Screen() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getScreenName() {
		return screenName;
	}


	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


/*	public String getScreenURL() {
		return screenURL;
	}


	public void setScreenURL(String screenURL) {
		this.screenURL = screenURL;
	}*/


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
   
}
