package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestCenter {
    @Id
    @Column(name="tc_id")
    private int tcId;
	@Column(name="test_id")
	private Integer testId;
	@Column(name="center_id")
	private Integer centerId;
	public TestCenter() {}
	public TestCenter(int tcId,Integer testId, Integer centerId) 
	{
		this.tcId=tcId;
		this.testId = testId;
		this.centerId = centerId;
	}
	
	public int getTcId() {
		return tcId;
	}
	public void setTcId(int tcId) {
		this.tcId = tcId;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public Integer getCenterId() {
		return centerId;
	}
	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}
	
	
	

}
