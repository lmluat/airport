package com.management.airport.Service.mapper;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Employee;
import com.management.airport.Entity.Flight;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
    FlightDTO toDTO(Flight flight);
    List<FlightDTO> toDtos(List<Flight> flights);

}
