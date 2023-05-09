package com.management.airport.Service.mapper;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface AirplaneMapper {
    AirplaneMapper INSTANCE = Mappers.getMapper(AirplaneMapper.class);
    AirplaneDTO toDTO(Airplane airplane);
    List<AirplaneDTO> toDtos(List<Airplane> airplanes);
}
