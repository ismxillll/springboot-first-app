package com.firstassignment1.springboot.model;

import com.firstassignment1.springboot.entity.EmployeeEducation;
import com.firstassignment1.springboot.entity.EmployeeExperiance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
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
    private List<EmployeeEducation> educationDetailsList;
    private List<EmployeeExperiance> experianceDetailsList;


}
