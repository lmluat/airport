package com.management.airport.Repository;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(Long id);
    Optional<Employee> findById(Long id);
    List<Employee> findByNameAndSalary(String name, String salary);

    @Query("select new com.management.airport.DTO.EmployeeDTO(e.name, e.salary) from Employee e where e.name like :name and e.salary like:salary")
    List<EmployeeDTO> findEmployeeByNameAndSalary(String name, String salary);

    @Query(value = "select * from Employee where name = ?1 ", nativeQuery = true)
    List<EmployeeDTO> findByName(String name);
    @Query("select e from Employee e where e.name like :name")
    List<Employee> findEmployeeByName(@Param("name") String name);
    @Query("select new com.management.airport.DTO.EmployeeDTO(e.id,e.name,e.salary,count(c.airplane.id)) from Employee e join Certification c on e.id = c.employee.id group by e.id")
    List<EmployeeDTO> showList();
}
