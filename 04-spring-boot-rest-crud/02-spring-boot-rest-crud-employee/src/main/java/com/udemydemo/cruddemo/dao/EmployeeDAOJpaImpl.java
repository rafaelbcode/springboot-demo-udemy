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
}
