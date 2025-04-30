package com.udemydemo.cruddemo.dao;

import com.udemydemo.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
