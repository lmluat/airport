package com.management.airport.Service;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.AirplaneRepository;
import com.management.airport.Repository.CertificationRepository;
import com.management.airport.Repository.EmployeeRepository;
import com.management.airport.Service.mapper.CertificationMapper;
import com.management.airport.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.management.airport.Entity.Flight;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@Slf4j
public class CertificationService {
    private final CertificationRepository certificationRepository;
    private final EmployeeRepository employeeRepository;
    private final AirplaneRepository airplaneRepository;
    private final CertificationMapper certificationMapper;
    public List<CertificationDTO> getAllCertification(){
      return certificationMapper.toDtos(certificationRepository.findAll());
    }
    public Certification createCertification(CertificationDTO certificationDTO){
        Certification certification = new Certification();

        Employee employee = employeeRepository.findByEmployeeId(certificationDTO.getEmployeeId());
        Airplane airplane = airplaneRepository.findByModel(certificationDTO.getModel());

        certification.setEmployee(employee);
        certification.setAirplane(airplane);

        return certificationRepository.save(certification);
    }
    public List<Certification> getByAirplaneId(Long id){
          List<Certification> list = certificationRepository.findByAirplaneId(id);
          if(list.isEmpty()){
              throw Exception.CertificatoinNotFound();
          }
        return list;
    }
    public List<Certification> getByEmployeeId(Long id){
        return certificationRepository.findByEmployeeId(id);
    }
    public List<CertificationDTO> getCertificationsByEmployeeId(Long id){
        return certificationRepository.findCertificationsByEmployeeId(id);
    }
    public int countNumberOfCertifications(Long id){
        return certificationRepository.countNumberOfCertifications(id);
    }
    public int countCertificationsByAirplaneId(Long id){
        return certificationRepository.countCertificationsByAirplaneId(id);
    }
    public List<String> showInformation(Long id){
        return certificationRepository.showInformation(id);
    }
    public List<String> showQuantity(){
        return certificationRepository.showQuantity();
    }
    public List<Airplane> findAirplaneModelCertsOfEmployee(Long id){
        return certificationRepository.showAirplaneModelCertsOfEmployee(id);
    }
    public List<String> showEmployeeNotPilot(){
        return certificationRepository.showEmployeeNotPilot();
    }
}
