package com.management.airport.Rest;

import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Flight;
import com.management.airport.Service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightResource implements FlightAPI{
    private final FlightService flightService;
    @Override
    public ResponseEntity<List<Flight>> getAllFlight() {
        return ResponseEntity.ok(flightService.getAllFlight());
    }

    @Override
    public ResponseEntity<Flight> createFlight(FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.createFlight(flightDTO));
    }

    @Override
    public ResponseEntity<List<Flight>> getByDepartureStation(String dpStation) {
        return ResponseEntity.ok(flightService.getByDepartureStation(dpStation));
    }

    @Override
    public ResponseEntity<List<Flight>> getByDistanceMoreThan(int distance) {
        return ResponseEntity.ok(flightService.getByDistanceMoreThan(distance));
    }

    @Override
    public ResponseEntity<Integer> getNumOfFlight(String dpStation) {
        return ResponseEntity.ok(flightService.getNumOfFlight(dpStation));
    }
}
