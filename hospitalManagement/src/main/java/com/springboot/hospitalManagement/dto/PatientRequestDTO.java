package com.springboot.hospitalManagement.dto;

import java.time.LocalDate;

public class PatientRequestDTO {

	private String name;
	private LocalDate birthDate;
	private String gender;
	public PatientRequestDTO(String name, LocalDate birthDate, String gender) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
	}
	public PatientRequestDTO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
