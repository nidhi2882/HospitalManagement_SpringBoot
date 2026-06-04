package com.springboot.hospitalManagement.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableMethodSecurity
public class WebSecurityConfig {
	private final JwtAuthFilter jwtFilter;
	public WebSecurityConfig(JwtAuthFilter jwtFilter) {
		super();
		this.jwtFilter = jwtFilter;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

	    httpSecurity
	            .csrf(csrf -> csrf.disable())
	            .sessionManagement(session ->
	                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .authorizeHttpRequests(auth -> auth
	                    .requestMatchers("/public/**", "/auth/**").permitAll()
	                    .requestMatchers(HttpMethod.DELETE, "/admin/**").hasRole("ADMIN")
	                    .anyRequest().authenticated()
	            )
	            .httpBasic(Customizer.withDefaults());

	    httpSecurity.addFilterBefore(jwtFilter,
	            UsernamePasswordAuthenticationFilter.class);

	    return httpSecurity.build();
	}


}
