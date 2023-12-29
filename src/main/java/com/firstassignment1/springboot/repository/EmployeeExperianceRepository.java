package com.firstassignment1.springboot.repository;

import com.firstassignment1.springboot.entity.EmployeeExperiance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeExperianceRepository extends JpaRepository<EmployeeExperiance,Integer> {
}
