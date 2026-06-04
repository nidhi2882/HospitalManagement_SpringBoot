package com.springboot.hospitalManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.hospitalManagement.dto.PatientResponseDTO;
import com.springboot.hospitalManagement.entity.Patient;
import com.springboot.hospitalManagement.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	 private final PatientRepository patientRepository;
	    private final ModelMapper modelMapper;

	    @Transactional
	    public PatientResponseDTO getPatientById(Long patientId) {
	        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not " +
	                "Found with id: " + patientId));
	        return modelMapper.map(patient, PatientResponseDTO.class);
	    }

	    public List<PatientResponseDTO> getAllPatients(Integer pageNumber, Integer pageSize) {
	        return patientRepository.findAll(PageRequest.of(pageNumber, pageSize))
	                .stream()
	                .map(patient -> modelMapper.map(patient, PatientResponseDTO.class))
	                .collect(Collectors.toList());
	    }

		public PatientService(PatientRepository patientRepository, ModelMapper modelMapper) {
			super();
			this.patientRepository = patientRepository;
			this.modelMapper = modelMapper;
		}
	
	//private final PatientRepository patientRepository; 
	
	//CREATE
//	public PatientResponseDTO createPatient(PatientRequestDTO dto)
//	{
//		Patient patient = new Patient();
//		patient.setName(dto.getName());
//		patient.setBirthDate(dto.getBirthDate());
//		patient.setGender(dto.getGender());
//		
//		Patient saved = patientRepository.save(patient);
//		return mapToResponseDTO(saved);
//	}
}
