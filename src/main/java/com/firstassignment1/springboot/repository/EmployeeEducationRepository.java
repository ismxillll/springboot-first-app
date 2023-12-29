package com.firstassignment1.springboot.repository;

import com.firstassignment1.springboot.entity.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEducationRepository extends JpaRepository<EmployeeEducation, Long> {
}
