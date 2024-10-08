package com.burkova.cityManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mapstruct.Named;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@org.hibernate.annotations.NamedQuery(name = "findAllCarsByPerson", query = "select c, p from Car c, Person p where p.id = :id")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
//    private double cost;
//    private String licensePlate;
    @DateTimeFormat(pattern = "YYYY-dd-MM")
    private Date creationDate;
    @ManyToOne()
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;


}
