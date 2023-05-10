package com.management.airport.Repository;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("select f from Flight f where f.departureStation = ?1")
    List<Flight> findByDepartureStation(String station);
    @Query("select count(f.id) from Flight f where f.departureStation = ?1")
    int countNumber(String station);
    @Query(value = "select f2.flight_id from airport.Flight f2 where f2.distance = (select max(f.distance) from airport.Flight f)", nativeQuery = true)
    String showFlightIdHasHighestDistance();

}
