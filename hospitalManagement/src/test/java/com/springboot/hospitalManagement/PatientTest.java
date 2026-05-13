package com.springboot.hospitalManagement;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.hospitalManagement.entity.Patient;
import com.springboot.hospitalManagement.repository.PatientRepository;

@SpringBootTest
public class PatientTest {

	@Autowired 
	private PatientRepository patientRepository;
	
	@Test
	public void testPatientRepository()
	{
		List<Patient> list = patientRepository.findAll();
		System.out.println(list);
	}
	
	@Test
	public void testCreatePatient()
	{
		Patient patient = new Patient();
		patient.setName("Rita");
		patient.setBirthDate(LocalDate.of(2003, 5, 20));
		patient.setGender("female");
		patientRepository.save(patient);

	    System.out.println(patientRepository.findAll());
	}
}
