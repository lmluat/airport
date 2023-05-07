package com.management.airport.Repository;

import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    @Query("select c from Certification c where c = ?1")
    List<Certification> findByEmployeeId(int id);
}
