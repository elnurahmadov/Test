package com.aykan.service.employee.impl;

import com.aykan.dao.employee.EmployeeRepository;
import com.aykan.domain.employee.Employee;
import com.aykan.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return employeeRepository.deleteEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }

    @Override
    public List<Employee> findEmployees() {
        return employeeRepository.findEmployees();
    }

    @Override
    public Long countEmployee() {
        return employeeRepository.countEmployee();
    }

    @Override
    public List<Employee> betweenSalaryEmployees(int minSalary, int maxSalary) {
        return employeeRepository.betweenSalaryEmployees(minSalary, maxSalary);
    }

    @Override
    public List<Employee> findEmployeesFirstMax(int first, int max) {
        return employeeRepository.findEmployeesFirstMax(first, max);
    }
}
