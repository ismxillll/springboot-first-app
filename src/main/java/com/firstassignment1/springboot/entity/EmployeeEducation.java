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
public class EmployeeEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empId;
    private String degree;
    private Date yearOfPassing;


//    @ManyToOne
//    @JoinColumn(name = "emp_id")
//    @JsonIgnore
//    private Employee employee;
}


