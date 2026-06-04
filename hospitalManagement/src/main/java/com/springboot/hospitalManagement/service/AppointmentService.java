package com.springboot.hospitalManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.hospitalManagement.dto.AppointmentRequestDTO;
import com.springboot.hospitalManagement.dto.AppointmentResponseDTO;
import com.springboot.hospitalManagement.entity.Appointment;
import com.springboot.hospitalManagement.entity.Doctor;
import com.springboot.hospitalManagement.entity.Patient;
import com.springboot.hospitalManagement.repository.AppointmentRepository;
import com.springboot.hospitalManagement.repository.DoctorRepository;
import com.springboot.hospitalManagement.repository.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	private final DoctorRepository doctorRepository;
	private final ModelMapper modelMapper;
	private final PatientRepository patientRepository;
	private final AppointmentRepository appointmentRepository;

	public AppointmentService(DoctorRepository doctorRepository, ModelMapper modelMapper,
			PatientRepository patientRepository, AppointmentRepository appointmentRepository) {
		super();
		this.doctorRepository = doctorRepository;
		this.modelMapper = modelMapper;
		this.patientRepository = patientRepository;
		this.appointmentRepository = appointmentRepository;
	}

	


	@Transactional
	 public AppointmentResponseDTO createNewAppointment(AppointmentRequestDTO appointmentRequestDto) {
	        Long doctorId = appointmentRequestDto.getDoctorId();
	        Long patientId = appointmentRequestDto.getPatientId();

	        Patient patient = patientRepository.findById(patientId)
	                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID: " + patientId));
	        Doctor doctor = doctorRepository.findById(doctorId)
	                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID: " + doctorId));
	        Appointment appointment = new Appointment();

	        appointment.setReason(appointmentRequestDto.getReason());
	        appointment.setAppointmentTime(
	                appointmentRequestDto.getAppointmentTime()
	        );

	        appointment.setPatient(patient);
	        appointment.setDoctor(doctor);
	        patient.getAppointments().add(appointment); // to maintain consistency

	        appointment = appointmentRepository.save(appointment);
	        return modelMapper.map(appointment, AppointmentResponseDTO.class);
	    }
	@Transactional
	public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); // just for bidirectional consistency

        return appointment;
    }
	@Transactional
	public List<AppointmentResponseDTO> getAllAppointmentsOfDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        return doctor.getAppointments()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                .collect(Collectors.toList());
    }

	
}
