package com.cg.hcs.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@Column(name = "appointment_id")
	private Integer appointmentId;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
	private Diagnosticcenter center;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
	private Test test;
	@Column(name="appointment_date")
    LocalDate appointmentDate;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
	private Patient patient;
	
	public Appointment() {}

	public Appointment(Integer appointmentId, Users user, Diagnosticcenter center, Test test, LocalDate appointmentDate,
			Doctor doctor, Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.user = user;
		this.center = center;
		this.test = test;
		this.appointmentDate = appointmentDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
}
