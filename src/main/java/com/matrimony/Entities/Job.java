package com.matrimony.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobTittle;
    private String company;
    private double salary;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTittle() {
        return jobTittle;
    }

    public void setJonTittle(String jobTittle) {
        this.jobTittle = jobTittle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Job(String company, Long id, String jobTittle, double salary) {
        this.company = company;
        this.id = id;
        this.jobTittle = jobTittle;
        this.salary = salary;
    }
}
