package com.burkova.cityManagement.repository;

import com.burkova.cityManagement.model.Car;
import com.burkova.cityManagement.model.Passport;
import com.burkova.cityManagement.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p, h.street FROM Person p INNER JOIN House h on h.street =:street ")
    List<Person> findAllPersonsOnTheSameStreet(@Param("street")String address);

    @Query(value = "SELECT * FROM passport INNER JOIN person p on p.id = passport.person_id WHERE p.gender = 'MALE' AND p.name ilike '(:letter)%' ", nativeQuery = true)
    List<Person> findAllMalePassportsSurnameStartsWithLetter(@Param("letter")String letter);

}
