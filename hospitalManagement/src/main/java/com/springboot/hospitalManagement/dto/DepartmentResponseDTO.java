package com.springboot.hospitalManagement.dto;

import java.util.Set;

public class DepartmentResponseDTO {
	
	private Long id;
	public DepartmentResponseDTO() {
		super();
	}
	public DepartmentResponseDTO(Long id, String name, Long headDoctorId, Set<Long> doctorsId) {
		super();
		this.id = id;
		this.name = name;
		this.headDoctorId = headDoctorId;
		this.doctorsId = doctorsId;
	}
	private String name;
	private Long headDoctorId;
	private Set<Long> doctorsId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getHeadDoctorId() {
		return headDoctorId;
	}
	public void setHeadDoctorId(Long headDoctorId) {
		this.headDoctorId = headDoctorId;
	}
	public Set<Long> getDoctorsId() {
		return doctorsId;
	}
	public void setDoctorsId(Set<Long> doctorsId) {
		this.doctorsId = doctorsId;
	}
}
