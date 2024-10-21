package com.burkova.foreignpassport.service.impl;

import com.burkova.api.dto.PersonResponseDTO;
import com.burkova.foreignpassport.service.CarInsuranceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CarInsuranceServiceImpl implements CarInsuranceService {

   private final RestTemplate restTemplate;
   @Value("${personControllerImpl.url}")
   private final String apiUrl;

   public PersonResponseDTO getPersonDTOById(Long id) {
       String url = apiUrl + "/" + id;
       return restTemplate.getForObject(url, PersonResponseDTO.class);
   }


}
