package com.firstassignment1.springboot.service;


import com.firstassignment1.springboot.entity.Employee;
import com.firstassignment1.springboot.entity.EmployeeEducation;
import com.firstassignment1.springboot.entity.EmployeeExperiance;
import com.firstassignment1.springboot.model.EmployeeRequest;
import com.firstassignment1.springboot.repository.EmployeeEducationRepository;
import com.firstassignment1.springboot.repository.EmployeeExperianceRepository;
import com.firstassignment1.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeEducationRepository employeeEducationRepository;
    @Autowired
    private EmployeeExperianceRepository employeeExperianceRepository;
    public Employee createEmployee(EmployeeRequest employeeRequest) {
        // You can add validation or other business logic here
        // return employeeRepository.save(employee);
        Employee emp = new Employee();
        emp.setName(employeeRequest.getName());
        emp.setDob(employeeRequest.getDob());
        emp.setCommunicationAddress(employeeRequest.getCommunicationAddress());
        emp.setPermanentAddress(employeeRequest.getPermanentAddress());
        emp.setBloodGroup(employeeRequest.getBloodGroup());
        emp.setEmergencyCommunicationNumber(employeeRequest.getEmergencyCommunicationNumber());
        emp.setEmergencyContactRelation(employeeRequest.getEmergencyContactRelation());
        emp.setMaritalStatus(employeeRequest.getMaritalStatus());
        emp.setMobileNumber(employeeRequest.getMobileNumber());
        emp.setDoj(employeeRequest.getDoj());
        Optional<Employee> empResponse = Optional.of(employeeRepository.save(emp));
        Long empId = empResponse.get().getEmpId();
        System.out.println(empId);
        if(empResponse.isPresent()){
            List<EmployeeEducation> listEmpEdu = employeeRequest.getEducationDetailsList();
            if (listEmpEdu != null) {
                listEmpEdu.forEach(employeeEducation -> employeeEducation.setEmpId(empId));
                employeeEducationRepository.saveAll(listEmpEdu);
//                listEmpEdu = listEmpEdu.stream().map(employeeEducation -> employeeEducationRepository.save(employeeEducation)).collect(Collectors.toList());
            }
            List<EmployeeExperiance> listEmpExp = employeeRequest.getExperianceDetailsList();
            if (listEmpExp != null) {
                listEmpExp.forEach(employeeExperiance -> employeeExperiance.setEmpId(empId));
                employeeExperianceRepository.saveAll(listEmpExp);
//                listEmpExp = listEmpExp.stream().map(employeeExperiance -> employeeExperianceRepository.save(employeeExperiance)).collect(Collectors.toList());
            }
        }
        return empResponse.get();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    public Employee updateEmployee(Long empId, Employee updatedEmployee) {
        Employee existingEmployee = employeeRepository.findById(empId).orElse(null);

        if (existingEmployee != null) {
            // Update relevant fields
            existingEmployee.setName(updatedEmployee.getName());
            // Update other fields as needed

            // Save the updated employee
            return employeeRepository.save(existingEmployee);
        }

        return null; // Handle case where employee with empId is not found
    }

    public void deleteEmployee(Long empId) {
        // Delete the employee and associated education/experience details
        employeeRepository.deleteById(empId);
    }


}

