package com.management.airport.Repository;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Airplane;
import com.management.airport.Entity.Certification;
import com.management.airport.Entity.Employee;
import com.management.airport.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    List<Certification> findByAirplaneId(Long id);
    List<Certification> findByEmployeeId(Long id);
    @Query("select c from Certification c where c.employee.id = ?1")
    List<Certification> findCertificationsByEmployeeId(Long id);
    @Query(value = "select count(id) from airport.Certification where employee_id = ?1", nativeQuery = true)
    int countNumberOfCertifications(Long id);
    @Query(value = "select count(id) from airport.Certification where airplane_id = :airplaneId", nativeQuery = true)
    int countCertificationsByAirplaneId(@Param("airplaneId") Long id);
    @Query(value = "select e.id, e.name, e.salary from airport.Certification c join airport.Employee e on c.employee_id = e.id where c.airplane_id = :airplaneId ", nativeQuery = true)
    List<String> showInformation(@Param("airplaneId") Long id);
    @Query(value = "select count(c.airplane_id), e.name from airport.Certification c join airport.Employee e on c.employee_id = e.id group by c.employee_id, e.name", nativeQuery = true)
    List<String> showQuantity();
    @Query("select c.airplane from Certification c where c.employee.id = ?1")
    List<Airplane> showAirplaneModelCertsOfEmployee(Long id);
    @Query(value = "select e.id, e.name, e.salary from airport.Employee e where e.id not in (select c.employee_id from airport.Certification c )", nativeQuery = true)
    List<String> showEmployeeNotPilot();
    @Query("select c.employee.id from Certification c join Employee e on e.id = c.employee.id group by c.employee.id, e.id having count(c.airplane.id) = 10")
    List<Long> showEmployee();
}
