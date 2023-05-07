package com.management.airport.Service;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.AirplaneRepository;
import com.management.airport.Repository.CertificationRepository;
import com.management.airport.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.management.airport.Entity.Flight;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CertificationService {
    private final CertificationRepository certificationRepository;
    private final EmployeeRepository employeeRepository;
    private final AirplaneRepository airplaneRepository;
    public List<Certification> getAllCertification(){
      return certificationRepository.findAll();
    }
    public Certification createCertification(CertificationDTO certificationDTO){
        Certification certification = new Certification();

        Employee employee = employeeRepository.findByEmployeeId(certificationDTO.getEmployeeId());
        Airplane airplane = airplaneRepository.findByModel(certificationDTO.getModel());

        certification.setEmployee(employee);
        certification.setAirplane(airplane);

        return certificationRepository.save(certification);
    }
    public List<Certification> getByEmployee(int id){
        return certificationRepository.findByEmployee(id);
    }
    public List<Certification> getByAirplane(int id){
        return certificationRepository.findByAirplane(id);
    }

}
