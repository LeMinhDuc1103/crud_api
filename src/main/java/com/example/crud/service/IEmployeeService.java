package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.model.Employee;

public interface IEmployeeService {
    // Create function
    public Employee addEmployee(Employee employee);

    // Update function
    public Employee updateEmployee(long id, Employee employee);

    // Delete function
    public boolean deleteEmployee(long id);

    // Read all employee function
    public List<Employee> getAllEmployee();

    // Get one employyee function
    public Optional<Employee> getOneEmployee(long id);
}
