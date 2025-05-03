package com.udemydemo.cruddemo.service;

import com.udemydemo.cruddemo.dao.EmployeeRepository;
import com.udemydemo.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> employee = this.employeeRepository.findById(theId);

        Employee theEmployee = null;
        if (employee.isPresent()) {
            theEmployee = employee.get();
        } else {
            throw new RuntimeException("Did not find employee with id: " + theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return this.employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        this.employeeRepository.deleteById(theId);
    }
}
