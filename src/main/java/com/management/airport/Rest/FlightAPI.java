package com.management.airport.Rest;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Employee;
import com.management.airport.Entity.Flight;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface FlightAPI {
    @GetMapping("/flights")
    ResponseEntity<List<Flight>> getAllFlight();
    @PostMapping("/flights/id")
    ResponseEntity<Flight> createFlight(@RequestBody FlightDTO flightDTO);
    @GetMapping("/flights/departureStation")
    ResponseEntity<List<Flight>> getByDepartureStation(@Param("station") String station);
    @GetMapping("/flights/count/departurestation")
    ResponseEntity<Integer> countTotalNumberOfFlightsByDepartureStation(@Param("station") String station);
    @GetMapping("/flights/distance/highest")
    ResponseEntity<String> showFlightIdHasHighestDistance();
    @GetMapping("/flights/distance/model")
    ResponseEntity<List<String>> showModel(@Param("flightid") String fligthId);
}
