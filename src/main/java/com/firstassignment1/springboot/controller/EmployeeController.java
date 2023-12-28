package com.firstassignment1.springboot.controller;

import com.firstassignment1.springboot.entity.Employee;
import com.firstassignment1.springboot.model.EmployeeRequest;
import com.firstassignment1.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public EmployeeResponse createEmployee(@RequestBody EmployeeRequest employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        return new EmployeeResponse(createdEmployee.getEmpId(), createdEmployee.getName());
    }

    @GetMapping("/viewAll")
    public List<Employee> viewAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/view/{empId}")
    public Employee viewEmployee(@PathVariable Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PutMapping("/update/{empId}")
    public Employee updateEmployee(@PathVariable Long empId, @RequestBody Employee updatedEmployee) {
        return employeeService.updateEmployee(empId, updatedEmployee);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployee(@PathVariable Long empId) {
        employeeService.deleteEmployee(empId);
    }

    private static class EmployeeResponse {
        private Long empId;
        private String name;

        public EmployeeResponse(Long empId, String name) {
            this.empId = empId;
            this.name = name;
        }

        // Getters
        public Long getEmpId() {
            return empId;
        }

        public String getName() {
            return name;
        }
    }
}
