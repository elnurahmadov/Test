package com.aykan.dao.employee;

import com.aykan.domain.employee.Job;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobRepository {
    boolean saveJob(Job job);

    boolean deleteJob(Job job);

    Job updateJob(Job job);

    @Transactional(readOnly = true)
    Job findJobById(Long jobId);

    @Transactional(readOnly = true)
    List<Job> findAllJobs();

    @Transactional(readOnly = true)
    List<String> findJobTitles();
}
