package com.management.airport.Rest;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Repository.AirplaneRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api")
public interface AirplaneAPI {
    @GetMapping("/airplanes")
    ResponseEntity<List<AirplaneDTO>> getAllAirplane();
    @PostMapping("/airplanes/id")
    ResponseEntity<Airplane> createAirplane(@RequestBody AirplaneDTO airplaneDTO);
    @GetMapping("/airplanes/model")
    ResponseEntity<List<Airplane>> getByModel(@Param("model") String model);
    @GetMapping("/airplanes/range")
    ResponseEntity<List<Airplane>> getByRangeMoreThan(@Param("range") int range);
    @GetMapping("/airplanes/count")
    ResponseEntity<Integer> countAirplane(@Param("model") String model);
    @GetMapping("/airplane")
    ResponseEntity<Airplane> getAirplaneByModel(@Param("model") String model);
    @GetMapping("/airplanes/distance/model")
    ResponseEntity<List<AirplaneDTO>> showModel(@Param("flightid") String fligthId);
}
