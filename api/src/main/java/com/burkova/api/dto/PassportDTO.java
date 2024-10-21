package com.burkova.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PassportDTO {

    private Long id;
    private int series;
    private int number;
}
