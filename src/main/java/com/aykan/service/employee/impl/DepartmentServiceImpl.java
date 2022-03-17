package com.aykan.service.employee.impl;

import com.aykan.dao.employee.DepartmentRepository;
import com.aykan.domain.employee.Department;
import com.aykan.service.employee.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public boolean saveDepartment(Department department) {
        return departmentRepository.saveDepartment(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        return departmentRepository.deleteDepartment(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.updateDepartment(department);
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findDepartmentById(departmentId);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAllDepartments();
    }

    @Override
    public List<String> findDepartmentNames() {
        return departmentRepository.findDepartmentNames();
    }
}
