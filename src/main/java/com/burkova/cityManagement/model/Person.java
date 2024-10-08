package com.burkova.cityManagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
   // private int age;
    private Long bankAccountSum;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Passport passport;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Car> cars;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ref_house_person",
    joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "house_id"))
    private List<House> houses;

}
