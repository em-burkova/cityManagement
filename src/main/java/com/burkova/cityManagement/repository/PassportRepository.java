package com.burkova.cityManagement.repository;

import com.burkova.cityManagement.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PassportRepository extends JpaRepository<Passport, Long> {
}
