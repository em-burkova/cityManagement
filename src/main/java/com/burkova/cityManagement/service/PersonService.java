package com.burkova.cityManagement.service;

import com.burkova.cityManagement.model.Person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);
    List<Person> getAllPersons();
    Person update(Person person);
    void delete(Long id);
    Person getPerson(Long id);
    List<Person> findAllPersonsOnTheSameStreet(String street);
    List<Person> findAllMalePassportsSurnameStartsWithLetter(String letter);
}
