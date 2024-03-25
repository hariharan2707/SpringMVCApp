package com.hariharan.mvcemployee.service;

import com.hariharan.mvcemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();  //GET

    Employee findById(int id); //GET

    Employee update(Employee theEmployee);  //PUT

    void deleteById(int id); //DELETE
}
