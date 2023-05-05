package com.management.airport.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CertificationDTO {
    private Long airplaneId;
    private Long employeeId;
}