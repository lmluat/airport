package com.management.airport.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Airplane.findByModel", query =" select a from Airplane a where a.model = ?1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "airplane")
public class Airplane {
    @Id
    private Long id;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "range", nullable = false)
    private int range;

}
