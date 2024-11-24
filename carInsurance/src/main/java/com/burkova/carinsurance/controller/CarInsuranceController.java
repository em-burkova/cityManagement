package com.burkova.carinsurance.controller;

import com.burkova.carinsurance.dto.CarInsuranceDTO;
import com.burkova.carinsurance.mapper.CarInsuranceDTOMapper;
import com.burkova.carinsurance.exceptions.model.CarInsurance;
import com.burkova.carinsurance.service.CarInsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/carinsurance")
@RequiredArgsConstructor
public class CarInsuranceController {
    private final CarInsuranceService carInsuranceService;

    @PostMapping("/create/{id}")
    public ResponseEntity<List<CarInsuranceDTO>> createCarInsurance(@PathVariable Long id) {
      List<CarInsurance> carInsurances = carInsuranceService.createCarInsurance(id);
      List<CarInsuranceDTO> carInsuranceDTOS = CarInsuranceDTOMapper.INSTANCE.mapToCarInsuranceListDTO(carInsurances);
       return new ResponseEntity<>(carInsuranceDTOS, HttpStatus.CREATED);
    }


}
