package com.firstassignment1.springboot.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String name;
    private Date dob;
    private String communicationAddress;
    private String permanentAddress;
    private String bloodGroup;
    private String emergencyCommunicationNumber;
    private String emergencyContactRelation;
    private String maritalStatus;
    private String mobileNumber;
    private Date doj;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
//    private List<EmployeeEducation> educationDetails;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
//    private List<EmployeeExperiance> experianceDetails;
}