package com.udemydemo.cruddemo.service;

import com.udemydemo.cruddemo.dao.EmployeeRepository;
import com.udemydemo.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.employeeRepository.findById(theId);
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
