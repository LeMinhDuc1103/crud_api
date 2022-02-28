package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null) {
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public Employee updateEmployee(long id, Employee employee) {
        if (employee != null) {
            Employee employee2 = employeeRepository.getById(id);
            if (employee2 != null) {
                employee2.setName(employee.getName());
                employee2.setAge(employee.getAge());
                employee2.setAddress(employee.getAddress());
                return employeeRepository.save(employee2);
            }
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(long id) {
        long size = employeeRepository.count();
        if (id >= 1 && id <= size) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getOneEmployee(long id) {
        return employeeRepository.findById(id);
    }
    
}
