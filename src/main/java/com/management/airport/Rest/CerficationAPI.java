package com.management.airport.Rest;

import com.management.airport.DTO.CertificationDTO;
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
    ResponseEntity<List<Certification>> getAllCertification();
    @GetMapping("/certification")
    ResponseEntity<List<Certification>> findByEmployeeId(@Param("id") int id);
    @PostMapping("/certifications/id")
    ResponseEntity<Certification> createCertification(@RequestBody CertificationDTO certificationDTO);
    @GetMapping("/certifications/airplaneid")
    ResponseEntity<List<Certification>> findByAirplaneId(@Param("id") int id);
}
