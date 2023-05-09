package com.management.airport.Rest;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.CertificationRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.management.airport.Entity.Certification;

import java.util.List;

@RequestMapping(value = "/api")
public interface CerficationAPI {
    @GetMapping("/certifications")
    ResponseEntity<List<CertificationDTO>> getAllCertification();
    @PostMapping("/certifications/id")
    ResponseEntity<Certification> createCertification(@RequestBody CertificationDTO certificationDTO);
    @GetMapping("/certifications/airplaneId")
    ResponseEntity<List<Certification>> getByAirplaneId(@Param("id") Long id);
    @GetMapping("/certifications/employeeId")
    ResponseEntity<List<Certification>> getByEmployeeId(@Param("id") Long id);
    @GetMapping("/certifications/employeeID")
    ResponseEntity<List<CertificationDTO>> getCertificationsByEmployeeId(@Param("id") Long id);
    @GetMapping("/certifications/countbyemployeeid")
    ResponseEntity<Integer> countNumberOfCertifications(@Param("id") Long id);
    @GetMapping("/certifications/countbyairplaneid")
    ResponseEntity<Integer> countCertificationsByAirplaneId(@Param("id") Long id);
    @GetMapping("/certifications/showInformation")
    ResponseEntity<List<String>> showInformation(@Param("id") Long id);
    @GetMapping("/certifications/showQuantity")
    ResponseEntity<List<String>> showQuantity();
    @GetMapping("/certifications/findAirplaneModelCertsOfEmployee")
    ResponseEntity<List<Airplane>> findAirplaneModelCertsOfEmployee(@Param("id") Long id);
    @GetMapping("/certifications/showEmployeeNotPilot")
    ResponseEntity<List<String>> showEmployeeNotPilot();
}
