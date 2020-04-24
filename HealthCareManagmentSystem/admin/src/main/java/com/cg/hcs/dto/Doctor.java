package com.cg.hcs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor 
{
	@Id
	@Column(name="doctor_id")
	private Integer doctorId;
	@Column(name="doctor_name")
	private String doctorName;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="center_id")
	private Diagnosticcenter center;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="test_id")
	private Test test;
	@Column(name="specialization")
	private String specialization;
	@Column(name="degree")
	private String degree;
	
	public Doctor() { }

	public Doctor(Integer doctorId, String doctorName, Users user, Diagnosticcenter center, Test test,
			String specialization, String degree) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.user = user;
		this.center = center;
		this.test = test;
		this.specialization = specialization;
		this.degree = degree;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Diagnosticcenter getCenter() {
		return center;
	}

	public void setCenter(Diagnosticcenter center) {
		this.center = center;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	
}
