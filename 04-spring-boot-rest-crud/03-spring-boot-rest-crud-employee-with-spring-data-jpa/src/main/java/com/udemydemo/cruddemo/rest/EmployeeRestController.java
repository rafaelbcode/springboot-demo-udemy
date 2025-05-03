package com.udemydemo.cruddemo.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.udemydemo.cruddemo.entity.Employee;
import com.udemydemo.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;


    @Autowired
    public EmployeeRestController( EmployeeService employeeService, ObjectMapper objectMapper) {
        this.employeeService = employeeService;
        this.objectMapper = objectMapper;
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

        //ID set to 0 for DB auto assign
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

    //PATCH /employees/{employeeId} - patch employee ... partial update
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String, Object> patchPayload) {

        Employee tempEmployee = this.employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        //throw exception if request body contains "id" key
        if (patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id not allowed in request body - " +employeeId);
        }

        Employee patchedEmployee = apply(patchPayload,tempEmployee);

        Employee savedEmployee = this.employeeService.save(patchedEmployee);


        return savedEmployee;



    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
        //Convert Employee object to JSON object node
        ObjectNode employeeNode = objectMapper.convertValue(tempEmployee,ObjectNode.class);

        //Convert patchPayload map to a JSON object node
        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        //Merge the patch updates into the employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode,Employee.class);

    }

    //DELETE /employees/{employeeId}
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = this.employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;


    }

}
