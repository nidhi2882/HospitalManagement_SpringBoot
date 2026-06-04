package com.springboot.hospitalManagement.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.hospitalManagement.dto.LoginRequestDTO;
import com.springboot.hospitalManagement.dto.LoginResponseDTO;
import com.springboot.hospitalManagement.dto.SignupRequestDTO;
import com.springboot.hospitalManagement.dto.SignupResponseDTO;
import com.springboot.hospitalManagement.entity.User;
import com.springboot.hospitalManagement.repository.UserRepository;
import com.springboot.hospitalManagement.security.AuthUtil;

@Service
public class AuthService {

	private final AuthenticationManager authenticationManager;
	private final AuthUtil authUtil;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	

	



	public AuthService(AuthenticationManager authenticationManager, AuthUtil authUtil, UserRepository userRepository,
			PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.authUtil = authUtil;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}






	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
        );
		
		User user = (User) authentication.getPrincipal();
		
		String token = authUtil.generateAccessToken(user);
		
		return new LoginResponseDTO(token, user.getId());
		
	}
	
	public SignupResponseDTO signup(SignupRequestDTO signupRequestDTO)
	{
		User user = userRepository.findByUsername(signupRequestDTO.getUsername());
		
		if(user!=null) throw new IllegalArgumentException("User Already Exists");
		
		user = new User();
		user.setUsername(signupRequestDTO.getUsername());
		user.setPassword(passwordEncoder.encode(signupRequestDTO.getPassword()));
		User savedUser = userRepository.save(user);
		return new SignupResponseDTO(savedUser.getId(),savedUser.getUsername());
				
				
				
			
	}

}
