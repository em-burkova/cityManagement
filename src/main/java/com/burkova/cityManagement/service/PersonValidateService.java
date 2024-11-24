package com.burkova.cityManagement.service;

import com.burkova.cityManagement.exceptions.NameContainsNumbersException;
import com.burkova.cityManagement.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonValidateService {

    public void validatePerson(Person person){
        if (person.getName().matches("[0-9]+")) {
            throw new NameContainsNumbersException("Name contains numbers, pls enter the new name correctly");
        }
    }


}
