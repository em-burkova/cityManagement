package com.burkova.cityManagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CarDTO {

    private Long id;
    private String model;
    private Date creationDate;
}
