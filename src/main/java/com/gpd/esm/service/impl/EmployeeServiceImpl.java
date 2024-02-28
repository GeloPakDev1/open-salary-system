package com.gpd.esm.service.impl;

import com.gpd.esm.domain.Salary;
import com.gpd.esm.dto.EmployeeSalary;
import com.gpd.esm.repository.EmployeeRepository;
import com.gpd.esm.repository.SalaryRepository;
import com.gpd.esm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final SalaryRepository salaryRepository;

    @Override
    public CompletableFuture<List<EmployeeSalary>> getEmployeesSalaries() {
        return employeeRepository.findByHiredTrue()
                .thenComposeAsync(employees -> {
                    List<CompletableFuture<EmployeeSalary>> employeeSalaryFutures = employees.stream()
                            .map(employee -> fetchSalariesForEmployee(employee.getId())
                                    .thenApply(salaries -> calculateTotalEarned(employee.getName(), salaries)))
                            .toList();

                    CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(employeeSalaryFutures.toArray(new CompletableFuture[0]));

                    return allOfFuture.thenApply(v ->
                            employeeSalaryFutures.stream()
                                    .map(CompletableFuture::join)
                                    .collect(Collectors.toList()));
                });
    }

    private CompletableFuture<List<Salary>> fetchSalariesForEmployee(UUID employeeId) {
        return salaryRepository.findByEmployeeId(employeeId);
    }

    private EmployeeSalary calculateTotalEarned(String name, List<Salary> salaries) {
        double totalEarned = salaries.stream().mapToDouble(Salary::getAmount).sum();
        return new EmployeeSalary(name, salaries, totalEarned);
    }
}

