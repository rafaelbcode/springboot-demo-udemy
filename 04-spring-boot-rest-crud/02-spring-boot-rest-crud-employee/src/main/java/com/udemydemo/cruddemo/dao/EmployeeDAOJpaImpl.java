package com.udemydemo.cruddemo.dao;

import com.udemydemo.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //entity manager field
    private EntityManager entityManager;


    //constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        //find all query
        TypedQuery<Employee> theQuery =
                entityManager.createQuery("from Employee ", Employee.class);

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = this.entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //create or update
        Employee savedEmployee = this.entityManager.merge(theEmployee);

        return savedEmployee;

    }

    @Override
    public void deleteById(int theId) {
        //find by id
        Employee theEmployee = this.entityManager.find(Employee.class, theId);

        //remove
        this.entityManager.remove(theEmployee);

    }
}
