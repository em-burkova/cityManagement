package com.burkova.api.dto;

import lombok.Getter;
import lombok.Setter;
import com.burkova.api.model.Gender;

import java.util.List;

@Setter
@Getter
public class PersonRequestCreateDTO {

    private String name;
    private Gender gender;
    private int age;
    private List<CarDTO> carsDTO;
    private List<HouseDTO> housesDTO;
}
