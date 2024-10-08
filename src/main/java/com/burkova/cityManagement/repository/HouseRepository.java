package com.burkova.cityManagement.repository;

import com.burkova.cityManagement.model.House;
import com.burkova.cityManagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {


}
