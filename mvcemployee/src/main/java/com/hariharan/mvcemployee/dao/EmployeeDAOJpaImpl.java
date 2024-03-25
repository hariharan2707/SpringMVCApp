package com.hariharan.mvcemployee.dao;

import com.hariharan.mvcemployee.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //inject Entity Manager
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {    //GET all
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        //execute query
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {    //GET by id
        //get employee
        Employee employee = entityManager.find(Employee.class,id);

        //return employee
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        //Update employee
        Employee employee1 = entityManager.merge(employee);

        return employee1;
    }

    @Override
    public void deleteByID(int id) {
         //find employee by id
        Employee employee = entityManager.find(Employee.class,id);

        //remove employee
        entityManager.remove(employee);
    }
}
