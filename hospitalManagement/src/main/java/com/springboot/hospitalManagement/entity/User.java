package com.springboot.hospitalManagement.entity;

import java.util.Collection;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


import com.springboot.hospitalManagement.enums.RoleType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "app_user")
@AllArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
	
	  @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return username;
	    }

		public Long getId() {
			return id;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@ElementCollection(fetch = FetchType.EAGER)
	    @Enumerated(EnumType.STRING)
	    Set<RoleType> roles = new HashSet<>();

		public Set<RoleType> getRoles() {
			return roles;
		}

		public void setRoles(Set<RoleType> roles) {
			this.roles = roles;
		}

		

		

		
}
