package com.aykan.dao.employee;

import com.aykan.domain.employee.Employee;

public interface EmployeeRepository {
    boolean deleteEmployee(Employee employee);
}
