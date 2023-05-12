package com.management.airport.Rest;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import com.management.airport.Service.EmployeeService;
import com.management.airport.exception.Exception;
import com.management.airport.exception.RestExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class EmployeeResource implements EmployeeAPI {
    private final EmployeeService employeeService;
    @Override
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<Employee> createEmployee(EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.createEmployee(employeeDTO));
    }

    @Override
    public ResponseEntity<Employee> getByEmployeeId(Long id)  {
        Employee employee =  employeeService.getByEmployeeId(id);
        if(employee == null){
            throw Exception.EmployeeNotFound();
        }
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<EmployeeDTO> getById(Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @Override
    public ResponseEntity<List<Employee>> getByNameAndSalary(String name, String salary) {
        return ResponseEntity.ok(employeeService.getByNameAndSalary(name, salary));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByNameAndSalary(String name, String salary) {
        return ResponseEntity.ok(employeeService.getEmployeesByNameAndSalary(name,salary));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployeeByName(String name) {
        if(name.isBlank()){
            throw Exception.EmployeeNotFound();
        }
        return ResponseEntity.ok(employeeService.getByName(name));
    }

    @Override
    public ResponseEntity<List<Employee>> getByName(String name) {
        return ResponseEntity.ok(employeeService.getEmployeeByName(name));
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> showList() {
        return ResponseEntity.ok(employeeService.showList());
    }

}
