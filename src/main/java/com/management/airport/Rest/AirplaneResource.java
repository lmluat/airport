package com.management.airport.Rest;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Service.AirplaneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class AirplaneResource implements AirplaneAPI{
    private final AirplaneService airplaneService;
    @Override
    public ResponseEntity<List<AirplaneDTO>> getAllAirplane() {
        return ResponseEntity.ok(airplaneService.getAllAirplane());
    }

    @Override
    public ResponseEntity<Airplane> createAirplane(AirplaneDTO airplaneDTO) {
        return ResponseEntity.ok(airplaneService.createAirplane(airplaneDTO));
    }

    @Override
    public ResponseEntity<List<Airplane>> getByModel(String model) {
        return ResponseEntity.ok(airplaneService.getByModel(model));
    }

    @Override
    public ResponseEntity<List<Airplane>> getByRangeMoreThan(int range) {
        return ResponseEntity.ok(airplaneService.getByRangeMoreThan(range));
    }

    @Override
    public ResponseEntity<Integer> countAirplane(String model) {
        return ResponseEntity.ok(airplaneService.countAirplane(model));
    }

    @Override
    public ResponseEntity<Airplane> getAirplaneByModel(String model) {
        return ResponseEntity.ok(airplaneService.getAirplaneByModel(model));
    }
    @Override
    public ResponseEntity<List<AirplaneDTO>> showModel(String flightId) {
        return ResponseEntity.ok(airplaneService.showModel(flightId));
    }

}
