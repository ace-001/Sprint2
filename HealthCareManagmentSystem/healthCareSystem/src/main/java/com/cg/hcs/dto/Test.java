package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test 
{
	@Id
	@Column(name = "test_id")
	private Integer testId;
	@Column(name = "test_name")
	private String test_name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private int price;
	
	public Test() {	}

	public Test(Integer testId, String test_name, String description, int price) {
		super();
		this.testId = testId;
		this.test_name = test_name;
		this.description = description;
		this.price = price;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	
	
}