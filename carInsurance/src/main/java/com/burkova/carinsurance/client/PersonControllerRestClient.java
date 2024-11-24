package com.burkova.carinsurance.client;


import com.burkova.cityManagement.dto.PersonResponseDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Profile("rest")
@Component
@Slf4j
@RequiredArgsConstructor
public class PersonControllerRestClient implements PersonControllerClient {

    private final RestTemplate restTemplate;
    @Value("${personControllerImpl.url}")
    private String apiUrl;

    public PersonResponseDTO getPerson(Long id) {
        String url = apiUrl + "/" + id;
        log.info("PersonContrRest client is work");
        return restTemplate.getForObject(url, PersonResponseDTO.class);
    }

}
