package com.springboot.hospitalManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalManagement.dto.DoctorResponseDTO;
import com.springboot.hospitalManagement.service.DoctorService;

@RestController
@RequestMapping("/public")

public class HospitalController {

	    private final DoctorService doctorService;

	    public HospitalController(DoctorService doctorService) {
			super();
			this.doctorService = doctorService;
		}

		@GetMapping("/doctors")
	    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
	        return ResponseEntity.ok(doctorService.getAllDoctors());
	    }
	}
