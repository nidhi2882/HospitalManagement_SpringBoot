package com.springboot.hospitalManagement.dto;

public class DoctorRequestDTO {

	private String name;
	private String specialization;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public DoctorRequestDTO() {
		super();
	}
	public DoctorRequestDTO(String name, String specialization, String email) {
		super();
		this.name = name;
		this.specialization = specialization;
		this.email = email;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
