package com.management.airport.DTO;

import com.management.airport.Entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private String salary;
    private Long listCertifications;
    public EmployeeDTO(String name, String salary){
        this.name = name;
        this.salary = salary;
    }
}
