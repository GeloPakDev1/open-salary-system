package com.gpd.esm.dto;

import com.gpd.esm.domain.Salary;

import java.util.List;

public class EmployeeSalary {
    private final String name;
    private final List<Salary> salaryList;
    private final Double totalEarned;

    public EmployeeSalary(String name, List<Salary> salaryList, Double totalEarned) {
        this.name = name;
        this.salaryList = salaryList;
        this.totalEarned = totalEarned;
    }

    public String getName() {
        return name;
    }

    public Double getTotalEarned() {
        return totalEarned;
    }

    public List<Salary> getSalaryList() {
        return salaryList;
    }
}