package com.aykan.domain.employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;
    @Column
    private String jobTitle;
    @Column
    private double minSalary;
    @Column
    private double maxSalary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
    private List<Employee> employees;

    public Job() {
    }

    public Job(String jobTitle, double minSalary, double maxSalary, List<Employee> employees) {
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.employees = employees;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        return getJobId() != null ? getJobId().equals(job.getJobId()) : job.getJobId() == null;
    }

    @Override
    public int hashCode() {
        return getJobId() != null ? getJobId().hashCode() : 0;
    }

}
