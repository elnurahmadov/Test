package com.aykan.dao.employee;

import com.aykan.domain.employee.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository {
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
