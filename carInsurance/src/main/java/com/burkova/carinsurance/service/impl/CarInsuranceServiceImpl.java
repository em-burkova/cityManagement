package com.burkova.carinsurance.service.impl;

import com.burkova.carinsurance.client.PersonControllerClient;
import com.burkova.carinsurance.exceptions.CarNotFoundedException;
import com.burkova.carinsurance.exceptions.model.CarInsurance;
import com.burkova.carinsurance.repository.CarInsuranceRepository;
import com.burkova.carinsurance.service.CarInsuranceService;
import com.burkova.cityManagement.dto.CarDTO;
import com.burkova.cityManagement.dto.PersonResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarInsuranceServiceImpl implements CarInsuranceService {


   private final CarInsuranceRepository carInsuranceRepository;
   private final PersonControllerClient personControllerClient;


   public List<CarInsurance> createCarInsurance(Long id) {

       PersonResponseDTO personResponseDTO = personControllerClient.getPerson(id);

       List<CarInsurance> carInsurances = new ArrayList<>();
       if (personResponseDTO.getCarsDTO().size() <= 0) {
           throw new CarNotFoundedException();
       }
           for (CarDTO carDTO : personResponseDTO.getCarsDTO()) {
               CarInsurance carInsurance = new CarInsurance();
               carInsurance.setCarId(carDTO.getId());
               carInsurance.setCarNumber(carDTO.getNumber());
               carInsurances.add(carInsurance);
               carInsuranceRepository.save(carInsurance);
               log.info("car insurances created " + carInsurances.size());
           }
       return carInsurances;
   }
}
