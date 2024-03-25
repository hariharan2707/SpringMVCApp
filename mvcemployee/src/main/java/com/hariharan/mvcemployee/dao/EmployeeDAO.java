package com.hariharan.mvcemployee.dao;

import com.hariharan.mvcemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();  //GET

    Employee findById(int id); //GET

    Employee update(Employee theEmployee);  //POST PUT

    void deleteByID(int id);    //DELETE

}
