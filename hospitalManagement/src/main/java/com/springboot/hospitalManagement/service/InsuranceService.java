package com.springboot.hospitalManagement.service;

import org.springframework.stereotype.Service;

import com.springboot.hospitalManagement.entity.Insurance;
import com.springboot.hospitalManagement.entity.Patient;
import com.springboot.hospitalManagement.repository.InsuranceRepository;
import com.springboot.hospitalManagement.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class InsuranceService {
	private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
	 public InsuranceService(InsuranceRepository insuranceRepository, PatientRepository patientRepository) {
		this.insuranceRepository = insuranceRepository;
		this.patientRepository = patientRepository;
	}

	 @Transactional
	    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
	        Patient patient = patientRepository.findById(patientId)
	                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

	        patient.setInsurance(insurance);
	        insurance.setPatient(patient); // bidirectional consistency maintainence

	        return patient;
	    }

	    @Transactional
	    public Patient disaccociateInsuranceFromPatient(Long patientId) {
	        Patient patient = patientRepository.findById(patientId)
	                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));

	        patient.setInsurance(null);
	        return patient;
	    }

		
	
}
