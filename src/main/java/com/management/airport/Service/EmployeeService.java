package com.management.airport.Service;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();

        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());

        return employeeRepository.save(employee);
    }
    public Employee getByEmployeeId(Long id){
        return employeeRepository.findByEmployeeId(id);
    }
    public Optional<Employee> getById(Long id){
        return employeeRepository.findById(id);
    }
    public List<Employee> getByNameAndSalary(String name, String salary){
        return employeeRepository.findByNameAndSalary(name, salary);
    }
    public List<Employee> getEmployeesByNameAndSalary(String name, String salary) {
        return employeeRepository.findEmployeeByNameAndSalary(name, salary);
    }
    public List<Employee> getByName(String name) {
        return employeeRepository.findByName(name);
    }
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }

}
