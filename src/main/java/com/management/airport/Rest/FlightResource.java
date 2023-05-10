package com.management.airport.Rest;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Airplane;
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
    public ResponseEntity<List<Flight>> getByDepartureStation(String station) {
        return ResponseEntity.ok(flightService.getByDepartureStation(station));
    }

    @Override
    public ResponseEntity<Integer> countTotalNumberOfFlightsByDepartureStation(String station) {
        return ResponseEntity.ok(flightService.countTotalNumberOfFlightsByDepartureStation(station));
    }

    @Override
    public ResponseEntity<String> showFlightIdHasHighestDistance() {
        return ResponseEntity.ok(flightService.showFlightIdHasHighestDistance());
    }


}
