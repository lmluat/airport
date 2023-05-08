package com.management.airport.Rest;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.CertificationRepository;
import com.management.airport.Service.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class CertificationResource implements CerficationAPI {
    private final CertificationService certificationService;
    @Override
    public ResponseEntity<List<Certification>> getAllCertification() {
        return ResponseEntity.ok(certificationService.getAllCertification());
    }
    @Override
    public ResponseEntity<Certification> createCertification(CertificationDTO certificationDTO) {
        return ResponseEntity.ok(certificationService.createCertification(certificationDTO));
    }

    @Override
    public ResponseEntity<List<Certification>> getByAirplaneId(Long id) {
        return ResponseEntity.ok(certificationService.getByAirplaneId(id));
    }

    @Override
    public ResponseEntity<List<Certification>> getByEmployeeId(Long id) {
        return ResponseEntity.ok(certificationService.getByEmployeeId(id));
    }

    @Override
    public ResponseEntity<List<Certification>> getCertificationsByEmployeeId(Long id) {
        return ResponseEntity.ok(certificationService.getCertificationsByEmployeeId(id));
    }

    @Override
    public ResponseEntity<Integer> countNumberOfCertifications(Long id) {
        return ResponseEntity.ok(certificationService.countNumberOfCertifications(id));
    }

    @Override
    public ResponseEntity<Integer> countCertificationsByAirplaneId(Long id) {
        return ResponseEntity.ok(certificationService.countCertificationsByAirplaneId(id));
    }

    @Override
    public ResponseEntity<List<String>> showInformation(Long id) {
        return ResponseEntity.ok(certificationService.showInformation(id));
    }

    @Override
    public ResponseEntity<List<String>> showQuantity() {
        return ResponseEntity.ok(certificationService.showQuantity());
    }

    @Override
    public ResponseEntity<List<Airplane>> findAirplaneModelCertsOfEmployee(Long id) {
        return ResponseEntity.ok(certificationService.findAirplaneModelCertsOfEmployee(id));
    }

    @Override
    public ResponseEntity<List<String>> showEmployeeNotPilot() {
        return ResponseEntity.ok(certificationService.showEmployeeNotPilot());
    }

    @Override
    public ResponseEntity<List<Long>> showEmployee() {
        return ResponseEntity.ok(certificationService.showEmployee());
    }

}
