package com.springboot.hospitalManagement.dto;

import java.time.LocalDate;

public class InsuranceRequestDTO {

	private String policyNumber;
	private String provider;
	private LocalDate validUntil;
	private Long patientId;
	public InsuranceRequestDTO(String policyNumber, String provider, LocalDate validUntil, Long patientId) {
		super();
		this.policyNumber = policyNumber;
		this.provider = provider;
		this.validUntil = validUntil;
		this.patientId = patientId;
	}
	public InsuranceRequestDTO() {
		super();
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
	
	
}
