package com.burkova.carinsurance.client;


import com.burkova.cityManagement.dto.PersonResponseDTO;

public interface PersonControllerClient {

    PersonResponseDTO getPerson(Long id);
}
