package com.management.airport.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_id", nullable = false)
    private String flightId;
    @Column(name = "departure_station", nullable = false)
    private String departureStation;
    @Column(name = "arrival_station", nullable = false)
    private String arrivalStation;
    @Column(name = "distance", nullable = false)
    private int distance;
    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;
    @Column(name = "arrival_time", nullable = false)
    private LocalTime arrivalTime;
    @Column(name = "cost", nullable = false)
    private String cost;

}
