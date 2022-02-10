package org.example.service;

import org.example.model.Employee;
import org.example.repo.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) throws SQLException {
        return employeeRepository.createEmployee(employee);
    }

    @Override
    public Employee updateEmpl(Integer employeeId) throws SQLException {
        return employeeRepository.updateEmpl(employeeId);
    }

    @Override
    public Employee searchEmpl(Integer employeeId) throws SQLException {
        return employeeRepository.searchEmpl(employeeId);
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        return null;
    }
}
