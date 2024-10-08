package com.burkova.cityManagement.dto;


import com.burkova.cityManagement.model.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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
