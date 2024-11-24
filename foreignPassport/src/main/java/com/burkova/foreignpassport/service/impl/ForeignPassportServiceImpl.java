package com.burkova.foreignpassport.service.impl;


import com.burkova.cityManagement.dto.PersonResponseDTO;
import com.burkova.foreignpassport.exceptions.NotEnoughMoneyException;
import com.burkova.foreignpassport.model.ForeignPassport;
import com.burkova.foreignpassport.repository.ForeignPassportRepository;
import com.burkova.foreignpassport.service.ForeignPassportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class ForeignPassportServiceImpl implements ForeignPassportService {

    private final RestTemplate restTemplate;
    private final ForeignPassportRepository foreignPassportRepository;
    @Value("${personControllerImpl.url}")
    private String apiUrl;

    @Transactional
    public ForeignPassport createForeignPassport(Long id) {

        String url = apiUrl + "/" + id;
        PersonResponseDTO personResponseDTO = restTemplate.getForObject(url, PersonResponseDTO.class);

        if (personResponseDTO.getBankAccountSum() < 5000) {
            throw new NotEnoughMoneyException("Not enough money");
        }
            ForeignPassport foreignPassport = new ForeignPassport();
            foreignPassport.setNumber("123");
            foreignPassport.setPersonId(personResponseDTO.getId());
            foreignPassportRepository.save(foreignPassport);
            log.info("создан паспорт " + foreignPassport.getId() + " " + foreignPassport.getPersonId());
        return foreignPassport;
    }



}
