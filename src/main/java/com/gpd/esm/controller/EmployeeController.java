package com.gpd.esm.controller;

import com.gpd.esm.dto.EmployeeSalary;
import com.gpd.esm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/salaries")
    public CompletableFuture<List<EmployeeSalary>> getEmployeesWithSalaries() {
        return employeeService.getEmployeesSalaries();
    }
}