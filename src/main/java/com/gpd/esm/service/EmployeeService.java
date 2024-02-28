package com.gpd.esm.service;

import com.gpd.esm.dto.EmployeeSalary;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface EmployeeService {
    CompletableFuture<List<EmployeeSalary>> getEmployeesSalaries();
}