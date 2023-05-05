package com.management.airport.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name = "Employee.findByEmployeeId",
        query = "select e from Employee e where e.id = ?1"),
@NamedQuery(name = "Employee.findByNameAndSalary",
        query = "select e from Employee e where e.name like :name and e.salary like :salary")})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "salary", nullable = false)
    private String salary;
}
