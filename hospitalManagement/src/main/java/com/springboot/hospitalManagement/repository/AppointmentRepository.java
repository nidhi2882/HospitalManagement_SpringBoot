package com.springboot.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalManagement.entity.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Long>{

}
