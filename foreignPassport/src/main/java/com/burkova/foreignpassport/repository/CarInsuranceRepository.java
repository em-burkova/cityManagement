package com.burkova.foreignpassport.repository;

import com.burkova.foreignpassport.model.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarInsuranceRepository extends JpaRepository<CarInsurance, Long> {

}
