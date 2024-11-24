package com.burkova.cityManagement.dto;


import com.burkova.cityManagement.model.Gender;
import lombok.Getter;
import lombok.Setter;


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
        private Long bankAccountSum;
        private PassportDTO passportDTO;
        private List<CarDTO> carsDTO;
        private List<HouseDTO> housesDTO;

}
