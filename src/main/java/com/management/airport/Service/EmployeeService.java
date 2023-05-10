package com.management.airport.Service;

import com.management.airport.DTO.EmployeeDTO;
import com.management.airport.Entity.Employee;
import com.management.airport.Repository.EmployeeRepository;
import com.management.airport.Service.mapper.EmployeeMapper;
import com.management.airport.exception.Exception;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<EmployeeDTO> getAllEmployee(){
        return EmployeeMapper.INSTANCE.toDtos(employeeRepository.findAll());
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
    public EmployeeDTO getById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(Exception::EmployeeNotFound);
        return EmployeeMapper.INSTANCE.toDTO(employee);
    }
    public List<Employee> getByNameAndSalary(String name, String salary){
        return employeeRepository.findByNameAndSalary(name, salary);
    }
    public List<EmployeeDTO> getEmployeesByNameAndSalary(String name, String salary) {
        return employeeRepository.findEmployeeByNameAndSalary(name, salary);
    }
    public List<EmployeeDTO> getByName(String name) {
        return employeeRepository.findByName(name);
    }
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.findEmployeeByName(name);
    }
    public List<EmployeeDTO> showList(){return employeeRepository.showList();}
}
