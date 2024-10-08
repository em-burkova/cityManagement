package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "mockPersonServiceImpl")
@RequiredArgsConstructor
public class MockPersonServiceImpl implements PersonService {

    private final PersonServiceImpl personServiceImpl;

    @Override
    public Person createPerson(Person person) {
        System.out.println("Mock create person");
        return null;
    }

    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Person getPerson(Long id) {
        return null;
    }

    @Override
    public List<Person> findAllPersonsOnTheSameStreet(String street) {
        return null;
    }

    @Override
    public List<Person> findAllMalePassportsSurnameStartsWithLetter(String letter) {
        return null;
    }
}
