package com.management.airport.Rest;

import com.management.airport.DTO.CertificationDTO;
import com.management.airport.Entity.Certification;
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
    public ResponseEntity<List<Certification>> findByEmployeeId(int id) {
        return ResponseEntity.ok(certificationService.getByEmployeeId(id));
    }

    @Override
    public ResponseEntity<Certification> createCertification(CertificationDTO certificationDTO) {
        return ResponseEntity.ok(certificationService.createCertification(certificationDTO));
    }
}
