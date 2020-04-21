package com.anurag.cg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
	@Column(name="appointment_id")
	   int appointmentId;
	@Column(name="user_id")
	   String userId;
	 @Column(name="center_id")
	   String centerId;
	@Column(name="test_id")
	   String testId;
	@Column(name="test_name")
	   String testName;
	@Column(name="time")
	   String time;
	public Appointment() {	}
	public Appointment(String centerId, String userId, int appointmentId, String testId, String testName, String time) {
		this.centerId = centerId;
		this.userId = userId;
		this.appointmentId = appointmentId;
		this.testId = testId;
		this.testName = testName;
		this.time = time;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	

}
