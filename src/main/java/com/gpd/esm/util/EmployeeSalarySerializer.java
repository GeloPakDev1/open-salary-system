package com.gpd.esm.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gpd.esm.domain.Salary;
import com.gpd.esm.dto.EmployeeSalary;

import java.io.IOException;

public class EmployeeSalarySerializer extends StdSerializer<EmployeeSalary> {

    public EmployeeSalarySerializer() {
        this(null);
    }

    public EmployeeSalarySerializer(Class<EmployeeSalary> t) {
        super(t);
    }

    @Override
    public void serialize(EmployeeSalary employeeSalary, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", employeeSalary.getName());
        jsonGenerator.writeFieldName("salaryList");
        jsonGenerator.writeStartArray();
        for (Salary salary : employeeSalary.getSalaryList()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("amount", salary.getAmount());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeNumberField("totalEarned", employeeSalary.getTotalEarned());
        jsonGenerator.writeEndObject();
    }
}
