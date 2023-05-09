package com.management.airport.Service.mapper;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDTO(Employee employee);
    List<EmployeeDTO> toDtos(List<Employee> departments);
}
