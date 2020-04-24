package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diagnosticcenter")
public class Diagnosticcenter 
{
	@Id
	@Column(name = "center_id")
	private Integer centerId;
	@Column(name = "center_name")
	private String centerName;
	@Column(name = "center_area")
	private String centerArea;
	
	public Diagnosticcenter() {	}

	public Diagnosticcenter(Integer centerId, String centerName, String centerArea) {
		this.centerId = centerId;
		this.centerName = centerName;
		this.centerArea = centerArea;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterArea() {
		return centerArea;
	}

	public void setCenterArea(String centerArea) {
		this.centerArea = centerArea;
	}
	
	
}