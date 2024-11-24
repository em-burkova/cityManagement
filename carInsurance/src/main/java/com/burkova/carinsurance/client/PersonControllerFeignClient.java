package com.burkova.carinsurance.client;

import com.burkova.cityManagement.dto.PersonResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Profile("feign")
@FeignClient(url = "${personControllerImpl.url}", name = "carInsurance")
public interface PersonControllerFeignClient extends PersonControllerClient {

    @GetMapping("/{id}")
    PersonResponseDTO getPerson(@PathVariable Long id);

}
