package com.anurag.cg.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Diagnosticcenter 
{
    @Id
    @Column(name="center_id")
	   String centerId;
    @Column(name="center_name")
	   String centerName;
    @Column(name="center_area")
    String centerArea;
     public String getCenterArea() {
		return centerArea;
	}
	public void setCenterArea(String centerArea) {
		this.centerArea = centerArea;
	}
	public Diagnosticcenter() {	}
	public Diagnosticcenter(String centerId, String centerName) {
		this.centerId = centerId;
		this.centerName = centerName;
		
	}
	
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
	
    
 
 
    
}
