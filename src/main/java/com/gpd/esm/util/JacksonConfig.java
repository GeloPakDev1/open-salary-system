package com.gpd.esm.util;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.gpd.esm.dto.EmployeeSalary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public SimpleModule customSerializerModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(EmployeeSalary.class, new EmployeeSalarySerializer());
        return module;
    }
}
