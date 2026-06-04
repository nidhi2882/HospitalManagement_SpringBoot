package com.springboot.hospitalManagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalManagement.dto.AppointmentResponseDTO;
import com.springboot.hospitalManagement.entity.User;
import com.springboot.hospitalManagement.service.AppointmentService;

@RestController
@RequestMapping("/doctors")

public class DoctorController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointmentsOfDoctor() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(appointmentService.getAllAppointmentsOfDoctor(user.getId()));
    }

	public DoctorController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}

}