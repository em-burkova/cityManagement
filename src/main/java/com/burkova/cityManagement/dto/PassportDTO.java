package com.burkova.cityManagement.dto;

import com.burkova.cityManagement.model.Person;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PassportDTO {

    private Long id;
    private int series;
    private int number;
}
