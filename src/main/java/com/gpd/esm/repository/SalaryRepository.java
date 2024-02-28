package com.gpd.esm.repository;

import com.gpd.esm.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, UUID> {
    CompletableFuture<List<Salary>> findByEmployeeId(UUID employeeId);
}