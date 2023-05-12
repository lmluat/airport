package com.management.airport.Rest;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api")
public interface EmployeeAPI {
@GetMapping("/employees")
    ResponseEntity<List<EmployeeDTO>> getAllEmployee();
@PostMapping("/employees/id")
    ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO);
@GetMapping("/employeeID")
ResponseEntity<Employee> getByEmployeeId(@RequestParam("id") @NotBlank Long id);
@GetMapping("/employees/id")
    ResponseEntity<EmployeeDTO> getById(@RequestParam("id") @NotBlank Long id);
@GetMapping("/employees/NameAndSalary")
    ResponseEntity<List<Employee>> getByNameAndSalary(@Param("name") String name,
                                                      @Param("salary") String salary);
@GetMapping("/employeeNameAndSalary")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByNameAndSalary(@Param("name") String name,
                                                      @Param("salary") String salary);
@GetMapping("/employeeName")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByName(@Param("name") String name);
@GetMapping("/employee/Name")
    ResponseEntity<List<Employee>> getByName(@Param("name") String name);
@GetMapping("/employee/show")
    ResponseEntity<List<EmployeeDTO>> showList();
}
