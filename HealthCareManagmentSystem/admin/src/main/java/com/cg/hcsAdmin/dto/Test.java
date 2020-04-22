package com.cg.hcsAdmin.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Test 
{
	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="test_seq")
	@SequenceGenerator(name="test_seq",sequenceName = "test_seq",allocationSize = 1)
	private Integer testId;
	@OneToOne
    @JoinColumn(name = "center_id")
	private Diagnosticcenter diagnosticcenter;
	@Column(name = "test_name")
	private String test_name;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private int price;
	
	public Test() {	}
	

	public Test(Integer testId, Diagnosticcenter diagnosticcenter, String test_name, String description, int price) {
		super();
		this.testId = testId;
		this.diagnosticcenter = diagnosticcenter;
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

	public Diagnosticcenter getDiagnosticcenter() {
		return diagnosticcenter;
	}

	public void setDiagnosticcenter(Diagnosticcenter diagnosticcenter) {
		this.diagnosticcenter = diagnosticcenter;
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