package com.hariharan.mvcemployee.controller;

import com.hariharan.mvcemployee.entity.Employee;
import com.hariharan.mvcemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployee(Model model) {
        //get the employees from db
        List<Employee> employeeList = employeeService.findAll();

        //add to the model
        model.addAttribute("employeeList", employeeList);

        return "employees/listemployees";
    }

    @GetMapping("/showForm")
    public String showFormEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employeeForm",employee);
        return "employees/showformemployee";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(@RequestParam("employeeId") int id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employeeForm",employee);
        return "employees/showformemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employeeForm") Employee employee){
        employeeService.update(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
            employeeService.deleteById(id);

            return "redirect:/employees/list";
    }
}