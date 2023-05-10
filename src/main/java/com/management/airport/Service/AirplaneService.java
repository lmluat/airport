package com.management.airport.Service;

import com.management.airport.DTO.AirplaneDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Repository.AirplaneRepository;
import com.management.airport.Service.mapper.AirplaneMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirplaneService {
    private final AirplaneRepository airplaneRepository;
    public List<AirplaneDTO> getAllAirplane(){
        return AirplaneMapper.INSTANCE.toDtos(airplaneRepository.findAll());
    }
    public Airplane createAirplane(AirplaneDTO airplaneDTO){
        Airplane airplane = new Airplane();

        airplane.setId(airplaneDTO.getId());
        airplane.setModel(airplaneDTO.getModel());
        airplane.setRange(airplaneDTO.getRange());

        return airplaneRepository.save(airplane);
    }
    public List<Airplane> getByModel(String model){
        return airplaneRepository.likeModel(model);
    }
    public Airplane getAirplaneByModel(String model){
        return airplaneRepository.findByModel(model);
    }
    public List<Airplane> getByRangeMoreThan(int range){
        return airplaneRepository.findByRangeMoreThan(range);
    }
    public int countAirplane(String model){
        return airplaneRepository.countAirplane(model);
    }
    public List<AirplaneDTO> showModel(String flightId){
        return airplaneRepository.showModel(flightId);
    }
}
