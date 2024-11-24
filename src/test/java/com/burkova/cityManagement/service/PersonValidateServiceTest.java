package com.burkova.cityManagement.service;

import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonValidateServiceTest {

    @InjectMocks
    private PersonValidateService personValidateService;

    @Test
    void validatePerson() {
        // given
        Person person = new Person();
        person.setName("5Petr");

        // when
      //  assertThrows(No)

       // then
     //   assertTrue(result);
    }

    //
}