package com.springboot.hospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.hospitalManagement.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
