package com.management.airport.Repository;

import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query(value = "select * from Flight where departure_station like ?1 ", nativeQuery = true)
    List<Flight> likeDepartStation(String station);
    @Query("select f from Flight f where f.distance > ?1")
    List<Flight> findFlightByDistanceMoreThan(int distance);
    @Query(value = "select count(id) from airport.Flight where departure_station like %:departStation%", nativeQuery = true)
    int countFlight(@Param("departStation") String dpStation);
}
