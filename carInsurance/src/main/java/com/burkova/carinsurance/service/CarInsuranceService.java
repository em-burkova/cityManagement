package com.burkova.carinsurance.service;

import com.burkova.carinsurance.exceptions.model.CarInsurance;
import java.util.List;

public interface CarInsuranceService {

    List<CarInsurance> createCarInsurance(Long id);
}
