package com.management.airport.Service;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.DTO.FlightDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Flight;
import com.management.airport.Repository.FlightRepository;
import com.management.airport.exception.Exception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;
    public List<Flight> getAllFlight(){
        return flightRepository.findAll();
    }
    public Flight createFlight(FlightDTO flightDTO){

        Flight flight = new Flight();

        flight.setFlightId(flightDTO.getFlightId());
        flight.setDepartureStation(flightDTO.getDepartureStation());
        flight.setArrivalStation(flightDTO.getArrivalStation());
        flight.setDistance(flightDTO.getDistance());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setCost(flightDTO.getCost());

        return flightRepository.save(flight);
    }
    public List<Flight> getByDepartureStation(String station){
        List<Flight> list = flightRepository.findByDepartureStation(station);
        if(list.isEmpty()){
            throw Exception.FlightNotFound();
        }
        return list;
    }
    public int countTotalNumberOfFlightsByDepartureStation(String station){
        return flightRepository.countNumber(station);
    }
    public String showFlightIdHasHighestDistance(){
        return flightRepository.showFlightIdHasHighestDistance();
    }


}
