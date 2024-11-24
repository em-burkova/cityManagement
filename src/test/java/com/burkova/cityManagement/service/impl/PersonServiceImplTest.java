package com.burkova.cityManagement.service.impl;

import com.burkova.cityManagement.exceptions.NameContainsNumbersException;
import com.burkova.cityManagement.model.Passport;
import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.repository.PersonRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PassportServiceImpl passportServiceImpl;
    @InjectMocks
    private PersonServiceImpl personServiceImpl;

    @Test
    void createPerson() {
        // given
        Person person = new Person();
        Passport passport = new Passport();
        person.setId(1L);

        // when
        when(passportServiceImpl.createSeriesAndNumber()).thenReturn(passport);
        when(personRepository.save(person)).thenReturn(person);
        personServiceImpl.createPerson(person);

        // assert
        verify(passportServiceImpl, times(1)).createSeriesAndNumber();
        assertEquals(person.getId(), passport.getId());
    }
// validation exception = custom exception.
    // if person. get() assertThrow(thiserror)

}