package com.burkova.cityManagement.controller;


import com.burkova.cityManagement.dto.PersonRequestCreateDTO;
import com.burkova.cityManagement.dto.PersonResponseDTO;
import com.burkova.cityManagement.mapper.PersonMapper;
import com.burkova.cityManagement.model.Person;
import com.burkova.cityManagement.service.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonControllerImpl {

    //mockMVC json.. model postman object = service.. mock only for repository
    private final PersonService personService;

    public PersonControllerImpl(@Qualifier("personServiceImpl") PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/create")
    public ResponseEntity<PersonResponseDTO> create(@RequestBody PersonRequestCreateDTO personRequestCreateDTO) {
        Person person = PersonMapper.INSTANCE.mapToEntity(personRequestCreateDTO);
        Person savedPerson = personService.createPerson(person);
        PersonResponseDTO result  = PersonMapper.INSTANCE.mapToDTO(savedPerson);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonResponseDTO>> readAll() {
        return new ResponseEntity<>(PersonMapper.INSTANCE.mapToPersonDTO(personService.getAllPersons()), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<PersonResponseDTO> update(@RequestBody PersonResponseDTO personResponseDTO) {
        Person person = PersonMapper.INSTANCE.mapToEntity(personResponseDTO);
        Person savedPerson = personService.update(person);
        PersonResponseDTO result = PersonMapper.INSTANCE.mapToDTO(savedPerson);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getPerson(@PathVariable("id") Long id) {
        Person person = personService.getPerson(id);
        PersonResponseDTO result = PersonMapper.INSTANCE.mapToDTO(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/all/street")
    public ResponseEntity<List<PersonResponseDTO>> findAllPersonsOnTheSameStreet(@PathParam("name") String street) {
        return new ResponseEntity<>(PersonMapper.INSTANCE.mapToPersonDTO(personService.findAllPersonsOnTheSameStreet(street.toLowerCase())), HttpStatus.OK);
    }

    @GetMapping("/all/male/passports/starts")
    public ResponseEntity<List<PersonResponseDTO>> findAllMalePassportsSurnameStartsWithLetter(@PathParam("letter") String letter) {
        return new ResponseEntity<>(PersonMapper.INSTANCE.mapToPersonDTO(personService.findAllMalePassportsSurnameStartsWithLetter(letter)), HttpStatus.OK);
    }
   
}
