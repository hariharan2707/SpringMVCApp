package com.hariharan.mvcemployee.service;

import com.hariharan.mvcemployee.dao.EmployeeDAO;
import com.hariharan.mvcemployee.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //inject EmployeeDAO
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee theEmployee) {
        return employeeDAO.update(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
      employeeDAO.deleteByID(id);
    }
}
