package com.burkova.foreignpassport.controller;

import com.burkova.api.dto.PersonResponseDTO;
import com.burkova.foreignpassport.service.CarInsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/carinsurance/")
@RequiredArgsConstructor
public class CarInsuranceController {

    private final CarInsuranceService carInsuranceService;

    @GetMapping("person/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonDTOById(@PathVariable Long id) {
      PersonResponseDTO personResponseDTO = carInsuranceService.getPersonDTOById(id);
       return new ResponseEntity<>(personResponseDTO, HttpStatus.OK);
    }
}
