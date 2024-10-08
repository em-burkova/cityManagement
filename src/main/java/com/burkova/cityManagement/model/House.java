package com.burkova.cityManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class House {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private int number;
    @ManyToMany(mappedBy = "houses")
    private Set<Person> persons = new HashSet<>();

}
