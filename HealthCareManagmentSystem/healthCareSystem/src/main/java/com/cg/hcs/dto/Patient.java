package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class Patient 
{
	@Id
	@Column(name="patient_id")
	private Integer patientId;
	@Column(name="patient_name")
	private String patientName;
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column(name="email")
	private String email;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	
	public Patient() { }
	
	public Patient(Integer patientId, String patientName, Long mobileNo, String email, Users user) 
	{
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.user = user;
	}

	public Integer getPatientId() 
	{
		return patientId;
	}

	public void setPatientId(Integer patientId) 
	{
		this.patientId = patientId;
	}

	public String getPatientName() 
	{
		return patientName;
	}

	public void setPatientName(String patientName) 
	{
		this.patientName = patientName;
	}

	public Long getMobileNo() 
	{
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) 
	{
		this.mobileNo = mobileNo;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public Users getUser() 
	{
		return user;
	}

	public void setUser(Users user) 
	{
		this.user = user;
	}
}
