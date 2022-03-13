package com.aykan.dao.employee;

import com.aykan.domain.employee.Department;

import java.util.List;

public interface DepartmentRepository {
    boolean saveDepartment(Department department);

    boolean deleteDepartment(Department department);

    Department updateDepartment(Department department);

    Department findDepartmentById(Long departmentId);

    List<Department> findAllDepartments();

    List<String> findDepartmentNames();

}
