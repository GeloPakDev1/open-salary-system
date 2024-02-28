package com.gpd.esm.repository;

import com.gpd.esm.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    CompletableFuture<List<Employee>> findByHiredTrue();
}