package com.burkova.foreignpassport.service;

import com.burkova.api.dto.PersonResponseDTO;

public interface CarInsuranceService {

    PersonResponseDTO getPersonDTOById(Long id);
}
