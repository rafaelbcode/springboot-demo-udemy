package com.udemydemo.cruddemo.rest;

import com.udemydemo.cruddemo.entity.Employee;
import com.udemydemo.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {
        Employee theEmployee = this.employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        return theEmployee;
    }

    //POST add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee newEmployee = this.employeeService.save(theEmployee);
        return newEmployee;
    }

    //PUT updating existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee newEmployee = this.employeeService.save(theEmployee);
        return newEmployee;
    }




}
