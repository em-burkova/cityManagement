package com.burkova.api.dto;


import lombok.Getter;
import lombok.Setter;
import com.burkova.api.model.Gender;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonResponseDTO {

        private Long id;
        private String name;
        private Gender gender;
        private int age;
        private Date creationDate;
        private PassportDTO passportDTO;
        private List<CarDTO> carsDTO;
        private List<HouseDTO> housesDTO;

}
