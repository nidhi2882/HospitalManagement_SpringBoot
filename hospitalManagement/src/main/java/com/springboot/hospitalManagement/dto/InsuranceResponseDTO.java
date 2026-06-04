package com.springboot.hospitalManagement.dto;

import java.time.LocalDate;

public class InsuranceResponseDTO {

	private Long id;
	private String policyNumber;
	private String provider;
	private LocalDate validUntil;
	private Long patientId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public LocalDate getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(LocalDate validUntil) {
		this.validUntil = validUntil;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public InsuranceResponseDTO(Long id, String policyNumber, String provider, LocalDate validUntil, Long patientId) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.provider = provider;
		this.validUntil = validUntil;
		this.patientId = patientId;
	}
	public InsuranceResponseDTO() {
		super();
	}
	
	
}
