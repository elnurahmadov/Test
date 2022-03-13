package com.aykan.dao.employee.impl;

import com.aykan.dao.employee.DepartmentRepository;
import com.aykan.domain.employee.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(rollbackFor = {RuntimeException.class, Throwable.class})
public class DepartmentRepositoryImpl implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean saveDepartment(Department department) {
        entityManager.persist(department);
        return true;
    }

    @Override
    public boolean deleteDepartment(Department department) {
        if (entityManager.contains(department)) {
            entityManager.remove(department);
            return true;
        }
        Department deleteDepartment = findDepartmentById(department.getDepartmentId());
        entityManager.remove(deleteDepartment);
        return true;
    }

    @Override
    public Department updateDepartment(Department department) {
        Department updateDepartment = entityManager.merge(department);
        entityManager.flush();
        return updateDepartment;
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentById(Long departmentId) {
        TypedQuery<Department> typedQuery = entityManager.createNamedQuery("Department.findLocationAndEmployeesByDepartmentId", Department.class);
        typedQuery.setParameter("departmentId", departmentId);
        return typedQuery.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {
        return entityManager.createNamedQuery("Department.findAll", Department.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findDepartmentNames() {
        TypedQuery<String> typedQuery = entityManager.createNamedQuery("Department.findByDepartmentName", String.class);
        return typedQuery.getResultList();
    }
}
