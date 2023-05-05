package com.management.airport.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightDTO {

    private String flightId;

    private String departureStation;

    private String arrivalStation;

    private int distance;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private String cost;
}
