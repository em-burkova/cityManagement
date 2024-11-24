package com.burkova.carinsurance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarInsuranceDTO {

    private Long id;
    private String carNumber;
    private Long personId;
}
