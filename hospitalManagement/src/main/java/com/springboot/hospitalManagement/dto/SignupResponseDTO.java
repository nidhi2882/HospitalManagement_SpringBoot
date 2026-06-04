package com.springboot.hospitalManagement.dto;

public class SignupResponseDTO {
	
	private Long id;
	private String username;
	public SignupResponseDTO(Long id, String username) {
		super();
		this.setId(id);
		this.setUsername(username);
	}
	
	public SignupResponseDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	};
}
