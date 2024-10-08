package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.exceptions.EntityNotFoundException;
import com.burkova.cityManagement.model.Passport;
import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.repository.PersonRepository;
import com.burkova.cityManagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PassportServiceImpl passportServiceImpl;
    @Lazy
    @Autowired
    private MockPersonServiceImpl mockPersonService;

    @Transactional()
    public Person createPerson(Person person) {
        Passport passport = passportServiceImpl.createSeriesAndNumber();
        person.setPassport(passport);
        passport.setId(person.getId());
        Date current = new Date();
        person.setCreationDate(current);
        Person savedPerson = personRepository.save(person);
        passport.setPerson(savedPerson);
        return savedPerson;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }


    @Transactional
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("не найден по id " + id));
    }

    @Override
    public List<Person> findAllPersonsOnTheSameStreet(String street) {
        return personRepository.findAllPersonsOnTheSameStreet(street);
    }

    @Override
    public List<Person> findAllMalePassportsSurnameStartsWithLetter(String letter) {
        return personRepository.findAllMalePassportsSurnameStartsWithLetter(letter);
    }
}
