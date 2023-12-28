package com.firstassignment1.springboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExperiance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empId;
    private String company;
    private Date durationFrom;
    private Date durationTo;

//    @ManyToOne
//    @JoinColumn(name = "emp_id")
//    private Employee employee;
}

