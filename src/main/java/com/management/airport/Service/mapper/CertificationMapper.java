package com.management.airport.Service.mapper;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface CertificationMapper {
    @Mapping(target = "model", source = "certification.airplane.model")
    @Mapping(target = "employeeId", source = "certification.employee.id")
    @Mapping(target = "employee", source = "certification.employee")
    CertificationDTO toDTO(Certification certification);
    List<CertificationDTO> toDtos(List<Certification> certifications);
}
