package com.aykan.service.employee;

import com.aykan.domain.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeService {
    boolean saveEmployee(Employee employee);

    boolean deleteEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    @Transactional(readOnly = true)
    Employee findEmployeeById(Long employeeId);

    @Transactional(readOnly = true)
    List<Employee> findEmployees();

    @Transactional(readOnly = true)
    Long countEmployee();

    @Transactional(readOnly = true)
    List<Employee> betweenSalaryEmployees(int minSalary, int maxSalary);

    List<Employee> findEmployeesFirstMax(int first, int max);
}
