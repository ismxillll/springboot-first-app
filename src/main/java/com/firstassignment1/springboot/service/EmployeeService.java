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

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeEducationRepository employeeEducationRepository;
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


/*        List<EmployeeEducation> educationDetails = employeeRequest.getEducationDetailsList();
        List<EmployeeExperiance> experianceDetails = employeeRequest.getExperianceDetailsList();*/

        Optional<Employee> empResponse = Optional.of(employeeRepository.save(emp));
        Long empId = empResponse.get().getEmpId();
        if(empResponse.isPresent()){
            List<EmployeeEducation> listEmpEdu = employee.getEducationDetailsList();
            if (listEmpEdu != null) {
                listEmpEdu.stream().map(employeeEducation -> employeeEducationRepository.save(employeeEducation));
            }
        }
        if(empResponse.isPresent()){
            List<EmployeeExperiance> listEmpEdu = employee.getExperianceDetailsList();
            listEmpEdu.stream().map(employeeExperiance -> employeeExperianceRepository.save(employeeExperiance));
        }
        return empResponse;
    }
        /*emp.setEducationDetails(educationDetails);
        emp.setExperianceDetails(experianceDetails);

        Employee savedEmployee = employeeRepository.save(emp);

        if (educationDetails != null) {
            for (EmployeeEducation education : educationDetails) {
                education.setEmployee(savedEmployee);
                employeeEducationRepository.save(education);
            }
        }
*/
        /*if (experianceDetails != null) {
            for (EmployeeExperiance experiance : experianceDetails) {
                experiance.setEmployee(savedEmployee);
                employeeExperianceRepository.save(experiance);
            }
        }*/


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

