package com.springboot.hospitalManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalManagement.dto.AppointmentRequestDTO;
import com.springboot.hospitalManagement.dto.AppointmentResponseDTO;
import com.springboot.hospitalManagement.dto.PatientResponseDTO;
import com.springboot.hospitalManagement.service.AppointmentService;
import com.springboot.hospitalManagement.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @PostMapping("/appointments")
    public ResponseEntity<AppointmentResponseDTO> createNewAppointment(@RequestBody AppointmentRequestDTO createAppointmentRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createNewAppointment(createAppointmentRequestDto));
    }

    @GetMapping("/profile")
    private ResponseEntity<PatientResponseDTO> getPatientProfile() {
        Long patientId = 4L;
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

	public PatientController(PatientService patientService, AppointmentService appointmentService) {
		super();
		this.patientService = patientService;
		this.appointmentService = appointmentService;
	}

}