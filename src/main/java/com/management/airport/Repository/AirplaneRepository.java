package com.management.airport.Repository;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    @Query(value = "select * from airport.Airplane where model like ?1 ", nativeQuery = true)
    List<Airplane> likeModel(String model);
    @Query("select a from Airplane a where a.range > ?1")
    List<Airplane> findByRangeMoreThan(int range);
    @Query(value = "select count(id) from airport.Airplane where model like %:model% ", nativeQuery = true)
    int countAirplane(@Param("model") String model);
    Airplane findByModel(String model);
    @Query(value = "select a.* from airport.Flight f, airport.Airplane a where a.range > f.distance and f.flight_id = ?1", nativeQuery = true)
    List<AirplaneDTO> showModel(String flightId);
}
