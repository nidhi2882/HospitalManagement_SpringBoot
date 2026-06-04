package com.springboot.hospitalManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitalManagement.dto.LoginRequestDTO;
import com.springboot.hospitalManagement.dto.LoginResponseDTO;
import com.springboot.hospitalManagement.dto.SignupRequestDTO;
import com.springboot.hospitalManagement.dto.SignupResponseDTO;
import com.springboot.hospitalManagement.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final AuthService authService;
	
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO)
	{
		return ResponseEntity.ok(authService.login(loginRequestDTO));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<SignupResponseDTO> signup(@RequestBody SignupRequestDTO signupRequestDTO)
	{
		return ResponseEntity.ok(authService.signup(signupRequestDTO));
	}
}
