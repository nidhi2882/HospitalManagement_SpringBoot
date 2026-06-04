package com.springboot.hospitalManagement.dto;

import java.time.LocalDateTime;


public class AppointmentResponseDTO {
	
	private Long id;
	private LocalDateTime appointmentTime;
	private String reason;
	private Long patientId;
	private Long doctorId;
	public AppointmentResponseDTO(Long id, LocalDateTime appointmentTime, String reason, Long patientId,
			Long doctorId) {
		super();
		this.id = id;
		this.appointmentTime = appointmentTime;
		this.reason = reason;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}
	public AppointmentResponseDTO() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
}
