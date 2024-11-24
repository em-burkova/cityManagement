package com.burkova.carinsurance.repository;

import com.burkova.carinsurance.exceptions.model.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Long> {

}
