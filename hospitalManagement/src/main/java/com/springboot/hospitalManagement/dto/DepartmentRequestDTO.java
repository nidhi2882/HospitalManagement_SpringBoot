package com.springboot.hospitalManagement.dto;

public class DepartmentRequestDTO {

	private String name;
	private Long doctorId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DepartmentRequestDTO() {
		super();
	}
	public DepartmentRequestDTO(String name, Long doctorId) {
		super();
		this.name = name;
		this.doctorId = doctorId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
}
