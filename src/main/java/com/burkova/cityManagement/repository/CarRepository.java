package com.burkova.cityManagement.repository;

import com.burkova.cityManagement.model.Car;
import com.burkova.cityManagement.model.Person;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(name = "findAllCarsByPerson")
    List<Car> findAllCarsByPerson(Long id);
}
