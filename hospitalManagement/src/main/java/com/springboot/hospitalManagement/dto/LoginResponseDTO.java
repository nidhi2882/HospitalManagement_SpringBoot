package com.springboot.hospitalManagement.dto;





public class LoginResponseDTO {

    private String accessToken;
    private Long userId;

    public LoginResponseDTO(String accessToken, Long userId) {
        this.accessToken = accessToken;
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Long getUserId() {
        return userId;
    }
}