package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import com.example.crud.model.Employee;
import com.example.crud.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    
    // API add employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return iEmployeeService.addEmployee(employee);
    }

    // API update employee
    @PutMapping("/update")
    public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee employee) {
        return iEmployeeService.updateEmployee(id, employee);
    }

    // API delete employee
    @DeleteMapping("/delete/{id}")
    public boolean deleteEmployee(@PathVariable(name = "id") long id) {
        return iEmployeeService.deleteEmployee(id);
    }

    // API read all employee
    @GetMapping("/list")
    public List<Employee> getAllEmployee() {
        return iEmployeeService.getAllEmployee();
    }

    // API get one employee
    @GetMapping("getone/{id}")
    public Optional<Employee> getOneEmployee(@PathVariable("id") long id) {
        return iEmployeeService.getOneEmployee(id);
    }
}
