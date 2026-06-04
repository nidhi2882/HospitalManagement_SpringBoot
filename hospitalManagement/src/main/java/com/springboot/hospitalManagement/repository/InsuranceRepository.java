package com.springboot.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalManagement.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance,Long>{

}
