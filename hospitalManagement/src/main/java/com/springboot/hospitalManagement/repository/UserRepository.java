package com.springboot.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalManagement.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);

}
