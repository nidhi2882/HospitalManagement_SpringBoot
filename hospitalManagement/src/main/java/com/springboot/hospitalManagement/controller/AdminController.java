package com.springboot.hospitalManagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.hospitalManagement.dto.DoctorResponseDTO;
import com.springboot.hospitalManagement.dto.OnBoardDoctorRequestDTO;
import com.springboot.hospitalManagement.dto.PatientResponseDTO;
import com.springboot.hospitalManagement.service.DoctorService;
import com.springboot.hospitalManagement.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/admin")

public class AdminController {

    private final PatientService patientService;
    private final DoctorService doctorService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients(
            @RequestParam(value = "page", defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "size", defaultValue = "10") Integer pageSize
    ) {
        return ResponseEntity.ok(patientService.getAllPatients(pageNumber, pageSize));
    }

    @PostMapping("/onBoardNewDoctor")
    public ResponseEntity<DoctorResponseDTO> onBoardNewDoctor(@RequestBody OnBoardDoctorRequestDTO onboardDoctorRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.onBoardNewDoctor(onboardDoctorRequestDto));
    }

	public AdminController(PatientService patientService, DoctorService doctorService) {
		super();
		this.patientService = patientService;
		this.doctorService = doctorService;
	}
}
