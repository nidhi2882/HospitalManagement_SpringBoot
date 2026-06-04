package com.springboot.hospitalManagement.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.springboot.hospitalManagement.dto.DoctorResponseDTO;
import com.springboot.hospitalManagement.dto.OnBoardDoctorRequestDTO;
import com.springboot.hospitalManagement.entity.Doctor;
import com.springboot.hospitalManagement.entity.User;
import com.springboot.hospitalManagement.enums.RoleType;
import com.springboot.hospitalManagement.repository.DoctorRepository;
import com.springboot.hospitalManagement.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDTO.class))
                .collect(Collectors.toList());
    }


    public DoctorService(DoctorRepository doctorRepository, ModelMapper modelMapper, UserRepository userRepository) {
		super();
		this.doctorRepository = doctorRepository;
		this.modelMapper = modelMapper;
		this.userRepository = userRepository;
	}


	@Transactional
    public DoctorResponseDTO onBoardNewDoctor(OnBoardDoctorRequestDTO onBoardDoctorRequestDto) {
        User user = userRepository.findById(onBoardDoctorRequestDto.getUserId()).orElseThrow();

        if(doctorRepository.existsById(onBoardDoctorRequestDto.getUserId())) {
            throw new IllegalArgumentException("Already a doctor");
        }

      
        Doctor doctor = new Doctor();
        doctor.setName(onBoardDoctorRequestDto.getName());
        doctor.setSpecialization(onBoardDoctorRequestDto.getSpecialization());
        userRepository.save(user);
        user.getRoles().add(RoleType.DOCTOR);

        return modelMapper.map(doctorRepository.save(doctor), DoctorResponseDTO.class);
    }
}
