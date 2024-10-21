package com.burkova.foreignpassport.repository;

import com.burkova.foreignpassport.model.ForeignPassport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForeignPassportRepository extends JpaRepository<ForeignPassport, Long> {


}
