package com.springboot.hospitalManagement.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(nullable = false)
		private LocalDateTime appointmentTime;
		
		@Column(length = 50)
		private String reason;
		
		@ManyToOne
		@JoinColumn(name = "patient_id",nullable = false) //patient is req. hence not nullable
		private Patient patient;
		
		@ManyToOne
		@JoinColumn(nullable = false)
		private Doctor doctor;
}
