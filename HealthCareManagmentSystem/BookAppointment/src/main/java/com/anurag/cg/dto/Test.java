package com.anurag.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test 
{
	@Id
	@Column(name="test_id")
	int testId;
	@Column(name="center_id")
	String centerId;
	@Column(name="test_name")
	String testName;
	public Test() {	}
	public Test(String centerId, int testId, String testName) {
		
		this.centerId = centerId;
		this.testId = testId;
		this.testName = testName;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	
}

	
       