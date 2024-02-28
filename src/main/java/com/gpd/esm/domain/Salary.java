package com.gpd.esm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
public class Salary {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID employeeId;
    private Double amount;
    private LocalDateTime issueDate;

}