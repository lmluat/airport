package com.management.airport.DTO;

import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CertificationDTO {
    private String model;
    private Long employeeId;
    private Employee employee;
}
