package com.gpd.esm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private Boolean hired;
}