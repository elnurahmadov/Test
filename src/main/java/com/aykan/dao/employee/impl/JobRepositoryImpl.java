package com.aykan.dao.employee.impl;

import com.aykan.dao.employee.JobRepository;
import com.aykan.domain.employee.Job;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JobRepositoryImpl implements JobRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean saveJob(Job job) {
        entityManager.persist(job);
        return true;
    }

    @Override
    public boolean deleteJob(Job job) {
        if (entityManager.contains(job)) {
            entityManager.remove(job);
        } else {
            Job deleteJob = findJobById(job.getJobId());
            entityManager.remove(deleteJob);
        }
        return true;
    }

    @Override
    public Job updateJob(Job job) {
        Job updateJob = entityManager.merge(job);
        return updateJob;
    }

    @Override
    @Transactional(readOnly = true)
    public Job findJobById(Long jobId) {
        return entityManager.createNamedQuery("Job.findEmployeesById", Job.class).setParameter("jobId", jobId).getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Job> findAllJobs() {
        return entityManager.createNamedQuery("Job.findAll", Job.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<String> findJobTitles() {
        return entityManager.createNamedQuery("Job.findJobTitles", String.class).getResultList();
    }
}
